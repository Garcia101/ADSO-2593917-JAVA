import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.text.NumberFormat;
import java.util.Locale;


public class EjerInterfaz extends JFrame {

    public EjerInterfaz (personas[] listaClientes, PersonaV[] listaVendedores, Productos [] arrayProductos){
		this.listaClientes = listaClientes;																																											
		this.listaVendedores = listaVendedores;
		this.arrayProductos = arrayProductos;

        initComponet();
    }

    public void initComponet(){

        Toolkit sistema = Toolkit.getDefaultToolkit();
		Dimension tamanio = sistema.getScreenSize();

        setVisible(true);
        setTitle("====FACTURA====");
        setSize( tamanio.width/2 , tamanio.height/2 );
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());
        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints restriccion = new GridBagConstraints();

        JLabel datosCliente = new JLabel("DATOS CLIENTE");
        restriccion.gridy = 0;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 1;
		restriccion.weightx = 100;
        datosCliente.setFont(new Font("Arial", Font.BOLD, 15));
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( datosCliente, restriccion );


        JLabel cedula  = new JLabel("cedula: ");
        restriccion.gridy = 1;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( cedula, restriccion );

        // JLabel cedula = new JLabel("cedula"); 

        JTextField campoCedula = new JTextField();
        restriccion.gridy = 1;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 1;
		restriccion.weightx = 80;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoCedula, restriccion );

        JButton buscar = new JButton("buscar");
        restriccion.gridy = 1;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add(  buscar, restriccion );

        JLabel nombre = new JLabel("nombre: ");
        restriccion.gridy = 2;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( nombre, restriccion );

        JTextField campoNombre = new JTextField();
        restriccion.gridy = 2;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 90;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoNombre, restriccion );

        JLabel direccion = new JLabel("direccion");
        restriccion.gridy = 3;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( direccion, restriccion );

        JTextField campoDireccion = new JTextField();
        restriccion.gridy = 3;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 90;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoDireccion, restriccion );

        JLabel datosVendedor = new JLabel("datos vendedor: ");
        restriccion.gridy = 4;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 1;
		restriccion.weightx = 100;
        restriccion.insets = new Insets(0, 0, 10, 0);
        datosVendedor.setFont(new Font("Arial", Font.BOLD, 15));
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( datosVendedor, restriccion );

        JLabel cedula1 = new JLabel("cedulas: ");
        restriccion.gridy = 5;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( cedula1, restriccion );

        JTextField campoCedula1 = new JTextField();
        restriccion.gridy = 5;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 1;
		restriccion.weightx = 80;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoCedula1, restriccion );

        JButton buscar1 = new JButton("buscar");
        restriccion.gridy = 5;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( buscar1, restriccion );

        JLabel nombre1 = new JLabel("nombres: ");
        restriccion.gridy = 6;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( nombre1, restriccion ); 

        JTextField campoNombres1 = new JTextField();
        restriccion.gridy = 6;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 90;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoNombres1, restriccion );

        JLabel productos = new JLabel("lista de productos facturados: ");
        restriccion.gridy = 7;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
        productos.setFont(new Font("Arial", Font.BOLD, 15));
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( productos, restriccion );

        JLabel cantidad = new JLabel("10");
        restriccion.gridy = 8;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        cantidad.setHorizontalAlignment(JLabel.CENTER);
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( cantidad, restriccion );

        JLabel nombre2 = new JLabel("nombre");
        restriccion.gridy = 8;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        nombre2.setHorizontalAlignment(JLabel.CENTER);
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( nombre2, restriccion );

        JLabel cant = new JLabel("cant");
        restriccion.gridy = 8;
		restriccion.gridx = 2;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        cant.setHorizontalAlignment(JLabel.CENTER);
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( cant, restriccion );

        JButton boton1 = new JButton("agregar");
        restriccion.gridy = 8;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( boton1, restriccion );

        JTextField campoCantidad = new JTextField();
        restriccion.gridy = 9;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoCantidad, restriccion );

        JTextField campoNombree = new JTextField();
        restriccion.gridy = 9;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoNombree, restriccion );

        JTextField campoCant = new JTextField();
        restriccion.gridy = 9;
		restriccion.gridx = 2;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoCant, restriccion );

        JButton botonAgregar = new JButton("agregar");
        restriccion.gridy = 9;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( botonAgregar, restriccion );

        JLabel campoGrande = new JLabel("---");
        campoGrande.setOpaque(true);
        campoGrande.setBackground(Color.white);
        restriccion.gridy = 10;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 100;
		restriccion.weightx = 30;
		restriccion.fill = GridBagConstraints.BOTH;
		contenedor.add( campoGrande, restriccion );

        add(contenedor);
		setResizable(false);
		setVisible(true);
		revalidate();
		repaint();



    }

}
