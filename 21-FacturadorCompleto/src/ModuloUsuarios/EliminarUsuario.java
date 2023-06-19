
package ModuloUsuarios;

import Clases.Persona;
import Principal.Alert;
import Principal.Menu;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class EliminarUsuario extends javax.swing.JFrame {
    
    Menu ventanaMenu;
    Persona listaPersonas [];
    String tipoLista;

    public EliminarUsuario(Menu ventanaMenu, Persona [] listaPersonas, String tipoLista) {
        
        this.ventanaMenu = ventanaMenu;
        this.listaPersonas = listaPersonas;
        this.tipoLista = tipoLista;
        initComponents();
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentTitulo = new javax.swing.JPanel();
        etqTitulo = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JPanel();
        etqCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        btnBusacr = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        etqNombres = new javax.swing.JLabel();
        etqApellidos = new javax.swing.JLabel();
        etqDireccion = new javax.swing.JLabel();
        etqEmail = new javax.swing.JLabel();
        campoNombres = new javax.swing.JTextField();
        campoApellidos = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        etqTelefono = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentTitulo.setBackground(new java.awt.Color(0, 0, 102));

        etqTitulo.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        etqTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etqTitulo.setText("          Eliminar Usuario");

        javax.swing.GroupLayout contentTituloLayout = new javax.swing.GroupLayout(contentTitulo);
        contentTitulo.setLayout(contentTituloLayout);
        contentTituloLayout.setHorizontalGroup(
            contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );
        contentTituloLayout.setVerticalGroup(
            contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        contentPrincipal.setBackground(new java.awt.Color(153, 153, 255));

        etqCedula.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqCedula.setForeground(new java.awt.Color(255, 255, 255));
        etqCedula.setText("Cedula :");

        campoCedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnBusacr.setBackground(new java.awt.Color(0, 0, 153));
        btnBusacr.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBusacr.setForeground(new java.awt.Color(255, 255, 255));
        btnBusacr.setText("Buscar");
        btnBusacr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusacrActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuario Encontrado : ");

        etqNombres.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqNombres.setForeground(new java.awt.Color(255, 255, 255));
        etqNombres.setText("Nombres :");

        etqApellidos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqApellidos.setForeground(new java.awt.Color(255, 255, 255));
        etqApellidos.setText("Apellidos : ");

        etqDireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqDireccion.setForeground(new java.awt.Color(255, 255, 255));
        etqDireccion.setText("Direccion : ");

        etqEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqEmail.setForeground(new java.awt.Color(255, 255, 255));
        etqEmail.setText("Email : ");

        campoNombres.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        campoApellidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        campoDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        campoEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("ELIMINAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        etqTelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqTelefono.setText("Telefono :");

        campoTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(etqCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBusacr, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(etqTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etqNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etqApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etqDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(etqEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNombres)
                                    .addComponent(campoApellidos)
                                    .addComponent(campoDireccion)
                                    .addComponent(campoEmail)
                                    .addComponent(campoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                            .addGroup(contentPrincipalLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusacr, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etqNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etqApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etqTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etqDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etqEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusacrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusacrActionPerformed
        String cedula = campoCedula.getText();
        Persona temporal = (this.tipoLista.equalsIgnoreCase("CLIENTES"))? this.ventanaMenu.database.buscarCliente(cedula) : this.ventanaMenu.database.buscarVendedor(cedula);
        
        if (temporal != null) {
            habilitarCampo(campoNombres);
            habilitarCampo(campoApellidos);
            habilitarCampo(campoTelefono);
            habilitarCampo(campoDireccion);
            habilitarCampo(campoEmail);
            campoNombres.setText(temporal.getNombres());
            campoApellidos.setText(temporal.getApellidos());
            campoTelefono.setText(temporal.getTelefono());
            campoDireccion.setText(temporal.getDireccion());
            campoEmail.setText(temporal.getEmail());
            campoNombres.requestFocus();
            btnRegistrar.setEnabled(true);
        }else{
            Alert alerta = new Alert("NO EXISTE", "La cedula no esta registrada.", "error");
            campoNombres.setText("");
            campoApellidos.setText("");
            campoTelefono.setText("");
            campoDireccion.setText("");
            campoEmail.setText("");
            deshabilitarCampo(campoNombres);
            deshabilitarCampo(campoApellidos);
            deshabilitarCampo(campoTelefono);
            deshabilitarCampo(campoDireccion);
            deshabilitarCampo(campoEmail);
            campoCedula.requestFocus();
            btnRegistrar.setEnabled(false);
        }
    }//GEN-LAST:event_btnBusacrActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String cedula = campoCedula.getText();
        String nombres = campoNombres.getText();
        String apellidos = campoApellidos.getText();
        String direccion = campoDireccion.getText();
        String telefono = campoTelefono.getText();
        String email = campoEmail.getText();
        Persona temporal = new Persona(cedula, nombres, apellidos, telefono, direccion, email);
        
        if (!cedula.equals("") && !nombres.equals("") && !apellidos.equals("") && !direccion.equals("") && !telefono.equals("") && !email.equals("") ) {
            boolean proceso = (this.tipoLista.equalsIgnoreCase("CLIENTES"))? this.ventanaMenu.database.eliminarCliente(temporal) : this.ventanaMenu.database.eliminarVendedor(temporal);
            Alert alerta = new Alert("EXITO", "Persona Eliminada.", "success");
        }
        campoCedula.setText("");
        campoNombres.setText("");
        campoApellidos.setText("");
        campoTelefono.setText("");
        campoDireccion.setText("");
        campoEmail.setText("");
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.ventanaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void deshabilitarCampo(JTextField campo){
        JTextField referencia = new JTextField();
        campo.setBorder( referencia.getBorder() );
        campo.setEnabled(false);
        campo.setBackground(Color.GRAY );
    }
    
    public void habilitarCampo(JTextField campo){
        campo.setEnabled(true);
        campo.setBackground(Color.WHITE );
    }
    
    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_almacenes.png") ) );
        setTitle("Usuarios");
        etqTitulo.setText("ELIMINAR "+this.tipoLista);
        
        deshabilitarCampo(campoNombres);
        deshabilitarCampo(campoApellidos);
        deshabilitarCampo(campoTelefono);
        deshabilitarCampo(campoDireccion);
        deshabilitarCampo(campoEmail);
    }
    
    public void validarTodosInputs(){
        validarInput(campoEmail);
        validarInput(campoDireccion);
        validarInput(campoTelefono);
        validarInput(campoApellidos);
        validarInput(campoNombres);
    }
    
    public void validarInput(JTextField campo){
        if (campo.getText().equals("")) {
            Border borderColor = new LineBorder(Color.RED, 1, true);
            Border borderPadding = new EmptyBorder(2,5,2,5);
            Border borderRojo = new CompoundBorder(borderColor, borderPadding);
            campo.setBorder(borderRojo);
            campo.requestFocus();
        }else{
            JTextField referencia = new JTextField();
            campo.setBorder( referencia.getBorder() );
        }
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusacr;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JPanel contentTitulo;
    private javax.swing.JLabel etqApellidos;
    private javax.swing.JLabel etqCedula;
    private javax.swing.JLabel etqDireccion;
    private javax.swing.JLabel etqEmail;
    private javax.swing.JLabel etqNombres;
    private javax.swing.JLabel etqTelefono;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
