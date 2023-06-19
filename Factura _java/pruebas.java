public class pruebas {
    
    public static void main(String[] args){
        EjerInterfaz factura = new EjerInterfaz();
        personas listaClientes[] = new personas[100];
		PersonaV listaVendedores[] = new PersonaV[10];
		Productos arrayProductos[] = new Productos[10];

		listaClientes[0] = new personas("108800", "Oscar Loaiza", "Calle 20");
		listaClientes[1] = new personas("108801", "Daniel Garcia", "Calle 19");
		listaClientes[2] = new personas("108802", "Juan Lopez", "Calle 18");
		listaClientes[3] = new personas("108803", "Catalina Mendez", "Calle 17");
		listaClientes[4] = new personas("108804", "Andres Lopez", "Calle 16");

		listaVendedores[0] = new PersonaV("55550001", "Kley Mattar");

		arrayProductos[0] = new Productos("7121100001", "Arroz", 2000);
		arrayProductos[1] = new Productos("7700304607808", "Aceite", 2000);
		arrayProductos[2] = new Productos("7909189205998", "Atun", 2000);
		arrayProductos[3] = new Productos("7700304670574", "Frijoles", 2000);
    }
}
