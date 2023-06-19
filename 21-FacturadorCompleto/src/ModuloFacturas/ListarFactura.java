
package ModuloFacturas;

import Clases.Factura;
import Clases.ItemFactura;
import Clases.Producto;
import Principal.Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class ListarFactura extends javax.swing.JFrame {
    
    Menu ventanaMenu;
    Producto listaProductos[];
    Detalles ventana;
    ItemFactura items;
    private JLabel etqTemporal;
    private JButton btndetalles;
    int i;

   
    public ListarFactura(Menu ventanaMenu) {
        
        this.ventanaMenu = ventanaMenu;
        this.i =0;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        contentTitle = new javax.swing.JPanel();
        etq_title = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JPanel();
        tx_lista = new javax.swing.JScrollPane();
        contentLista = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentTitle.setBackground(new java.awt.Color(0, 0, 153));

        etq_title.setBackground(new java.awt.Color(0, 0, 153));
        etq_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        etq_title.setForeground(new java.awt.Color(255, 255, 255));
        etq_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_title.setText("Listar Facturas");

        javax.swing.GroupLayout contentTitleLayout = new javax.swing.GroupLayout(contentTitle);
        contentTitle.setLayout(contentTitleLayout);
        contentTitleLayout.setHorizontalGroup(
            contentTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etq_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentTitleLayout.setVerticalGroup(
            contentTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentTitleLayout.createSequentialGroup()
                .addComponent(etq_title, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentPrincipal.setBackground(new java.awt.Color(153, 153, 255));

        tx_lista.setBackground(new java.awt.Color(255, 255, 255));
        tx_lista.setForeground(new java.awt.Color(255, 255, 255));

        contentLista.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentListaLayout = new javax.swing.GroupLayout(contentLista);
        contentLista.setLayout(contentListaLayout);
        contentListaLayout.setHorizontalGroup(
            contentListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        contentListaLayout.setVerticalGroup(
            contentListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        tx_lista.setViewportView(contentLista);

        btnSalir.setBackground(new java.awt.Color(0, 0, 153));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Cancelar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tx_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tx_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.ventanaMenu.setVisible(true);
        dispose();
    }                                        

    public void imprimirFacturas(){
        Factura listaFacturas[] = this.ventanaMenu.database.listaFacturas();
        ItemFactura listaItems[] = this.ventanaMenu.database.listaItems();
        if (listaFacturas != null) {
            for (int i = 0; i < listaFacturas.length; i++) {
                if (listaFacturas[i] != null) {
                    etqTemporal = new JLabel(listaFacturas[i].getId()+" - "+listaFacturas[i].getCedula_cliente()+" -- "+listaFacturas[i].getCedula_vendedor()+" -- "+listaFacturas[i].getFecha()+" -- "+listaFacturas[i].getTotal());
                    etqTemporal.setFont(new Font("Arial", Font.PLAIN, 12));
                    etqTemporal.setBorder(new EmptyBorder(2,10,2,10));
                    contentLista.add(etqTemporal);
                    
                    final Factura temporal = listaFacturas[i];
                    final ItemFactura itemsTemp = listaItems[i];
                    btndetalles = new JButton ("Detalles");
                    btndetalles.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            abrirDetalle(temporal, itemsTemp);
                        }
                    });
                    contentLista.add(btndetalles);
                }else{
                    break;
                }
                
            }
            revalidate();
        }
    }
    
    public void abrirDetalle(Factura temporal, ItemFactura itemsTemp){
        this.ventana=new Detalles(this.ventanaMenu, temporal,itemsTemp);
        this.ventana.setVisible(true);
    }
    
    
    
    
    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_almacenes.png") ) );
        contentLista.setLayout( new BoxLayout(contentLista, BoxLayout.Y_AXIS) );
        contentLista.setBackground(Color.WHITE);
        imprimirFacturas();
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentLista;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JPanel contentTitle;
    private javax.swing.JLabel etq_title;
    private javax.swing.JScrollPane tx_lista;
    // End of variables declaration                   
}
