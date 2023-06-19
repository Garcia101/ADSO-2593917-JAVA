package Clases;

import java.sql.*;

public class DataBase {
    
    Statement manipularDB;
    
    public DataBase(){
        String hostname = "localhost";
        String puerto = "3306";
        String database_name = "almacenes";
        String database_user = "root";
        String database_password = "";
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try{
            Connection conexion = DriverManager.getConnection(url, database_user, database_password);
            this.manipularDB = conexion.createStatement();
            System.out.println("Conexion Exitosa a: "+database_name);
        }catch(SQLException e){
            System.out.println("Error en conexion: "+e.getMessage());
            this.manipularDB = null;
        }
    }
    
    public Persona[] listaClientes(){
        Persona [] listaClientes = new Persona [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM clientes");
            registros.next();
            if (registros.getRow()==1) {
                int indice = 0;
                do{
                    Persona temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
                    listaClientes[indice] = temp;
                    indice++;
                }while(registros.next());
            }
            return listaClientes;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaClientes;
        }
    }
    
    public Persona[] listaVendedores(){
        Persona [] listaClientes = new Persona [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM vendedores");
            registros.next();
            if (registros.getRow()==1) {
                int indice = 0;
                do{
                    Persona temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
                    listaClientes[indice] = temp;
                    indice++;
                }while(registros.next());
            }
            return listaClientes;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaClientes;
        }
    }
    
    public Producto[] listaProductos(){
        Producto [] listaProductos = new Producto [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM productos");
            registros.next();
            if (registros.getRow()==1) {
                int indice = 0;
                do{
                    Producto temp = new Producto(registros.getInt("id"),registros.getString("nombre"),registros.getInt("precio"));
                    listaProductos[indice] = temp;
                    indice++;
                }while(registros.next());
            }
            return listaProductos;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaProductos;
        }
    }
    
