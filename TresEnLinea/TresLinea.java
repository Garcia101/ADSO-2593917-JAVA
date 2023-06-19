import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;
// import javax.swing.border.LineBorder;

public class TresLinea extends JFrame {
    public TresLinea (){
        initComponet();
    }

    public void initComponet(){
        Toolkit sistema = Toolkit.getDefaultToolkit();
        Dimension tamanio = sistema.getScreenSize();

        setVisible(true);
        setTitle("===TRES EN LINEA===");
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());
        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints restriccion = new GridBagConstraints();

        // JLabel primerCampo = new JLabel("===TRIKI===");
        // restriccion.gridy = 0;
        // restriccion.gridx = 0;
        // restriccion.gridheight = 1;
        // restriccion.gridwidth = 1;
        // restriccion.weighty = 1;
        // restriccion.weightx = 10;
        // contenedor.add(primerCampo, restriccion);

        JLabel segundoCampo = new JLabel("---");
        segundoCampo.setOpaque(true);
        segundoCampo.setBackground(Color.white);
        segundoCampo.setHorizontalAlignment(JLabel.CENTER);
        segundoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border = BorderFactory.createLineBorder(Color.RED, 2);
        segundoCampo.setBorder(border);
        restriccion.gridy = 1;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 40;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(segundoCampo, restriccion);

        JLabel tercerCampo = new JLabel("---");
        tercerCampo.setOpaque(true);
        tercerCampo.setBackground(Color.white);
        tercerCampo.setHorizontalAlignment(JLabel.CENTER);
        tercerCampo.setVerticalAlignment(JLabel.CENTER);
        Border border1 = BorderFactory.createLineBorder(Color.RED, 2);
        tercerCampo.setBorder(border1);
        restriccion.gridy = 1;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 40;
        contenedor.add(tercerCampo, restriccion);

        JLabel cuartoCampo = new JLabel("---");
        cuartoCampo.setOpaque(true);
        cuartoCampo.setBackground(Color.white);
        cuartoCampo.setHorizontalAlignment(JLabel.CENTER);
        cuartoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border2 = BorderFactory.createLineBorder(Color.RED, 2);
        cuartoCampo.setBorder(border2);
        restriccion.gridy = 1;
        restriccion.gridx = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 40;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(cuartoCampo, restriccion);

        JLabel quintoCampo = new JLabel("---");
        quintoCampo.setOpaque(true);
        quintoCampo.setBackground(Color.white);
        quintoCampo.setHorizontalAlignment(JLabel.CENTER);
        quintoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border3 = BorderFactory.createLineBorder(Color.RED, 2);
        quintoCampo.setBorder(border3);
        restriccion.gridy = 2;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 40;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(quintoCampo, restriccion);

        JLabel sextoCampo = new JLabel("---");
        sextoCampo.setOpaque(true);
        sextoCampo.setBackground(Color.white);
        sextoCampo.setHorizontalAlignment(JLabel.CENTER);
        sextoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border4 = BorderFactory.createLineBorder(Color.RED, 2);
        sextoCampo.setBorder(border4);
        restriccion.gridy = 2;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 30;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(sextoCampo, restriccion);

        JLabel septimoCampo = new JLabel("---");
        septimoCampo.setOpaque(true);
        septimoCampo.setBackground(Color.white);
        septimoCampo.setHorizontalAlignment(JLabel.CENTER);
        septimoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border5 = BorderFactory.createLineBorder(Color.RED, 2);
        septimoCampo.setBorder(border5);
        restriccion.gridy = 2;
        restriccion.gridx = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 30;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(septimoCampo, restriccion);

        JLabel octavoCampo = new JLabel("---");
        octavoCampo.setOpaque(true);
        octavoCampo.setBackground(Color.white);
        octavoCampo.setHorizontalAlignment(JLabel.CENTER);
        octavoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border6 = BorderFactory.createLineBorder(Color.RED, 2);
        octavoCampo.setBorder(border6);
        restriccion.gridy = 3;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 30;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(octavoCampo, restriccion);

        JLabel novenoCampo = new JLabel("---");
        novenoCampo.setOpaque(true);
        novenoCampo.setBackground(Color.white);
        novenoCampo.setHorizontalAlignment(JLabel.CENTER);
        novenoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border7 = BorderFactory.createLineBorder(Color.RED, 2);
        novenoCampo.setBorder(border7);
        restriccion.gridy = 3;
        restriccion.gridx = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 30;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(novenoCampo, restriccion);

        JLabel decimoCampo = new JLabel("---");
        decimoCampo.setOpaque(true);
        decimoCampo.setBackground(Color.white);
        decimoCampo.setHorizontalAlignment(JLabel.CENTER);
        decimoCampo.setVerticalAlignment(JLabel.CENTER);
        Border border8 = BorderFactory.createLineBorder(Color.RED, 2);
        decimoCampo.setBorder(border8);
        restriccion.gridy = 3;
        restriccion.gridx = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 30;
        restriccion.weightx = 30;
        restriccion.insets = new Insets(0, 0, 10, 0);
        contenedor.add(decimoCampo, restriccion);

        add(contenedor);
        setResizable(false);
        setVisible(true);
        revalidate();
        repaint();
    }
}