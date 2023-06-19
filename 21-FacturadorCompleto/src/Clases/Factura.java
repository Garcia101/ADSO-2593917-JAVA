
package Clases;


public class Factura {
    
    private int id;
    private int cedula_cliente;
    private int cedula_vendedor;
    private String fecha;
    private int total;

    public Factura(int id, int cedula_cliente, int cedula_vendedor, String fecha, int total) {
        this.id = id;
        this.cedula_cliente = cedula_cliente;
        this.cedula_vendedor = cedula_vendedor;
        this.fecha = fecha;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(int cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public int getCedula_vendedor() {
        return cedula_vendedor;
    }

    public void setCedula_vendedor(int cedula_vendedor) {
        this.cedula_vendedor = cedula_vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