    public Persona buscarCliente(String cedula){
        Persona temp = null;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM clientes WHERE cedula='"+cedula+"' ");
            registros.next();
            if (registros.getRow()==1) {
                temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
            }
            return temp;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return temp;
        }
    }
    
    public Persona buscarVendedor(String cedula){
        Persona temp = null;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM vendedores WHERE cedula='"+cedula+"' ");
            registros.next();
            if (registros.getRow()==1) {
                temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
            }
            return temp;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return temp;
        }
    }
    
    public Producto buscarProducto(String codigo){
        Producto temp = null;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM productos WHERE id='"+codigo+"' ");
            registros.next();
            if (registros.getRow()==1) {
                temp = new Producto( registros.getInt("id"),registros.getString("nombre"), registros.getInt("precio") );
            }
            return temp;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return temp;
        }
    }
    
    public boolean editarCliente(Persona persona){
        boolean respuesta = false;
        String cedula = persona.getCedula();
        String nombres = persona.getNombres();
        String apellidos = persona.getApellidos();
        String telefono = persona.getTelefono();
        String direccion = persona.getDireccion();
        String email = persona.getEmail();
        
        try {
            String consulta = "UPDATE clientes SET nombres='"+nombres+"', apellidos='"+apellidos+"', telefono='"+telefono+"', direccion='"+direccion+"', email='"+email+"' WHERE cedula='"+cedula+"'";
            int resp = manipularDB.executeUpdate(consulta);
            if (resp>0) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en UPDATE: "+ex.getMessage());
        }
        return respuesta;
    }
    
    public boolean editarVendedor(Persona persona){
        boolean respuesta = false;
        String cedula = persona.getCedula();
        String nombres = persona.getNombres();
        String apellidos = persona.getApellidos();
        String telefono = persona.getTelefono();
        String direccion = persona.getDireccion();
        String email = persona.getEmail();
        
        try {
            String consulta = "UPDATE vendedores SET nombres='"+nombres+"', apellidos='"+apellidos+"', telefono='"+telefono+"', direccion='"+direccion+"', email='"+email+"' WHERE cedula='"+cedula+"'";
            int resp = manipularDB.executeUpdate(consulta);
            if (resp>0) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en UPDATE: "+ex.getMessage());
        }
        return respuesta;
    }
    
    public boolean editarProductos(Producto producto){
        boolean respuesta = false;
        int codigo = producto.getId();
        String nombre = producto.getNombre();
        int precio = producto.getPrecio();

        try {
            String consulta = "UPDATE productos SET nombre = '"+nombre+"', precio = '"+precio+"' WHERE id = "+codigo;
            int resp = manipularDB.executeUpdate(consulta);
            if (resp > 0) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en UPDATE: "+ex.getMessage());
        }
        return respuesta;
    }

    
    public boolean insertarCliente(String cedula, String nombres, String apellidos, String telefono, String direccion, String email){
        String consulta = "INSERT INTO clientes(cedula, nombres, apellidos, telefono, direccion, email) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+direccion+"','"+email+"') ";    
        try{
            int respuesta = manipularDB.executeUpdate(consulta);
            if (respuesta>0) {
                System.out.println("REGISTRO INSERTADO CON EXITO");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error al insertar: "+e.getMessage());
            return false;
        }
    }
    
    public boolean insertarVendedor(String cedula, String nombres, String apellidos, String telefono, String direccion, String email){
        String consulta = "INSERT INTO vendedores(cedula, nombres, apellidos, telefono, direccion, email) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+direccion+"','"+email+"') ";    
        try{
            int respuesta = manipularDB.executeUpdate(consulta);
            if (respuesta>0) {
                System.out.println("REGISTRO INSERTADO CON EXITO");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error al insertar: "+e.getMessage());
            return false;
        }
    }
    
    public boolean insertarProducto(String id, String nombres, String precio){
        String consulta = "INSERT INTO productos(id, nombre, precio) VALUES ('"+id+"','"+nombres+"','"+precio+"') ";    
        try{
            int respuesta = manipularDB.executeUpdate(consulta);
            if (respuesta>0) {
                System.out.println("REGISTRO INSERTADO CON EXITO");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error al insertar: "+e.getMessage());
            return false;
        }
    }
    
     /*Metoodo para eliminar un cliente de la BD */
    public boolean eliminarCliente (Persona persona){
        boolean respuesta=false;
        String cedula =persona.getCedula();
        try {
            String consulta = "DELETE FROM clientes WHERE cedula='"+cedula+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
            respuesta = true;
        }
        } catch (SQLException e) {
         System.out.println("--> Error Delete: " + e.getMessage());
        }

        if (respuesta){
           System.out.println("Eliminado con exito");
        }else{
            System.out.println("No se pudo Eliminar");
        }
        return  true;
    }
    
    
    
    /*Metoodo Para Eliminar Un Vendedor De La BD */
   public boolean eliminarVendedor (Persona persona){
        boolean respuesta=false;
        String cedula =persona.getCedula();
        try {
            String consulta = "DELETE FROM vendedores WHERE cedula='"+cedula+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
            respuesta = true;
           }
        } catch (SQLException ex) {
            System.out.println("--> Error Delete: " + ex.getMessage());
        }

        if (respuesta){
            System.out.println("Eliminado con exito");
        }else{
            System.out.println("No se pudo Eliminar");
        }
        return true;
    }
       
    /*Metodo Para Eliminar Un Producto De La BD */
    public boolean eliminarProducto(int id){
        boolean respuesta = false;
        try {
            String consulta = "DELETE FROM productos WHERE id='"+id+"'";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("--> Error Delete: " + e.getMessage());
        }
        return respuesta;
    }
    
    public boolean registrarFactura(int id,String cedulaCliente,String cedulaVendero, String fecha, int total){
        boolean respuesta = false;
        try {
            String consulta = "INSERT INTO facturas (id,cedula_cliente,cedula_vendedor,fecha,total) VALUES ('"+id+"','"+cedulaCliente+"','"+cedulaVendero+"','"+fecha+"','"+total+"')";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("--> Error Delete: " + e.getMessage());
        }
        return respuesta;
    }
    
    public boolean registrarItemsFactura (String nombre,int id,int id_factura, int id_producto, int id_cantidad, int subtotal){
        boolean respuesta = false;
        try {
            String consulta = "INSERT INTO items_factura (nombre,id,id_factura,id_producto,cantidad,subtotal) VALUES ('"+nombre+"','"+id+"','"+id_factura+"','"+id_producto+"','"+id_cantidad+"','"+subtotal+"')";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if (resp_consulta==1) {
                respuesta = true;
            }
        } catch (SQLException e) {
            //Alert alerta = new Alert("902", "Los datos no se pudieron registrar.", "error");
            System.out.println("--> Error Delete: " + e.getMessage());
        }
        return respuesta;
    }
    public Factura [] buscarFactura(){
        Factura [] listaFactura = new Factura[100] ;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM facturas");
            registros.next();
            if (registros.getRow()==1){
                int indice = 0;
                do{
                   Factura temp = new Factura(registros.getInt("id"), registros.getInt("cedula_cliente"), registros.getInt("cedula_vendedor"), registros.getString("fecha"), registros.getInt("total"));
                   listaFactura[indice] = temp;
                   indice++;
                }while(registros.next());
            }
            return listaFactura;
        }catch (SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaFactura;
        }
    }
    
    public ItemFactura [] listaItems(){
        ItemFactura [] listaItems = new ItemFactura [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM items_factura");
            registros.next();
            if(registros.getRow()==1){
                int indice = 0;
                do{
                   ItemFactura temp = new ItemFactura(registros.getString("nombre"),registros.getInt("id"),registros.getInt("id_factura"),registros.getInt("id_producto"),registros.getInt("cantidad"),registros.getInt("subtotal"));
                   listaItems[indice] = temp;
                   indice++;
                }while(registros.next());
            }
            return listaItems;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaItems;
        }
            
        
    }
    
    public Factura [] listaFacturas(){
        Factura [] listaFacturas = new Factura [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM facturas");
            registros.next();
            if(registros.getRow()==1){
                int indice = 0;
                do{
                   Factura temp = new Factura(registros.getInt("id"), registros.getInt("cedula_cliente"), registros.getInt("cedula_vendedor"), registros.getString("fecha"), registros.getInt("total") );
                   listaFacturas[indice] = temp;
                   indice++;
                }while(registros.next());
            }
            return listaFacturas;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaFacturas;
        }
    }
    
    
}

//Persona temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );

