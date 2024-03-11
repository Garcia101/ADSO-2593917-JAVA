<?php
    include "Conexion.php";

    if((!empty($_GET['id_cuestionario']) && !empty($_GET['id_pregunta']) && !empty($_GET['respuesta']) && !empty($_GET['estado']) && !empty($_GET['fecha'])) || (!empty($_POST['id_cuestionario']) && !empty($_POST['id_pregunta']) && !empty($_POST['respuesta']) && !empty($_POST['estado']) && !empty($_POST['fecha']))){
        $id_cuestionario = (!empty($_POST['id_cuestionario']))? $_POST['id_cuestionario'] : $_GET['id_cuestionario'];
        $id_pregunta = (!empty($_POST['id_pregunta']))? $_POST['id_pregunta'] : $_GET['id_pregunta'];
        $respuesta = (!empty($_POST['respuesta']))? $_POST['respuesta'] : $_GET['respuesta'];
        $estado = (!empty($_POST['estado']))? $_POST['estado'] : $_GET['estado'];
        $fecha = (!empty($_POST['fecha']))? $_POST['fecha'] : $_GET['fecha'];

        $consulta = $base_de_datos->prepare("INSERT INTO respuestas(id_cuestionario, id_pregunta, respuesta, estado, fecha)VALUES(:idc, :idp, :res, :est, :fec)");
        $consulta -> bindParam(':idc', $id_cuestionario);
        $consulta -> bindParam(':idp', $id_pregunta);
        $consulta -> bindParam(':res', $respuesta);
        $consulta -> bindParam(':est', $estado);
        $consulta -> bindParam(':fec', $fecha);
        $respuesta = $consulta -> execute();

        if($respuesta){
            $respuesta = [
                "status" => true,
                "message" => "OK##ANSWER##INSERT"
            ];
            echo json_encode($respuesta);
        }else{
            $respuesta = [
                "status" => false,
                "message" => "ERROR##ANSWER##INSERT"
            ];
            echo json_encode($respuesta);
        }
        
    }else{
        $respuesta = [
            "status" => false,
            "message" => "ERROR##DATOS"
        ];
        echo json_encode($respuesta);
    }
?>