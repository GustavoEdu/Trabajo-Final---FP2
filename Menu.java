import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import tipografias.Fuentes; //Para las Fuentes

public class Menu extends JFrame {
    private static final int ANCHO = 725;
    private static final int ALTO = 625;

    private JPanel contenedorGeneral;
    private JButton tipoPartida;
    private JButton salir;

    private JButton rapida;
    private JButton normal;
    private JButton avanzada;
    
    public Menu() {
        setTitle("The Elemental War");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null); //Centrar la Ventana
        setMinimumSize(new Dimension(325, 375)); //Medidas Mínimas
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    public void createContents() {
        colocarPanelGeneral();

        JPanel contenedorTitulo = new JPanel();
        contenedorTitulo.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("The Elemental War", SwingConstants.CENTER);
        Fuentes tipoFuente = new Fuentes();
        titulo.setFont(tipoFuente.fuente(tipoFuente.GODOFWAR, 0, 56));
        contenedorTitulo.add(titulo, BorderLayout.CENTER);
        contenedorGeneral.add(contenedorTitulo);

        JPanel contenedorOpciones = new JPanel();
        contenedorOpciones.setLayout(new GridLayout(3, 1, 5, 5));
        contenedorGeneral.add(contenedorOpciones);

        tipoPartida = new JButton("Jugar Partida");
        salir = new JButton("Salir");
        
        JPanel contenedorTipo = new JPanel(new GridLayout(1, 3));
        contenedorTipo.add(new JLabel()); //dummy component
        contenedorTipo.add(tipoPartida);
        contenedorTipo.add(new JLabel()); //dummy component
        contenedorOpciones.add(contenedorTipo);

        JPanel contenedorMultijugador = new JPanel(new GridLayout(1, 3));
        contenedorMultijugador.add(new JLabel()); //dummy component
        contenedorMultijugador.add(new JButton("Multijugador")); //dummy component
        contenedorMultijugador.add(new JLabel()); //dummy component
        contenedorOpciones.add(contenedorMultijugador);

        JPanel contenedorSalir = new JPanel(new GridLayout(1, 3));
        contenedorSalir.add(new JLabel()); //dummy component
        contenedorSalir.add(salir);
        contenedorSalir.add(new JLabel()); //dummy component
        contenedorOpciones.add(contenedorSalir);

        //ListenerForMenu oyenteParaMenu = new ListenerForMenu();
        //tipoPartida.addActionListener(oyenteParaMenu);
        //salir.addActionListener(oyenteParaMenu);
    }
    public void colocarPanelGeneral() {
        contenedorGeneral = new JPanel();
        contenedorGeneral.setLayout(new GridLayout(2, 1));
        add(contenedorGeneral);
    }

    /*
    private class ListenerForMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Jugar Partida")) {
                //titulo.setVisible(false);
                //tipo.setVisible(false);
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
                    //jugarPartida(rand.nextInt(4) + 10);
                } else if(e.getActionCommand().equals("Partida Normal")) {
                    System.out.println("Partida Normal");
                } else {
                    System.out.println("Partida Avanzada");
                }
            }
            private JTextArea campo;
            private JTextField fil = new JTextField(10);
            private JTextField col = new JTextField(10);
            private JTextField fila = new JTextField(10);
            private JTextField columna= new JTextField(10);
            private Campo elCampo;
            private int turno=1;
            public void jugarPartida(int cant) {
                Nacion nacion1 = new Nacion("1");
                nacion1.generarNacion(cant);
                Nacion nacion2 = new Nacion("2");
                nacion2.generarNacion(cant);
                elCampo = new Campo(cant);
                elCampo.asignarPosiciones(nacion1.getGuerreros(), Campo.PLAYER_1);
                elCampo.asignarPosiciones(nacion2.getGuerreros(), Campo.PLAYER_2);

                campo = new JTextArea(elCampo.mostrarTablero());
                campo.setEditable(false);
                JScrollPane scroll = new JScrollPane(campo, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                
                
                
                add(campo);
                
                JLabel filaI = new JLabel("Fila: ");
                JLabel columnaI = new JLabel("Columna: ");
                JLabel posicionI = new JLabel("Posición del Soldado a mover: ");
                JLabel posicionF = new JLabel("Posición de destino del Soldado: ");
                
                add(posicionI);
                add(filaI);
                add(fil);
                add(columnaI);
                add(col);
                
                add(posicionF);
                add(filaI);
                add(fila);
                add(columnaI);
                add(columna);
                
                JButton enviar = new JButton("Mover");
                enviar.addActionListener(new ListenerForPos());
                add(enviar);
            }
            public class ListenerForPos implements ActionListener {
                public void actionPerformed(ActionEvent e){
                    if(e.getActionCommand().equals("Mover")){
                        
                        int fila1=Integer.parseInt(fil.getText());
                        int fila2=Integer.parseInt(fila.getText());
                        int colum1=Integer.parseInt(col.getText());
                        int colum2=Integer.parseInt(columna.getText());
                        elCampo.desplazarSoldadoVentana(fila1, colum1, fila2, colum2, turno);
                        columna.setText("");
                        fila.setText("");
                        col.setText("");
                        fil.setText("");
                        campo.setText(elCampo.mostrarTablero());
                        if(turno == 1){
                            turno =2;
                        }
                        else if(turno == 2){
                            turno =1;
                        }
                        
                    }
                }
            }
        }
    }
    */
    public static void main(String[] args) {
        new Menu();
    }
}
