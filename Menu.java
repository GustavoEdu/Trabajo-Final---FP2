import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Nota: Tener en cuenta JPanel
public class Menu extends JFrame {
    private static final int ANCHO = 1000;
    private static final int ALTO = 625;
    private JLabel titulo;
    private JButton tipo;
    private JButton salir;

    private JButton rapida;
    private JButton normal;
    private JButton avanzada;
    
    public Menu() {
        setTitle("The Elemental War");
        setSize(ANCHO, ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    public void createContents() {
        titulo = new JLabel("The Elemental War");
        tipo = new JButton("Jugar Partida");
        salir = new JButton("Salir");
        //ImageIcon myImage = new ImageIcon("hamster.jpg");
        //JLabel someImage = new JLabel();
        //someImage.setIcon(new ImageIcon(myImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        //add(someImage);
        add(titulo);
        add(tipo);
        add(salir);
        ListenerForMenu oyenteParaMenu = new ListenerForMenu();
        tipo.addActionListener(oyenteParaMenu);
        salir.addActionListener(oyenteParaMenu);
    }
    private class ListenerForMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Jugar Partida")) {
                titulo.setVisible(false);
                tipo.setVisible(false);
                salir.setVisible(false);
                
                rapida = new JButton("Partida Rápida");
                normal = new JButton("Partida Normal");
                avanzada = new JButton("Partida Avanzada");
                add(rapida);
                add(normal);
                add(avanzada);
                ListenerForTipo oyenteParaTipo = new ListenerForTipo();
                rapida.addActionListener(oyenteParaTipo);
                normal.addActionListener(oyenteParaTipo);
                avanzada.addActionListener(oyenteParaTipo);
            }
            else {
                System.exit(1);
            }
        }
        private class ListenerForTipo implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Partida Rápida")) {
                    System.out.println("Partida Rápida");
                    rapida.setVisible(false);
                    normal.setVisible(false);
                    avanzada.setVisible(false);
                    Random rand = new Random();
                    jugarPartida(rand.nextInt(4) + 10);
                } else if(e.getActionCommand().equals("Partida Normal")) {
                    System.out.println("Partida Normal");
                } else {
                    System.out.println("Partida Avanzada");
                }
            }
            private JTextArea campo;
            public void jugarPartida(int cant) {
                Nacion nacion1 = new Nacion("1");
                nacion1.generarNacion(cant);
                Nacion nacion2 = new Nacion("2");
                nacion2.generarNacion(cant);
                Campo elCampo = new Campo(cant);
                elCampo.asignarPosiciones(nacion1.getGuerreros(), Campo.PLAYER_1);
                elCampo.asignarPosiciones(nacion2.getGuerreros(), Campo.PLAYER_2);

                campo = new JTextArea(elCampo.mostrarTablero());
                campo.setEditable(false);
                add(campo);
            }
        }
    }
    public static void main(String[] args) {
        new Menu();
    }
}
