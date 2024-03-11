<?php

require "Conexion.php";

header('Content-Type: application/json');

$response = array();

if (!empty($_POST["id_cuestionario"]) || !empty($_GET["id_cuestionario"])) {
    $idCuestionario = !empty($_POST["id_cuestionario"]) ? $_POST["id_cuestionario"] : $_GET["id_cuestionario"];

    $consulta = $base_de_datos->prepare("SELECT respuestas.*, preguntas.descripcion AS pregunta_descripcion, preguntas.id_correcta, preguntas.url_imagen 
    AS pregunta_url_imagen, opciones.id AS opcion_id, opciones.id_pregunta, opciones.descripcion AS opcion_descripcion 
    FROM respuestas 
    INNER JOIN preguntas 
    ON respuestas.id_pregunta = preguntas.id 
    LEFT JOIN opciones 
    ON preguntas.id = opciones.id_pregunta 
     WHERE respuestas.id_cuestionario = :id_cuestionario");
    $consulta->bindParam(":id_cuestionario", $idCuestionario);
    $consulta->execute();

    $respuestas = array();

    while ($row = $consulta->fetch(PDO::FETCH_ASSOC)) {
        $pregunta = array(
            "id" => $row["id_pregunta"],
            "descripcion" => $row["pregunta_descripcion"],
            "id_correcta" => $row["id_correcta"],
            "url_imagen" => $row["pregunta_url_imagen"],
            "respuesta" => $row["respuesta"],
            "estado" => $row["estado"]
        );

        // Verificar si la pregunta ya existe en el arreglo de respuestas
        $index = array_search($row["id_pregunta"], array_column($respuestas, "pregunta", "id"));

        // Si la pregunta ya existe, agregar la opción a las opciones existentes
        if ($index !== false) {
            $respuestas[$index]["pregunta"]["opciones"][] = array(
                "id" => $row["opcion_id"],
                "descripcion" => $row["opcion_descripcion"]
            );
        } else {
            // Si la pregunta no existe, agregarla al arreglo de respuestas junto con la primera opción
            $respuestas[] = array(
                "pregunta" => $pregunta,
                "opcion" => array(
                    array(
                        "id" => $row["opcion_id"],
                        "descripcion" => $row["opcion_descripcion"]
                    )
                )
            );
        }
    }

    // Construir la respuesta final
    $response["status"] = true;
    $response["respuestas"] = $respuestas;
} else {
    $response["status"] = false;
    $response["message"] = "Error: No se proporcionó el ID del cuestionario.";
}

// Devolver la respuesta en formato JSON
echo json_encode($response);

?>