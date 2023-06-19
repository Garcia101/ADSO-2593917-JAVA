package ModuloFacturas;

import Clases.ItemFactura;
import Clases.Persona;
import Clases.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDate;
import Principal.Menu;
import Principal.Alert;

public class CrearFactura extends JFrame{
    
    // Metodos
    public CrearFactura(Menu ventanaMenu){
        this.ventanaMenu = ventanaMenu;

        this.listaClientes = this.ventanaMenu.database.listaClientes();
        this.listaVendedores = this.ventanaMenu.database.listaVendedores();
        this.listaProductos = this.ventanaMenu.database.listaProductos();
        this.listaFactura = new ItemFactura[100];
        
        this.ingresarCliente = "";
        this. ingresarProducto = "";
        this. ingresarProducto = "";
        this.cedulaCliente = "";
        this.cedulaVendedor = "";
        this.i = 1;
        this.j = 0;
        this.guardarPrecio = 0;
        this.precioTotal = 0;
        initComponent();
    }

    public void initComponent(){
        Toolkit sistema = Toolkit.getDefaultToolkit();
        Dimension tamanio = sistema.getScreenSize();

        setTitle("FACTURA");
        setSize( ((int) (tamanio.width*0.4)) , ((int) (tamanio.height*0.9)) );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo(null);
        
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_almacenes.png") ) );
        
        contPrincipal.setLayout(new GridBagLayout());
        contPrincipal.setBorder( BorderFactory.createEmptyBorder(20, 20, 20, 10) );

        etq_datos_cliente = new JLabel("DATOS CLIENTE:");
        etq_datos_cliente.setFont( new Font("Arial", Font.BOLD, 20) );
        etq_datos_cliente.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 2;
        restriccion.weightx = 100;
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_datos_cliente, restriccion );

