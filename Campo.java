import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Campo extends JFrame {
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;
    private Guerrero[][] tablero;
    private Nacion nacion1, nacion2;
    
    private static final int ANCHO = 975;
    private static final int ALTO = 975;

    private JPanel contenedorGeneral;
    private JPanel contenedorTablero;
    private JButton botonGanador;
    private JButton[][] board;

    public Campo(int extension) {
        nacion1 = new Nacion("1");
        nacion1.generarNacion(extension);
        nacion2 = new Nacion("2");
        nacion2.generarNacion(extension);

        tablero = new Guerrero[extension][extension]; 
        asignarPosiciones(nacion1.getGuerreros(), Campo.PLAYER_1);
        asignarPosiciones(nacion2.getGuerreros(), Campo.PLAYER_2);

        createContents();

        setTitle("The Elemental War");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null); //Centrar la Ventana
        setMinimumSize(new Dimension(375, 375)); //Medidas Mínimas
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void createContents() {
        colocarPanelGeneral();       
        inicializarTablero(getExtension());
        actualizarBoard();
    }
    private void colocarPanelGeneral() {
        contenedorGeneral = new JPanel(new GridLayout(2, 1));
        add(contenedorGeneral);        
        contenedorTablero = new JPanel(new GridLayout(getExtension(), getExtension()));
        contenedorGeneral.add(contenedorTablero);
        JPanel contenedorGanador = new JPanel(new GridLayout(3, 3));
        botonGanador = new JButton("Mostrar Ganador");
        
        botonGanador.addActionListener(new Listener());
        contenedorGanador.add(new JLabel(" "));
        contenedorGanador.add(new JLabel(" "));
        contenedorGanador.add(new JLabel(" "));
        contenedorGanador.add(new JLabel(" "));        
        contenedorGanador.add(botonGanador);
        contenedorGanador.add(new JLabel(" "));
        contenedorGanador.add(new JLabel(" "));
        contenedorGanador.add(new JLabel(" "));
        contenedorGeneral.add(contenedorGanador);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            int cant1, cant2;
            cant1 = nacion1.getGuerreros().size();
            cant2 = nacion2.getGuerreros().size();
            if(cant1 > cant2) {
                message = "La Nación 1 ha ganado la Partida!";
            } else if(cant1 < cant2) {
                message = "La Nación 2 ha ganado la Partida!";
            } else {
                message = "¡Empate!";
            }
            JOptionPane.showMessageDialog(rootPane, message);
            setVisible(false);
            System.exit(0);
        }
    }
    private void inicializarTablero(int extension) {
        board = new JButton[extension][extension];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = new JButton();
                contenedorTablero.add(board[i][j]);
            }
        }
    }
    public int getExtension() {
        return tablero.length;
    }
    public void asignarPosiciones(ArrayList<Guerrero> guerreros, int elBando) {
        Random rand = new Random();
        int randomFil, randomCol;
        for(Guerrero g: guerreros) {
            while(true) {
                randomFil = rand.nextInt(getExtension());
                randomCol = rand.nextInt(getExtension());
                if(tablero[randomFil][randomCol] == null) {
                    g.setBando(elBando);
                    tablero[randomFil][randomCol] = g;
                    break;
                }
            }
        }
    }
    public void actualizarBoard() {
        JOptionPane.showMessageDialog(rootPane, "Nacion 1: ✠\nNacion 2: ☯") ;
        String content = "";
        
        for(int i = 0; i < getExtension(); i++) {
            for(int j = 0; j < getExtension(); j++) {
                if(tablero[i][j] != null) {
                    switch(tablero[i][j].getNacion()) {
                        case "1":
                            content = "✠" + getSymbol(tablero[i][j]) + tablero[i][j].getVida();
                            break;
                        case "2":
                            content = "☯" + getSymbol(tablero[i][j]) + tablero[i][j].getVida();
                            break;
                    }
                    board[i][j].setText(content);
                } else {
                    board[i][j].setText("|_");
                }
            }
        }
    }
    /*
    public void desplazarSoldado(int turno) {
        Scanner sc = new Scanner(System.in);
        int fil, col, fila, columna;
        System.out.println("Turno del Jugador " + turno + ":");
        while(true) {
            System.out.println("Seleccionando Guerrero:");
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.nextInt();

            boolean toContinue = true;
            if((fil >= 1 && fil <= 10) && (col >= 1 && col <= 10)) {
                if(tablero[fil - 1][col - 1] != null) {
                    if(tablero[fil - 1][col - 1].getBando() == turno) {
                        while(true) {
                            System.out.println("Destino");
                            System.out.print("Fila: ");
                            fila = sc.nextInt();
                            System.out.print("Columna: ");
                            columna = sc.nextInt();

                            if((fila >= 1 && fila <= 10) && (columna >= 1 && columna <= 10)) {
                                if(tablero[fila - 1][columna - 1] == null) { //Sitio Libre
                                    tablero[fila - 1][columna - 1] = tablero[fil - 1][col - 1];
                                    tablero[fil - 1][col - 1] = null;
                                } else if(tablero[fila][columna].getBando() != turno) { //Enfrentamiento!
                                    
                                } else { //Entrada inválida
                                    System.out.println("No hay Guerra Civil!");
                                }
                                break;
                            } else {
                                System.out.println("Has querido mandar al Soldado afuera del Tablero!");
                            }
                        }
                        toContinue = false;
                    } else {
                        System.out.println("No puedes elegir un soldado del otro equipo");
                    }
                } else {
                    System.out.println("No hay un soldado hay!");
                }
            } else {
                System.out.println("Te has salido del tablero!");
            }
            if(!toContinue) {
                break;
            }
        }
    }
    
    public void desplazarSoldadoVentana(int fil,int col,int fila,int columna,int turno) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {

            boolean toContinue = true;
            if((fil >= 1 && fil <= tablero.length) && (col >= 1 && col <= tablero[1].length)) {
                if(tablero[fil - 1][col - 1] != null) {
                    if(tablero[fil - 1][col - 1].getBando() == turno) {
                        while(true) {
                            
                            if((fila >= 1 && fila <= tablero.length) && (columna >= 1 && columna <= tablero[1].length)) {
                                if(tablero[fila - 1][columna - 1] == null) { //Sitio Libre
                                    tablero[fila - 1][columna - 1] = tablero[fil - 1][col - 1];
                                    tablero[fil - 1][col - 1] = null;
                                } else if(tablero[fila][columna].getBando() != turno) { //Enfrentamiento!
                                    
                                } else { //Entrada inválida
                                    System.out.println("No hay Guerra Civil!");
                                    break;
                                }
                                break;
                            } else {
                                System.out.println("Has querido mandar al Soldado afuera del Tablero!");
                                break;
                            }
                        }
                        toContinue = false;
                    } else {
                        System.out.println("No puedes elegir un soldado del otro equipo");
                        JOptionPane.showMessageDialog(null, "No puedes elegir un soldado del otro equipo");
                        break;
                    }
                } else {
                    System.out.println("No hay un soldado hay!");
                    JOptionPane.showMessageDialog(null, "No hay un soldado hay!");
                    break;
                }
            } else {
                System.out.println("Te has salido del tablero!");
                JOptionPane.showMessageDialog(null, "Te has salido del tablero!");
                break;
            }
            if(!toContinue) {
                break;
            }
        }
    }
    */
    public static String getSymbol(Guerrero elGuerrero) {
        if(elGuerrero instanceof Agua) {
            return "W";
        } else if(elGuerrero instanceof Tierra) {
            return "D";
        } else if(elGuerrero instanceof Fuego) {
            return "F";
        } else {
            return "A";
        }
    }
}
