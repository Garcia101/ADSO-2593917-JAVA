
package ModuloFacturas;

import Clases.Factura;
import Clases.ItemFactura;
import Principal.Menu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class Detalles extends javax.swing.JFrame {
    
    Menu ventanaMenu;
    Factura factura;
    ListarFactura ventana;
    ItemFactura items;
    private JLabel etq_temporal;
  
    public Detalles(Menu ventanaMenu, Factura factura, ItemFactura items) {
        
        this.ventanaMenu=ventanaMenu;
        this.factura=factura;
        this.items=items;
        initComponents();
        initAlternComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        etq_datosCliente = new javax.swing.JLabel();
        etq_cedulaCliente = new javax.swing.JLabel();
        input_cedulaCliente = new javax.swing.JTextField();
        etq_datosVendedor = new javax.swing.JLabel();
        etq_cedulaVendedor = new javax.swing.JLabel();
        input_cedulaVendedor = new javax.swing.JTextField();
        etq_listaProductos = new javax.swing.JLabel();
        tx_lista = new javax.swing.JScrollPane();
        contentLista = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        etq_total = new javax.swing.JLabel();
        input_total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(153, 153, 255));

        etq_datosCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_datosCliente.setForeground(new java.awt.Color(0, 0, 0));
        etq_datosCliente.setText("DATOS CLIENTE:");

        etq_cedulaCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etq_cedulaCliente.setForeground(new java.awt.Color(0, 0, 0));
        etq_cedulaCliente.setText("Cedula:");

        input_cedulaCliente.setEditable(false);
        input_cedulaCliente.setBackground(new java.awt.Color(153, 153, 255));
        input_cedulaCliente.setBorder(null);

        etq_datosVendedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_datosVendedor.setForeground(new java.awt.Color(0, 0, 0));
        etq_datosVendedor.setText("DATOS VENDEDOR:");

        etq_cedulaVendedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etq_cedulaVendedor.setForeground(new java.awt.Color(0, 0, 0));
        etq_cedulaVendedor.setText("Cedula:");

        input_cedulaVendedor.setEditable(false);
        input_cedulaVendedor.setBackground(new java.awt.Color(153, 153, 255));
        input_cedulaVendedor.setBorder(null);

        etq_listaProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_listaProductos.setForeground(new java.awt.Color(0, 0, 0));
        etq_listaProductos.setText("LISTA PRODUCTOS FACTURADOS:");

        contentLista.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentListaLayout = new javax.swing.GroupLayout(contentLista);
        contentLista.setLayout(contentListaLayout);
        contentListaLayout.setHorizontalGroup(
            contentListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        contentListaLayout.setVerticalGroup(
            contentListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        tx_lista.setViewportView(contentLista);

        btnCancelar.setBackground(new java.awt.Color(0, 0, 153));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        etq_total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_total.setForeground(new java.awt.Color(0, 0, 0));
        etq_total.setText("TOTAL:");

        input_total.setEditable(false);
        input_total.setBackground(new java.awt.Color(153, 153, 255));
        input_total.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                     Detalles");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(etq_cedulaVendedor))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(etq_datosVendedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_cedulaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(etq_datosCliente)
                                .addGap(18, 18, 18)
                                .addComponent(input_cedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_listaProductos)
                            .addComponent(tx_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_cedulaCliente)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(etq_total)
                                .addGap(18, 18, 18)
                                .addComponent(input_total, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnCancelar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_datosCliente)
                    .addComponent(input_cedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_cedulaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_cedulaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_datosVendedor))
                .addGap(9, 9, 9)
                .addComponent(etq_cedulaVendedor)
                .addGap(32, 32, 32)
                .addComponent(etq_listaProductos)
                .addGap(18, 18, 18)
                .addComponent(tx_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(etq_total)
                    .addComponent(input_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_almacenes.png") ) );
        
        contentLista.setLayout( new BoxLayout(contentLista, BoxLayout.Y_AXIS) );
        contentLista.setBackground(Color.WHITE);
        cedulaCliente();
        itemsFactura();
    }
    
    public void cedulaCliente(){
        Factura temporal = this.factura;
        String cedulaCliente = String.valueOf(temporal.getCedula_cliente());
        input_cedulaCliente.setText(cedulaCliente);
        
        String cedulaVendedor = String.valueOf(temporal.getCedula_vendedor());
        input_cedulaVendedor.setText(cedulaVendedor);
        
        String total = String.valueOf(temporal.getTotal());
        input_total.setText(total);
    }
    public void itemsFactura(){
        Factura temporal = this.factura;
        ItemFactura listaFactura[] = this.ventanaMenu.database.listaItems();
        if (listaFactura != null) {
            for (int i = 0; i < listaFactura.length; i++) {
                if (listaFactura[i] != null) {
                    if(listaFactura[i].getId_factura()==temporal.getId()){
                        etq_temporal = new JLabel(" - "+listaFactura[i].getId_producto()+" - "+listaFactura[i].getNombre()+" - "+listaFactura[i].getCantidad()+" - "+listaFactura[i].getSubtotal());
                        etq_temporal.setFont(new Font("Arial", Font.PLAIN, 12));
                        etq_temporal.setBorder(new EmptyBorder(2,10,2,10));
                        contentLista.add(etq_temporal);
                        System.out.println(" - "+listaFactura[i].getId_producto()+" - "+listaFactura[i].getNombre()+" - "+listaFactura[i].getCantidad()+" - "+listaFactura[i].getSubtotal());
                    }
                    
                }else{
                    break;
                }
            }
            revalidate();
        }
        
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel contentLista;
    private javax.swing.JLabel etq_cedulaCliente;
    private javax.swing.JLabel etq_cedulaVendedor;
    private javax.swing.JLabel etq_datosCliente;
    private javax.swing.JLabel etq_datosVendedor;
    private javax.swing.JLabel etq_listaProductos;
    private javax.swing.JLabel etq_total;
    private javax.swing.JTextField input_cedulaCliente;
    private javax.swing.JTextField input_cedulaVendedor;
    private javax.swing.JTextField input_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane tx_lista;
    // End of variables declaration//GEN-END:variables
}
