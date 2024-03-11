<?php
 include "conexion.php";

   if ((!empty($_GET['id_usuario']) && !empty($_GET['fecha_inicio'])) || (!empty($_POST['id_usuario']) && !empty($_POST['fecha_inicio'])) ) {
      $id_usuario = (!empty($_POST['id_usuario']))? $_POST['id_usuario'] : $_GET['id_usuario'];;
      $fecha_inicio = (!empty($_POST['fecha_inicio']))? $_POST['fecha_inicio'] : $_GET['fecha_inicio'];;

      $consulta = $base_de_datos->prepare("INSERT INTO cuestionarios(id_usuario, fecha_inicio) VALUES(:idu, :fec)");
      $consulta -> bindParam(':idu', $id_usuario);
      $consulta -> bindParam(':fec', $fecha_inicio);  
      // $consulta1 = $base_de_datos->prepare("SELECT id FROM cuestionarios ORDER BY id DESC LIMIT 1");
      $respuesta = $consulta->execute();

      if($respuesta){
         $id_cuestionario=$base_de_datos->lastInsertId();
         $respuesta = [
                     'status' => true,
                     'mesagge' => "OK##Question##Insert",
                     'id_cuestionario' => $id_cuestionario
         ];
         echo json_encode($respuesta);
      }else{
         $respuesta = [
                        'status' => false,
                        'mesagge' => "ERROR##Question##Insert",
                        'id_cuestionario' => []
                     ];
         echo json_encode($respuesta);
     }
   }else{
      $respuesta = [
                     'status' => false,
                     'mesagge' => "ERROR##DATOS##POST",
                     'id_cuestionario' => []
                  ];
      echo json_encode($respuesta);
  }
?>