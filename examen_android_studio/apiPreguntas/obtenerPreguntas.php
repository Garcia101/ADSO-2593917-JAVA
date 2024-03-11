<?php
    include "conexion.php";

    if(!empty($_GET['id_cuestionario']) || !empty($_POST['id_cuestionario']) ){

        $id_cuestionario = (!empty($_POST['id_cuestionario']))? $_POST['id_cuestionario'] : $_GET['id_cuestionario'];

        try{
            $consulta = $base_de_datos->prepare("SELECT preguntas.* FROM preguntas WHERE preguntas.id NOT IN(SELECT respuestas.id_pregunta FROM respuestas WHERE id_cuestionario = :idc)");
            $consulta ->bindParam(':idc', $id_cuestionario);
            $consulta ->execute();
            $preguntas = $consulta->fetchAll(PDO::FETCH_ASSOC);
            $posicion = random_int(0, sizeof($preguntas)-1);
            $pregunta = $preguntas[$posicion];

            $consulta_o = $base_de_datos->prepare("SELECT * FROM opciones WHERE id_pregunta = :idp");
            $consulta_o ->bindParam(':idp', $pregunta['id']);
            $consulta_o -> execute();
            $opciones = $consulta_o->fetchAll(PDO::FETCH_ASSOC);

            if($pregunta){
                $respuesta =[
                    "status" => true,
                    "message" => "OK",
                    "cant_preguntas" => sizeof($preguntas),
                    "preguntas" =>$pregunta,
                    "opciones" =>$opciones
                ];

                echo json_encode($respuesta);
            }

        }catch(PDOException $e){
            echo json_encode([
                "status" => false,
                "message" => "Error en la consulta ".$e->getMessage()
            ]);
            
        }
 
    }
?>