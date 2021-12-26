import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AuxMenuTipoPartida extends JFrame {
    private static final int ANCHO = 725;
    private static final int ALTO = 625;

    private JPanel panelGeneral;
    private JButton rapida;
    private JButton normal;
    private JButton avanzada;

    public AuxMenuTipoPartida() {
        setTitle("The Elemental War");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null); //Centrar la Ventana
        setMinimumSize(new Dimension(325, 375)); //Medidas Mínimas
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    private void colocarPanelGeneral() {
        panelGeneral = new JPanel();
        panelGeneral.setLayout(new GridLayout(2, 1));
        add(panelGeneral);
    }
    private void createContents() {
        colocarPanelGeneral();

        JLabel etiquetaPrompt = new JLabel("Elija una Opción:", SwingConstants.CENTER);
        panelGeneral.add(etiquetaPrompt);

        JPanel contenedorOpciones = new JPanel(new GridLayout(2, 1));

        JPanel panelOpciones1 = new JPanel(new GridLayout(1, 2));
        JPanel panelOpcion1 = new JPanel(new BorderLayout());
        rapida = new JButton("Partida Rápida");

        panelOpcion1.add(new JLabel(" "), BorderLayout.NORTH);
        panelOpcion1.add(new JLabel("                          "), BorderLayout.EAST);
        panelOpcion1.add(rapida, BorderLayout.CENTER);
        panelOpcion1.add(new JLabel(" "), BorderLayout.SOUTH);
        panelOpcion1.add(new JLabel("                          "), BorderLayout.WEST);

        JPanel panelOpcion2 = new JPanel(new BorderLayout());
        normal = new JButton("Partida Normal");

        panelOpcion2.add(new JLabel(" "), BorderLayout.NORTH);
        panelOpcion2.add(new JLabel("                          "), BorderLayout.EAST);
        panelOpcion2.add(normal, BorderLayout.CENTER);
        panelOpcion2.add(new JLabel(" "), BorderLayout.SOUTH);
        panelOpcion2.add(new JLabel("                          "), BorderLayout.WEST);

        panelOpciones1.add(panelOpcion1);
        panelOpciones1.add(panelOpcion2);
        contenedorOpciones.add(panelOpciones1);


        JPanel contenedorOpcion3 = new JPanel(new GridLayout(1, 3));

        contenedorOpcion3.add(new JLabel(" "));
        JPanel panelOpcion3 = new JPanel(new BorderLayout());
        avanzada = new JButton("Avanzada");
        panelOpcion3.add(new JLabel(" "), BorderLayout.NORTH);
        panelOpcion3.add(new JLabel(" "), BorderLayout.EAST);
        panelOpcion3.add(avanzada, BorderLayout.CENTER);
        panelOpcion3.add(new JLabel(" "), BorderLayout.SOUTH);
        panelOpcion3.add(new JLabel(" "), BorderLayout.WEST);
        contenedorOpcion3.add(panelOpcion3);
        contenedorOpcion3.add(new JLabel(" "));

        contenedorOpciones.add(contenedorOpcion3);

        panelGeneral.add(contenedorOpciones);

        Listener theListener = new Listener();
        rapida.addActionListener(theListener);
        normal.addActionListener(theListener);
        avanzada.addActionListener(theListener);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            if(e.getActionCommand().equals("Partida Rápida")) {
                //JOptionPane.showMessageDialog(rootPane, "Partida Rápida");
                new Campo(rand.nextInt(3) + 10);
            } else if(e.getActionCommand().equals("Partida Normal")) {
                //JOptionPane.showMessageDialog(rootPane, "Partida Normal");
                new Campo(rand.nextInt(2) + 13);
            } else {
                //JOptionPane.showMessageDialog(rootPane, "Partida Avanzada");
                new Campo(rand.nextInt(2) + 15);
            }
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AuxMenuTipoPartida();
    }
}