        etq_cedula_cliente = new JLabel("CEDULA:");
        restriccion.gridy = 1;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_cedula_cliente, restriccion );

        input_cedula_cliente = new JTextField();
        input_cedula_cliente.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
        restriccion.gridy = 1;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 2;
        restriccion.weighty = 2;
        restriccion.weightx = 80;
        restriccion.insets = new Insets(0, 10, 0, 10);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_cedula_cliente, restriccion );

        btn_buscar_cliente = new JButton("BUSCAR");
        restriccion.gridy = 1;
        restriccion.gridx = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( btn_buscar_cliente, restriccion );

        etq_nombres_cliente = new JLabel("NOMBRES:");
        restriccion.gridy = 2;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(10, 0, 10, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_nombres_cliente, restriccion );

        input_nombres_cliente = new JTextField();
        input_nombres_cliente.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
        restriccion.gridy = 2;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3;
        restriccion.weighty = 2;
        restriccion.weightx = 90;
        restriccion.insets = new Insets(10, 10, 10, 10);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_nombres_cliente, restriccion );

        etq_direccion_cliente = new JLabel("DIRECCION:");
        restriccion.gridy = 3;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 10, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_direccion_cliente, restriccion );

        input_direccion_cliente = new JTextField();
        input_direccion_cliente.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
        restriccion.gridy = 3;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3;
        restriccion.weighty = 2;
        restriccion.weightx = 90;
        restriccion.insets = new Insets(0, 10, 10, 10);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_direccion_cliente, restriccion );

        /*
                - Seccion vendedor
        */
        etq_datos_vendedor = new JLabel("DATOS VENDEDOR:");
        etq_datos_vendedor.setFont( new Font("Arial", Font.BOLD, 20) );
        etq_datos_vendedor.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
        restriccion.gridy = 4;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 2;
        restriccion.weightx = 100;
        restriccion.insets = new Insets(10, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_datos_vendedor, restriccion );

        etq_vendedor_cliente = new JLabel("CEDULA:");
        restriccion.gridy = 5;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_vendedor_cliente, restriccion );

        input_cedula_vendedor = new JTextField();
        input_cedula_vendedor.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
        restriccion.gridy = 5;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 2;
        restriccion.weighty = 2;
        restriccion.weightx = 80;
        restriccion.insets = new Insets(0, 10, 0, 10);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_cedula_vendedor, restriccion );

        btn_buscar_vendedor = new JButton("BUSCAR");
        restriccion.gridy = 5;
        restriccion.gridx = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( btn_buscar_vendedor, restriccion );

        etq_nombres_vendedor = new JLabel("NOMBRES:");
        restriccion.gridy = 6;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(10, 0, 10, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_nombres_vendedor, restriccion );

        input_nombres_vendedor = new JTextField();
        input_nombres_vendedor.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
        restriccion.gridy = 6;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3;
        restriccion.weighty = 2;
        restriccion.weightx = 90;
        restriccion.insets = new Insets(10, 10, 10, 10);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_nombres_vendedor, restriccion );

        /*
                - Seccion Productos
        */
        etq_datos_productos = new JLabel("LISTA PRODUCTOS FACTURADOS:");
        etq_datos_productos.setFont( new Font("Arial", Font.BOLD, 20) );
        etq_datos_productos.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
        restriccion.gridy = 7;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 2;
        restriccion.weightx = 100;
        restriccion.insets = new Insets(10, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_datos_productos, restriccion );

        etq_id_producto = new JLabel("ID");
        etq_id_producto.setHorizontalAlignment( JLabel.CENTER );
        restriccion.gridy = 8;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_id_producto, restriccion );

        etq_nombre_producto = new JLabel("NOMBRE");
        etq_nombre_producto.setHorizontalAlignment( JLabel.CENTER );
        restriccion.gridy = 8;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 70;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_nombre_producto, restriccion );

        etq_cant_producto = new JLabel("CANT.");
        etq_cant_producto.setHorizontalAlignment( JLabel.CENTER );
        restriccion.gridy = 8;
        restriccion.gridx = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_cant_producto, restriccion );

        etq_btn_producto = new JLabel();
        restriccion.gridy = 8;
        restriccion.gridx = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( etq_btn_producto, restriccion );


        input_id_producto = new JTextField();
        input_id_producto.setHorizontalAlignment(JLabel.CENTER);
        restriccion.gridy = 9;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_id_producto, restriccion );

        input_nombre_producto = new JTextField();
        input_nombre_producto.setHorizontalAlignment(JLabel.CENTER);
        restriccion.gridy = 9;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 70;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_nombre_producto, restriccion );
        
        input_cant_producto = new JTextField();
        input_cant_producto.setHorizontalAlignment(JLabel.CENTER);
        restriccion.gridy = 9;
        restriccion.gridx = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( input_cant_producto, restriccion );

        btn_add_producto = new JButton("ADD");
        restriccion.gridy = 9;
        restriccion.gridx = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 10, 0, 10);
        restriccion.fill = GridBagConstraints.BOTH;
        contPrincipal.add( btn_add_producto, restriccion );

        etq_resultado = new JPanel();
        scroll = new JScrollPane(etq_resultado);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        etq_resultado.setLayout(new GridBagLayout());
        restriccion.gridy = 10;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 89;
        restriccion.weightx = 100;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(10, 0, 0, 10);
        contPrincipal.add( scroll, restriccion );

        etq_total = new JLabel("Total: $ 0");
        etq_total.setHorizontalAlignment( JLabel.RIGHT );
        etq_total.setFont( new Font("Arial", Font.BOLD, 20) );
        etq_total.setOpaque(true);
        etq_total.setBackground( Color.white );
        etq_total.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
        restriccion.gridy = 11;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 2;
        restriccion.weightx = 100;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(0, 0, 0, 10);
        contPrincipal.add( etq_total, restriccion );
        
        
        JButton btn_atras = new JButton("ATRAS");
        restriccion.gridy = 12;
        restriccion.gridx = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(10, 0, 0, 0);
        contPrincipal.add(btn_atras, restriccion);
        
        JButton btn_registrar = new JButton("REGISRRAR");
        restriccion.gridy = 12;
        restriccion.gridx = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 2;
        restriccion.weightx = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(10, 10, 0, 10);
        contPrincipal.add(btn_registrar, restriccion);
        
        this.input_nombres_cliente.setEnabled(false);
        this.input_direccion_cliente.setEnabled(false);
        deshabilitarInput(this.input_nombres_cliente);
        deshabilitarInput(this.input_direccion_cliente);
        deshabilitarInput(this.input_nombres_vendedor);
        deshabilitarInput(this.input_id_producto);
        deshabilitarInput(this.input_nombre_producto);
        deshabilitarInput(this.input_cant_producto);

        add( contPrincipal );
        setResizable(false);
        setVisible(true);
        revalidate();
        repaint();

        ActionListener eventoClickBuscarCliente = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarCliente();
            }
        };

        KeyListener eventoKeyBuscarCliente = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                String texto = input_cedula_cliente.getText();
                if(texto.equalsIgnoreCase("")){
                    input_nombres_cliente.setText("");
                    input_direccion_cliente.setText("");
                }
                if (e.getKeyCode()==10) {
                    buscarCliente();
                }else{
                    input_nombres_cliente.setText("");
                    input_direccion_cliente.setText("");
                    deshabilitarInput(input_nombres_cliente);
                    deshabilitarInput(input_direccion_cliente);
                }
            }

            public void keyTyped(KeyEvent e){
            }
        };

        ActionListener eventoClickBuscarVendedor = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarVendedor();
            }
        };

        KeyListener eventoKeyBuscarVendedor = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                String texto = input_cedula_vendedor.getText();
                if(texto.equalsIgnoreCase("")){
                    input_nombres_vendedor.setText("");
                }
                if (e.getKeyCode()==10) {
                    buscarVendedor();
                }else{
                    input_nombres_vendedor.setText("");
                    deshabilitarInput(input_nombres_vendedor);

                    input_id_producto.setText("");
                    deshabilitarInput(input_id_producto);
                    input_nombre_producto.setText("");
                    deshabilitarInput(input_nombre_producto);
                    input_cant_producto.setText("");
                    deshabilitarInput(input_cant_producto);
                }
            }

            public void keyTyped(KeyEvent e){
            }
        };

        btn_buscar_cliente.addActionListener( eventoClickBuscarCliente );
        input_cedula_cliente.addKeyListener( eventoKeyBuscarCliente );

        btn_buscar_vendedor.addActionListener( eventoClickBuscarVendedor );
        input_cedula_vendedor.addKeyListener( eventoKeyBuscarVendedor );

        KeyListener eventoKeyBuscarProducto = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                String texto = input_id_producto.getText();
                if(texto.equalsIgnoreCase("")){
                    input_nombre_producto.setText("");
                    input_cant_producto.setText("");
                }

                if (e.getKeyCode()==10) {
                    buscarProducto();
                }else if (e.getKeyCode()==8) {
                        input_nombre_producto.setText("");
                    input_cant_producto.setText("");
                    deshabilitarInput(input_nombre_producto);
                }else if (e.getKeyCode()!=16){
                        input_nombre_producto.setText("");
                    input_cant_producto.setText("");
                    deshabilitarInput(input_nombre_producto);
                    buscarProducto();
                }
            }

            public void keyTyped(KeyEvent e){
            }
        };
        input_id_producto.addKeyListener(eventoKeyBuscarProducto);
        
        ActionListener eventoClickAgregarProducto = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("02");
                total();
                registrarItemsFactura();
                agregarProducto();
            }
        };
        btn_add_producto.addActionListener(eventoClickAgregarProducto);
        
        ActionListener eventoAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenu.setVisible(true);
                dispose();
            }
        };
        btn_atras.addActionListener(eventoAtras);
        
        ActionListener eventoRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrar();
            }
        };
        btn_registrar.addActionListener(eventoRegistrar);
    }
    
    public void Registrar(){
        boolean mostrarAlerta = false;
        this.ventanaMenu.id++;
        LocalDate fechaActual = LocalDate.now();
        String fecha = fechaActual.toString();
        
        if (!this.cedulaCliente.equals(" ") && !this.cedulaVendedor.equals("") && !fecha.equals("") && this.precioTotal != 0 && this.ventanaMenu.id_items >=0) {
            boolean proceso = this.ventanaMenu.database.registrarFactura(this.ventanaMenu.id, this.cedulaCliente, this.cedulaVendedor, fecha, this.precioTotal);
            for (int i = 1; i <= this.ventanaMenu.id_items; i++) {
                System.out.println("- "+this.listaFactura[i]);
                if (this.listaFactura[i] != null) {
                    System.out.println("id  "+this.ventanaMenu.id_items);
                    String nombre = this.listaFactura[i].getNombre();
                    int id_factura = this.listaFactura[i].getId();
                    int id_producto = this.listaFactura[i].getId_producto();
                    int cantidad = this.listaFactura[i].getCantidad();
                    int subtotal = this.listaFactura[i].getSubtotal();
                    boolean ProcesoItemFactura = this.ventanaMenu.database.registrarItemsFactura(nombre,id_factura,this.ventanaMenu.id,id_producto,cantidad,subtotal);
                    mostrarAlerta = true;
                }
            }
            
            if (mostrarAlerta) {
                Alert alerta = new Alert("EXITO", "La factura se guardo con exito :)", "success");
            }
        }else{
            Alert alerta = new Alert("902", "La factura no se pudo registrar correctamente :(", "error");
        }
    }
    
    public void registrarItemsFactura(){
        String id_producto = input_id_producto.getText();
        String cantidad_pro = input_cant_producto.getText();
        String nombre = input_nombre_producto.getText();
        int idProducto = Integer.valueOf(id_producto);
        int cantidad = Integer.valueOf(cantidad_pro);
        this.guardarPrecio = this.listaProductos[i].getPrecio();
        int subtotal = this.guardarPrecio*cantidad;
        if (cantidad != 0 && this.precioTotal != 0) {
            this.ventanaMenu.id_items++;
            ItemFactura temp = new ItemFactura(nombre,this.ventanaMenu.id_items,cantidad, idProducto, cantidad, subtotal);
            this.listaFactura[this.ventanaMenu.id_items] = temp;
            System.out.println("id factura "+this.ventanaMenu.id_items);
        }
        System.out.println(this.ventanaMenu.id);
    }
    
    
    public void agregarProducto(){
        String cant = input_cant_producto.getText();
        String ID = input_id_producto.getText();
        int validarCant = Integer.valueOf(cant);
        i++;
        if (this.ingresarCliente != "" && this. ingresarProducto != "" && ingresoVendedor != "" && !cant.equals("") && validarCant != 0) {
            if (j==0) {
                JLabel entrada = new JLabel ("          Cliente: "+this.ingresarCliente+"                  Vendedor: "+this.ingresoVendedor);
                Font font = new Font("Arial", Font.BOLD, 15);
                entrada.setFont(font);
                restriccion.gridy = 0;
                restriccion.gridx = 0;
                this.etq_resultado.add(entrada,restriccion);
                System.out.println("01");
            }
            JLabel imprimir = new JLabel ("<html><br>Id: "+ID+"<br>Producto: "+this. ingresarProducto+"<br>Cantidad: "+cant);
            Font font = new Font("Arial", Font.BOLD, 15);    
            imprimir.setFont(font);
            restriccion.gridy = i;
            restriccion.gridx = 0;
            this.etq_resultado.add(imprimir,restriccion);
            System.out.println("01");
        }
        
        this.scroll.revalidate();
        j=1;
    }
    
    public void total(){
        String extraerCantidad = input_cant_producto.getText();
        int cantidad = Integer.valueOf(extraerCantidad);
        int total = cantidad*this.guardarPrecio;
        this.precioTotal = precioTotal + total; 
        String mostrarTotal = String.valueOf(precioTotal);
        
        String formatoMoneda = this.formatoMoneda(mostrarTotal);
        this.etq_total.setText(formatoMoneda);
    }
    
    
    public boolean validarNumero(String texto){
        int contador = 0;
        for (int i=0; i<texto.length(); i++) {
                int codigo = (int) texto.charAt(i);
                if ((codigo<48 || codigo>57) && codigo!=44 && codigo!=45 && codigo!=46){
                    return false;
                }
                if (codigo==44 || codigo==46){
                    contador++;
                }
        }
        return (contador<=1);
    }

    public String formatoMoneda(String texto){
        Double numero = Double.parseDouble(texto.replace(",","."));
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return formatoMoneda.format(numero).replaceAll(",00","");
    }

    public void buscarCliente(){
        String texto = input_cedula_cliente.getText();
        boolean encontrado = false;
        for (int i=0; i<this.listaClientes.length; i++) {
            if(this.listaClientes[i]!=null && this.listaClientes[i].getCedula().equalsIgnoreCase(texto)){
                this.input_nombres_cliente.setText( this.listaClientes[i].getNombres() );
                this.input_direccion_cliente.setText( this.listaClientes[i].getDireccion() );
                encontrado = true;
                this.ingresarCliente = this.listaClientes[i].getNombres();
                this.cedulaCliente = this.listaClientes[i].getCedula();
                break;
            }
        }

        if(encontrado){
            deshabilitarInput(this.input_nombres_cliente);
            deshabilitarInput(this.input_direccion_cliente);
            this.input_cedula_vendedor.requestFocus();
        }	
    }

    public void buscarVendedor(){
        String texto = input_cedula_vendedor.getText();
        boolean encontrado = false;
        for (int i=0; i<this.listaVendedores.length; i++) {
            if(this.listaVendedores[i]!=null && this.listaVendedores[i].getCedula().equalsIgnoreCase(texto)){
                this.input_nombres_vendedor.setText( this.listaVendedores[i].getNombres() );
                encontrado = true;
                this.ingresoVendedor = this.listaVendedores[i].getNombres();
                this.cedulaVendedor = this.listaVendedores[i].getCedula();
                break;
            }
        }

        if(!encontrado){
            this.input_id_producto.setText("");
            deshabilitarInput(this.input_id_producto);
            this.input_nombre_producto.setText("");
            deshabilitarInput(this.input_nombre_producto);
            this.input_cant_producto.setText("");
            deshabilitarInput(this.input_cant_producto);

            this.input_nombres_vendedor.setText("");
            this.input_cedula_vendedor.requestFocus();
        }else{
            if (this.ingresarCliente != "") {
                this.input_id_producto.setText("");
                habilitarInput(this.input_id_producto);
                this.input_nombre_producto.setText("");
                deshabilitarInput(this.input_nombre_producto);
                this.input_cant_producto.setText("");
                habilitarInput(this.input_cant_producto);

                this.input_id_producto.requestFocus();
            }else{
                habilitarInput(this.input_id_producto);
                deshabilitarInput(this.input_nombre_producto);
                habilitarInput(this.input_cant_producto);
                this.input_cedula_cliente.requestFocus();
            }
        }
    }

    public void buscarProducto(){
        String texto = input_id_producto.getText();
        boolean encontrado = false;
        if (!texto.equals("") && validarNumero(texto)) {
            for (int i=0; i<this.listaProductos.length; i++) {
                if(this.listaProductos[i]!=null && this.listaProductos[i].getId()==Integer.valueOf(texto) ){
                    this.input_nombre_producto.setText( this.listaProductos[i].getNombre() );
                    encontrado = true;
                    this.ingresarProducto = this.listaProductos[i].getNombre();
                    this.guardarPrecio = this.listaProductos[i].getPrecio();
                    break;
                }
            }
        }
        
        if(!encontrado){
            this.input_nombre_producto.setText("");
            deshabilitarInput(this.input_nombre_producto);
            this.input_cant_producto.setText("");
            this.input_id_producto.requestFocus();
            Alert alerta = new Alert ("404", "El producto no se encuentra registrado.", "error");
        }else{
            this.input_cant_producto.setText("");
            habilitarInput(this.input_cant_producto);
            this.input_cant_producto.requestFocus();
        }
    }

    public void deshabilitarInput(JTextField input){
        input.setEditable(false);
        input.setEnabled(false);
        input.setDisabledTextColor(Color.black);
    }

    public void habilitarInput(JTextField input){
        input.setText("");
        input.setEditable(true);
        input.setEnabled(true);
    }
    
    // Atributos
    private Persona listaClientes [];
    private Persona listaVendedores [];
    private Producto listaProductos [];
    private JLabel etq_datos_cliente;
    private JLabel etq_cedula_cliente;
    private JLabel etq_nombres_cliente;
    private JLabel etq_direccion_cliente;
    private JLabel etq_datos_vendedor;
    private JLabel etq_vendedor_cliente;
    private JLabel etq_nombres_vendedor;
    private JLabel etq_datos_productos;
    private JLabel etq_id_producto;
    private JLabel etq_nombre_producto;
    private JLabel etq_cant_producto;
    private JLabel etq_btn_producto;
    private JPanel etq_resultado;
    private JLabel etq_total;
    private JTextField input_cedula_cliente;
    private JTextField input_nombres_cliente;
    private JTextField input_direccion_cliente;
    private JTextField input_cedula_vendedor;
    private JTextField input_nombres_vendedor;
    private JTextField input_id_producto;
    private JTextField input_nombre_producto;
    private JTextField input_cant_producto;
    private JButton btn_buscar_cliente;
    private JButton btn_buscar_vendedor;
    private JButton btn_add_producto;
    private String ingresarCliente;
    private String ingresoVendedor;
    private String  ingresarProducto;
    private String cedulaCliente;
    private String cedulaVendedor;
    private JScrollPane scroll;
    private int i;
    private int j;
    private int guardarPrecio;
    private int precioTotal;
    private ItemFactura listaFactura [];
    GridBagConstraints restriccion = new GridBagConstraints();
    JPanel contPrincipal = new JPanel();
    Menu ventanaMenu;
}
