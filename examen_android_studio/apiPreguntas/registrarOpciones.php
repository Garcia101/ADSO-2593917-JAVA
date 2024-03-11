<?php
    include "conexion.php";

    if((!empty($_GET['id_cuestionario'])) || (!empty($_POST['id_cuestionario'])) ){
        $id_cuestionario =(!empty($_POST['id_cuestionario']))? $_POST['id_cuestionario'] : $_GET['id_cuestionario'];
        $consulta_r = $base_de_datos->prepare("SELECT * FROM respuestas WHERE id_cuestionario = :idc");
        $consulta_r->bindParam(":idc", $id_cuestionario);
        $consulta_r->execute();
        $preguntas = $consulta_r->fetchAll(PDO::FETCH_ASSOC);

        if($preguntas){
            $respuesta=[
                        'status' => true,
                        'message' => 'Ok',
                        'respuesta' => []
            ];
            foreach ($preguntas as $pregunta) {
                $id_respuesta = $pregunta['id_pregunta'];
                $consulta_p = $base_de_datos->prepare("SELECT  preguntas.id, preguntas.descripcion, preguntas.id_correcta, preguntas.url_imagen,respuestas.id_respuesta, respuestas.respuesta, respuestas.estado 
                                                        FROM preguntas 
                                                        JOIN respuestas ON respuestas.id_pregunta = preguntas.id 
                                                        WHERE id = :idr AND respuestas.id_cuestionario=$id_cuestionario");
                $consulta_p->bindParam(":idr",$id_respuesta);
                $consulta_p->execute();
                $pregunta = $consulta_p->fetch(PDO::FETCH_ASSOC);

                if($pregunta){
                    $opciones = $base_de_datos->prepare("SELECT * FROM opciones WHERE id_pregunta=:idr");
                    $opciones->bindParam(":idr", $id_respuesta);
                    $opciones->execute();
                    $opcion = $opciones->fetchAll(PDO::FETCH_ASSOC);

                    $respuesta['respuesta'][] = [
                        'pregunta' => $pregunta,
                        'opciones' => $opcion
                    ];
                }
            }

            // foreach ($preguntas as $pregunta) {
            //     $id_respuesta = $pregunta['id_pregunta'];
            //     $consulta_p = $base_de_datos->prepare("SELECT  preguntas.id, preguntas.descripcion, preguntas.id_correcta, preguntas.url_imagen,respuestas.id_respuesta, respuestas.respuesta, respuestas.estado 
            //                                             FROM preguntas 
            //                                             JOIN respuestas ON respuestas.id_pregunta = preguntas.id 
            //                                             WHERE id = :idr");
            //     $consulta_p->bindParam(":idr",$id_respuesta);
            //     $consulta_p->execute();
            //     $pregunta = $consulta_p->fetchAll(PDO::FETCH_ASSOC);

            //     if($pregunta){
            //         $opciones = $base_de_datos->prepare("SELECT * FROM opciones WHERE id_pregunta=:idr");
            //         $opciones->bindParam(":idr", $id_respuesta);
            //         $opciones->execute();
            //         $opcion = $opciones->fetchAll(PDO::FETCH_ASSOC);

            //         $respuesta['respuesta'][] = [
            //             'preguntas' => $pregunta,
            //             'opciones' => $opcion,
            //         ];

            //     }
            // }
            echo json_encode($respuesta);
            
        }else{
            $respuesta = [
                'status' => false,
                'message' =>'QUESTION##NOT##FOUND'
            ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'message' =>'ERROR##GET'
        ];
        echo json_encode($respuesta);
    }
?>