<?php 

include "Conexion.php";


if ((!empty($_POST["correo"]) && !empty($_POST["password"])) || (!empty($_GET["correo"]) && !empty($_GET["password"]))) {

    // Obtener datos del formulario POST o de la URL GET
    $correo = (!empty($_POST["correo"])) ? $_POST["correo"] : $_GET["correo"];
    $contraseña = (!empty($_POST["password"])) ? md5($_POST["password"]) : md5($_GET["password"]);

    // Consultar la base de datos para verificar las credenciales del usuario
    $consulta = $base_de_datos->prepare("SELECT id_usuario, nombres FROM usuarios WHERE correo = :cor AND password = :pas");
    $consulta->bindParam(":cor", $correo);
    $consulta->bindParam(":pas", $contraseña);
    $consulta->execute();
    
    $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
    $datos = mb_convert_encoding($datos, "UTF-8", "iso-8859-1");

    if ($datos) {
        $respuesta = [
            "status" => true,
            "message" => "Inicio de sesion exitoso",
            "user_data" => $datos[0]
        ];
    } else {
        $respuesta = [
            "status" => false,
            "message" => "Credenciales invalidas"
        ];
    }

    echo json_encode($respuesta);
    
} else {
    $respuesta = [
        "status" => false,
        "message" => "ERROR##DATA"
    ];

    echo json_encode($respuesta);
}
?>
