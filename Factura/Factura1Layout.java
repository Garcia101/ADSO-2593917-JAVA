import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Factura1Layout extends JFrame {

	private Persona listaClientes [];
	private PersonaV listaVendedores [];
	private Productos arrayProductos [];
    private int totalCompra = 0;
	private JTextField input_cedula;
	private JTextField input_nombre;
	private JTextField input_direccion;
	private JTextField input_cedulas;
	private JTextField input_nombres;
	private JTextField input_nom;
	private JLabel etq_temporal;
	private JLabel etqId;
    private JLabel etqNombreProducto;
    private JLabel etqCantidad;
    private JPanel listaProductos;
    private JLabel etqTotal;
	private JTextField inputId;
    private JTextField nombreProducto;
    private JTextField cantidadProducto;
	private JButton botonAgregar;
    private JButton botonLimpiar;
    
    public Factura1Layout(Persona[] listaClientes, PersonaV[] listaVendedores, Productos [] arrayProductos) {
		this.listaClientes = listaClientes;
		this.listaVendedores = listaVendedores;
		this.arrayProductos = arrayProductos;

        initComponet();
    }
    public void initComponet() {
        
        Toolkit sistema = Toolkit.getDefaultToolkit();
		Dimension tamanio = sistema.getScreenSize();

        setTitle("FACTURA");
		setSize( tamanio.width/2 , tamanio.height/2 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);

        JPanel contPrincipal = new JPanel();
		contPrincipal.setLayout(new GridBagLayout());
		contPrincipal.setBorder( BorderFactory.createEmptyBorder(20, 20, 20, 20) );
		GridBagConstraints restriccion = new GridBagConstraints();

        JLabel datos_cliente = new JLabel("DATOS CLIENTES:");
        datos_cliente.setFont( new Font("Arial", Font.BOLD, 15) );
		restriccion.gridy = 0;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 1;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( datos_cliente, restriccion );

        JLabel cedula = new JLabel("CEDULA:");
		restriccion.gridy = 1;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( cedula, restriccion );

		input_cedula = new JTextField();
		input_cedula.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 1;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 1;
		restriccion.weightx = 80;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_cedula, restriccion );

		JButton btn_buscar = new JButton("BUSCAR");
		restriccion.gridy = 1;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btn_buscar, restriccion );

        JLabel nombre = new JLabel("NOMBRE:");
		restriccion.gridy = 2;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( nombre, restriccion );

		input_nombre = new JTextField();
		input_cedula.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 2;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(5, 10, 5, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_nombre, restriccion );

        JLabel direccion = new JLabel("DIRECCION:");
		restriccion.gridy = 3;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( direccion, restriccion );

		input_direccion = new JTextField();
		input_cedula.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 3;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(5, 10, 5, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_direccion, restriccion );

        JLabel datos_vendedor = new JLabel("DATOS VENDEDOR:");
        datos_vendedor.setFont( new Font("Arial", Font.BOLD, 15) );
		restriccion.gridy = 4;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 1;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( datos_vendedor, restriccion );

        JLabel cedulas = new JLabel("CEDULAS:");
		restriccion.gridy = 5;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( cedulas, restriccion );

        input_cedulas = new JTextField();
		input_cedula.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 5;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 1;
		restriccion.weightx = 80;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_cedulas, restriccion );

		JButton btn_buscar1 = new JButton("BUSCAR");
		restriccion.gridy = 5;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btn_buscar1, restriccion );

        JLabel nombres = new JLabel("NOMBRE:");
		restriccion.gridy = 6;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 1;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( nombres, restriccion );

		input_nombres = new JTextField();
		input_cedula.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 6;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(5, 10, 5, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_nombres, restriccion );

        JLabel lista_productos = new JLabel("LISTA DE PRODUCTOS FACTURADOS:");
        lista_productos.setFont( new Font("Arial", Font.BOLD, 15) );
		restriccion.gridy = 7;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 1;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( lista_productos, restriccion );

        //** --- Seccion productos --- */

        etqId = new JLabel("ID ");
        etqId.setHorizontalAlignment( JLabel.CENTER );
        restriccion.gridx = 0;
        restriccion.gridy = 8;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(etqId, restriccion);

        etqNombreProducto = new JLabel("NOMBRE");
        etqNombreProducto.setHorizontalAlignment( JLabel.CENTER );
        restriccion.gridx = 1;
        restriccion.gridy = 8;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 50;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(etqNombreProducto, restriccion);

        etqCantidad = new JLabel("CANT ");
        etqCantidad.setHorizontalAlignment( JLabel.CENTER );
        restriccion.gridx = 2;
        restriccion.gridy = 8;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(etqCantidad, restriccion);

        inputId = new JTextField(" ");
        restriccion.gridx = 0;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
		restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(inputId, restriccion);

        nombreProducto = new JTextField(" ");
        restriccion.gridx = 1;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 50;
		restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(nombreProducto, restriccion);

        cantidadProducto = new JTextField("");
        restriccion.gridx = 2;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(cantidadProducto, restriccion);

        botonAgregar = new JButton("ADD");
        restriccion.gridx = 3;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.insets = new Insets(0, 10, 0, 10);
        restriccion.fill = (GridBagConstraints.BOTH);
        contPrincipal.add(botonAgregar, restriccion);

        //** --- Seccion factura --- */

        listaProductos = new JPanel();
        listaProductos.setLayout( new BoxLayout(listaProductos, BoxLayout.Y_AXIS) );
        listaProductos.setOpaque(true);
        listaProductos.setBackground(Color.white);
        
        JScrollPane scrollPane = new JScrollPane(listaProductos);
        scrollPane.setPreferredSize( contPrincipal.getSize() );

        restriccion.gridx = 0;
        restriccion.gridy = 10;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 90;
        restriccion.weightx = 100;
        restriccion.fill = (GridBagConstraints.BOTH);
        restriccion.insets = new Insets(10,0,0,10);
        contPrincipal.add(scrollPane, restriccion);

        etqTotal = new JLabel("Total: $ " + totalCompra);
        etqTotal.setHorizontalAlignment(JLabel.RIGHT);
        etqTotal.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        restriccion.gridx = 0;
        restriccion.gridy = 11;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 2;
        restriccion.weightx = 100;
        restriccion.fill = (GridBagConstraints.BOTH);
        restriccion.insets = new Insets(0,0,0,10);
        etqTotal.setOpaque(true);
        etqTotal.setBackground(Color.white);
        contPrincipal.add(etqTotal, restriccion);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setHorizontalAlignment(JButton.CENTER);
        botonLimpiar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        restriccion.gridx = 3;
        restriccion.gridy = 12;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.fill = (GridBagConstraints.BOTH);
        restriccion.insets = new Insets(10,10,0,10);
        contPrincipal.add(botonLimpiar,restriccion);
        

        add( contPrincipal );
		setResizable(false);
		setVisible(true);
		revalidate();
		repaint();

		ActionListener evento_01 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buscarCliente();
			}
		};
		btn_buscar.addActionListener( evento_01 );

		ActionListener evento_02 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buscarvendedor();
			}
		};
		btn_buscar1.addActionListener( evento_02 );

		KeyListener eventoKeyBuscarProducto = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                buscarProductos();
            }   

            public void keyTyped(KeyEvent e){
               
            }
        };
        KeyListener eventoKeyAgregarProductos = new KeyListener(){
            public void keyPressed(KeyEvent e){

            }

            public void keyReleased(KeyEvent e){
            }

            public void keyTyped(KeyEvent e){
                agregarProductos();
            }
        };


		inputId.addKeyListener(eventoKeyBuscarProducto);
        inputId.addKeyListener(eventoKeyAgregarProductos);

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
		String texto = input_cedula.getText().replaceAll(" ", "");
		boolean encontrado = false;
		for (int i=0; i<this.listaClientes.length; i++) {
			if(this.listaClientes[i]!=null && this.listaClientes[i].getCedula().equalsIgnoreCase(texto)){
				this.input_nombre.setText( this.listaClientes[i].getNombres() );
				this.input_direccion.setText( this.listaClientes[i].getDireccion() );
				encontrado = true;
				break;
			}
		}

		if(encontrado){
			deshabilitarInput(this.input_nombre);
			deshabilitarInput(this.input_direccion);
			this.input_cedulas.requestFocus();
		}else{
			habilitarInput(this.input_nombre);
			habilitarInput(this.input_direccion);
			this.input_nombre.requestFocus();
		}	
	}

	public void buscarvendedor(){
		String texto = input_cedulas.getText().replaceAll(" ", "");
		boolean encontrado1 = false;
		for (int i=0; i<this.listaVendedores.length; i++) {
			if(this.listaVendedores[i]!=null && this.listaVendedores[i].getCedulavendedores().equalsIgnoreCase(texto)){
				this.input_nombres.setText( this.listaVendedores[i].getNombrevendedores() );
				encontrado1 = true;
				break;
			}
		}

		if(encontrado1){
			deshabilitarInput(this.input_nombres);
			this.input_cedulas.requestFocus();
		}else{
			habilitarInput(this.input_nombres);
			this.input_nombres.requestFocus();
		}	
	}

	public void deshabilitarInput(JTextField input){
        input.setEditable(false);
        input.setEnabled(false);
        input.setDisabledTextColor(Color.black);
    }

    public void habilitarInput(JTextField input){
        input.setText(" ");
        input.setEditable(true);
        input.setEnabled(true);
    }

    public void agregarProductos(){
        String id = inputId.getText().replaceAll(" ","");
        String cantidadString =  cantidadProducto.getText().replaceAll(" ","");

        if(!id.equalsIgnoreCase("") && !cantidadString.equalsIgnoreCase("")){
            boolean encontrado = false;
            for(int i = 0; i < this.arrayProductos.length; i++){
                if(this.arrayProductos[i] != null && this.arrayProductos[i].getIdProducto().equalsIgnoreCase(id)){
                    int cantidadInt = Integer.parseInt(cantidadString);
                    int valorProducto = this.arrayProductos[i].getPrecio() * cantidadInt;
                    etq_temporal = new JLabel(this.arrayProductos[i].getIdProducto() + " - " + this.arrayProductos[i].getNombreProducto() + " - " + cantidadProducto.getText() + " - " + valorProducto);                    
                    listaProductos.add(etq_temporal);
                    nombreProducto.setText(arrayProductos[i].getNombreProducto());
                    encontrado = true;
                    totalCompra += valorProducto;
                    etqTotal.setText("Total: $ " + Integer.toString(totalCompra));
                    this.inputId.setText("");
                    
                    revalidate();
                    break;
                }
            }
            if(!encontrado){
                nombreProducto.setText("No encontrado");
            }


        }
    }

    public void buscarProductos(){
        String id = inputId.getText().replaceAll(" ","");
        boolean encontrado = false;
        if(!id.equalsIgnoreCase("")){
            for(int i = 0; i < this.arrayProductos.length; i++){
                if(this.arrayProductos[i] != null && this.arrayProductos[i].getIdProducto().equalsIgnoreCase(id)){
                    this.nombreProducto.setText( this.arrayProductos[i].getNombreProducto());
                    encontrado = true;
                    break;
                }
            }
        }
        if(!encontrado){
            this.nombreProducto.setText("");
        }else{
            cantidadProducto.setText("1");
            agregarProductos();
        }
    }

	
}
