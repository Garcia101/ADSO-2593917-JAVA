public class personas {
    String cedula;
    String nombre;
    String direccion;
    String [] listaPersonas; 

    public personas(String cedula, String nombre, String direccion){
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaPersonas = new String[15];
    }

    //getters 
    public String cedula(){
        return this.cedula;
    }

    public String nombre(){
        return this.cedula;
    }

    public String direccion(){
        return this.cedula;
    }

    public void buscar(String cedula, String nombre, String direccion){
        
    }

}