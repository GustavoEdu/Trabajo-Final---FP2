import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    private static final int ANCHO = 325;
    private static final int ALTO = 100;
    private JButton tipo;
    private JButton salir;

    public Menu() {
        setTitle("The Elemental War");
        setSize(ANCHO, ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    public void createContents() {
        JLabel titulo = new JLabel("The Elemental War");
        tipo = new JButton("Jugar Partida");
        salir = new JButton("Salir");
        add(titulo);
        add(tipo);
        add(salir);
        Listener theListener = new Listener();
        tipo.addActionListener(theListener);
        salir.addActionListener(theListener);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Jugar Partida")) {
                System.out.println("1.- Juego Rápido");
                System.out.println("2.- Juego Normal");
                System.out.println("3.- Juego Avanzado");
            }
            else {
                System.exit(1);
            }
        }
    }
}
