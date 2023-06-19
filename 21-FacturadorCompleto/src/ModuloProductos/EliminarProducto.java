
package ModuloProductos;

import Clases.Producto;
import Principal.Alert;
import Principal.Menu;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class EliminarProducto extends javax.swing.JFrame {
    
    Menu ventanaMenu;
    Producto listaProductos[];
    String tipoLista;


    public EliminarProducto(Menu ventanaMenu, Producto [] listaProductos, String tipoLista) {
        
        this.ventanaMenu = ventanaMenu;
        this.listaProductos = listaProductos;
        this.tipoLista = tipoLista;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentTitulo = new javax.swing.JPanel();
        etqTitulo = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JPanel();
        etqId = new javax.swing.JLabel();
        etqNombre = new javax.swing.JLabel();
        etqPrecio = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoPrecio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentTitulo.setBackground(new java.awt.Color(0, 0, 102));

        etqTitulo.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        etqTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etqTitulo.setText("          Eliminar Producto");

        javax.swing.GroupLayout contentTituloLayout = new javax.swing.GroupLayout(contentTitulo);
        contentTitulo.setLayout(contentTituloLayout);
        contentTituloLayout.setHorizontalGroup(
            contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentTituloLayout.setVerticalGroup(
            contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        contentPrincipal.setBackground(new java.awt.Color(153, 153, 255));

        etqId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqId.setForeground(new java.awt.Color(255, 255, 255));
        etqId.setText("Codigo :");

        etqNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqNombre.setForeground(new java.awt.Color(255, 255, 255));
        etqNombre.setText("Nombre :");

        etqPrecio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etqPrecio.setForeground(new java.awt.Color(255, 255, 255));
        etqPrecio.setText("Precio :");

        campoId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdActionPerformed(evt);
            }
        });

        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        campoPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(0, 0, 153));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 153));
        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Eliminar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Producto encontrado:");

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etqNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(etqPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(campoNombre))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1)
                            .addGroup(contentPrincipalLayout.createSequentialGroup()
                                .addComponent(etqId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.ventanaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         String codigo = campoId.getText();
        Producto temporal = (this.tipoLista.equalsIgnoreCase("PRODUCTO")) ? this.ventanaMenu.database.buscarProducto(codigo) : null;

        if (temporal != null) {
            habilitarCampo(campoNombre);
            habilitarCampo(campoPrecio);
            campoNombre.setText(temporal.getNombre());
            campoPrecio.setText(Double.toString(temporal.getPrecio()));
            campoNombre.requestFocus();
            btnRegistrar.setEnabled(true);
        } else {
            Alert alerta = new Alert("NO EXISTE", "El Id no está registrado.", "error");
            campoNombre.setText("");
            campoPrecio.setText("");
            deshabilitarCampo(campoNombre);
            deshabilitarCampo(campoPrecio);
            campoId.requestFocus();
            btnRegistrar.setEnabled(false);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String codigo = campoId.getText();
        int id = Integer.valueOf(codigo);
        boolean temp = this.ventanaMenu.database.eliminarProducto(id);
        
        if (temp){
            this.ventanaMenu.setVisible(true);
            Alert alerta = new Alert("EXITO", "Datos eliminados correctamente", "success");
        }else{
            this.ventanaMenu.setVisible(true);
            Alert alerta = new Alert("DATOS INCORRECTOS", "No se pudieron eliminar los datos", "error");
        }
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void campoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdActionPerformed


   private void eventoKeyCampos(java.awt.event.KeyEvent evt) {                                 
        JTextField campo = (JTextField) evt.getSource();
        validarInput(campo);
    }                                

    private void eventoKeyCedula(java.awt.event.KeyEvent evt) {                                 
        String codigo = campoId.getText();
        campoNombre.setText("");
        campoPrecio.setText("");
        deshabilitarCampo(campoNombre);
        deshabilitarCampo(campoPrecio);
        campoId.requestFocus();
        btnRegistrar.setEnabled(false);
    }                                

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
        
        deshabilitarCampo(campoNombre);
        deshabilitarCampo(campoPrecio);
    }
    
    public void validarTodosInputs(){
        validarInput(campoPrecio);
        validarInput(campoNombre);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JPanel contentTitulo;
    private javax.swing.JLabel etqId;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqPrecio;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
