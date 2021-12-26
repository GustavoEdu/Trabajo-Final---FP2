import tipografias.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    private static final int ANCHO = 725;
    private static final int ALTO = 625;

    private JPanel contenedorGeneral;
    private JButton tipoPartida;
    private JButton botonMultijugador;
    private JButton salir;

    private JButton rapida;
    private JButton normal;
    private JButton avanzada;

    public Menu() {
        setTitle("The Elemental War");
        setSize(ANCHO, ALTO);
        setLayout(new BorderLayout());
        setBounds(0, 0, 625, 625);
        setLocationRelativeTo(null); //Centrar la Ventana
        setMinimumSize(new Dimension(325, 375)); //Medidas Mínimas
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }
    public void colocarPanelGeneral() {
        JLabel theLabel = new JLabel(new ImageIcon(getClass().getResource("/img/background.jpg")));
        setContentPane(theLabel);
        setLayout(new FlowLayout());
        contenedorGeneral = new JPanel();
        contenedorGeneral.setLayout(new FlowLayout());
        contenedorGeneral.setLayout(new GridLayout(2, 1));
        add(contenedorGeneral);
    }
    public void createContents() {
        colocarPanelGeneral();

        JPanel contenedorTitulo = new JPanel();
        contenedorTitulo.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("The Elemental War", SwingConstants.CENTER);
        Fuentes tipoFuente = new Fuentes();
        titulo.setFont(tipoFuente.fuente(tipoFuente.GODOFWAR, 0, 37));
        contenedorTitulo.add(titulo, BorderLayout.CENTER);
        contenedorGeneral.add(contenedorTitulo);

        JPanel contenedorOpciones = new JPanel();
        contenedorOpciones.setLayout(new GridLayout(3, 1, 5, 5));
        contenedorGeneral.add(contenedorOpciones);

        tipoPartida = new JButton("Jugar Partida");
        salir = new JButton("Salir");

        JPanel contenedorTipo = new JPanel(new GridLayout(1, 3));
        contenedorTipo.add(new JLabel()); //dummy component
        JPanel panelTipo = new JPanel(new BorderLayout());
        panelTipo.add(new JLabel(" "), BorderLayout.NORTH);
        panelTipo.add(tipoPartida, BorderLayout.CENTER);
        panelTipo.add(new JLabel(" "), BorderLayout.SOUTH);
        contenedorTipo.add(panelTipo);
        contenedorTipo.add(new JLabel()); //dummy component
        contenedorOpciones.add(contenedorTipo);

        JPanel contenedorMultijugador = new JPanel(new GridLayout(1, 3));
        contenedorMultijugador.add(new JLabel()); //dummy component
        JPanel panelMultijugador = new JPanel(new BorderLayout());
        panelMultijugador.add(new JLabel(" "), BorderLayout.NORTH);
        
        //ImageIcon ii = new ImageIcon(getClass().getResource("Gagua.gif"));
        //botonMultijugador.setIcon(ii);
        botonMultijugador = new JButton("Multijugador");
        panelMultijugador.add(botonMultijugador, BorderLayout.CENTER);
        panelMultijugador.add(new JLabel(" "), BorderLayout.SOUTH);
        contenedorOpciones.add(panelMultijugador);

        panelMultijugador.add(new JLabel(" "), BorderLayout.SOUTH);
        contenedorMultijugador.add(panelMultijugador);
        contenedorMultijugador.add(new JLabel()); //dummy component
        contenedorOpciones.add(contenedorMultijugador);

        JPanel contenedorSalir = new JPanel(new GridLayout(1, 3));
        contenedorSalir.add(new JLabel()); //dummy component
        JPanel panelSalir = new JPanel(new BorderLayout());
        panelSalir.add(new JLabel(" "), BorderLayout.NORTH); //dummy component
        panelSalir.add(salir, BorderLayout.CENTER);
        panelSalir.add(new JLabel(" "), BorderLayout.SOUTH); //dummy component
        contenedorSalir.add(panelSalir);
        contenedorSalir.add(new JLabel()); //dummy component
        contenedorOpciones.add(contenedorSalir);

        tipoPartida.addActionListener(new Listener());
        botonMultijugador.addActionListener(new Listener());
        salir.addActionListener(new Listener());
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) {
                case "Jugar Partida":
                    new MenuTipo();
                    setVisible(false);
                    break;
                case "Multijugador":
                    try {
                        new VentanaMultijugador().setVisible(true);
                        setVisible(false);
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Proximamente...");
                    }
                    break;
                case "Salir":
                    JOptionPane.showMessageDialog(rootPane, "Gracias por Jugar c:!");
                    System.exit(0);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        new Menu();
    }
}
