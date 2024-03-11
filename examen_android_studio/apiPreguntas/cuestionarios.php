<?php
    require "Conexion.php";

    if(!empty($_POST["idUsuario"]) || !empty($_GET["idUsuario"])) {

        !empty($_POST["idUsuario"]) ? $id_usuario = (int)$_POST['idUsuario'] : $id_usuario = (int)$_GET['idUsuario'];

        $consulta = $base_de_datos->prepare("SELECT * FROM cuestionarios WHERE id_usuario = :id_usuario");
        $consulta->bindParam(":id_usuario", $id_usuario);
        $consulta->execute();
    
        $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
        $datos = mb_convert_encoding($datos, "UTF-8", "iso-8859-1");
    
        if ($datos) {
            $respuesta = [
                "status" => true,
                "datos" => $datos,
            ];
        } else {
            $respuesta = [
                "status" => false,
                "message" => "no tienes cuestionarios"
            ];
        }

        echo json_encode($respuesta);

    }else {
        $respuesta = [
            "status" => false,
            "message" => "ERROR##DATA"
        ];
    
        echo json_encode($respuesta);
    }
