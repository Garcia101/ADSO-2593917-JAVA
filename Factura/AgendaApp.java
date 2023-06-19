import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgendaApp extends JFrame implements ActionListener {

    private JLabel lblName, lblPhone, lblEmail;
    private JTextField txtName, txtPhone, txtEmail;
    private JButton btnAdd, btnDelete;
    private JTextArea txtArea;

    public AgendaApp() {
        super("Agenda App");
        
        // Crear componentes de la interfaz
        lblName = new JLabel("Name:");
        lblPhone = new JLabel("Phone:");
        lblEmail = new JLabel("Email:");
        txtName = new JTextField(20);
        txtPhone = new JTextField(20);
        txtEmail = new JTextField(20);
        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");
        txtArea = new JTextArea(10, 30);

        // Crear panel para agregar los componentes
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblPhone);
        panel.add(txtPhone);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(btnAdd);
        panel.add(btnDelete);

        // Crear panel para la JTextArea
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(new JScrollPane(txtArea));

        // Agregar paneles a la ventana
        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);

        // Agregar listeners a los botones
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);

        // Configurar la ventana
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Manejador de eventos para los botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            txtArea.append(name + " - " + phone + " - " + email + "\n");
            txtName.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
        } else if (e.getSource() == btnDelete) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this contact?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                txtArea.setText("");
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        new AgendaApp();
    }
}

