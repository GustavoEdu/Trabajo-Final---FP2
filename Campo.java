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
    private JToggleButton[][] board;
    
    private int cantidadB = 0;
    private JToggleButton aux = new JToggleButton();
    private Guerrero auxGuerrero;
    //Guardado del Primer Click
    private int fila;
    private int columna;
    
    public Campo(int extension) {
        JOptionPane.showMessageDialog(rootPane, "Nacion 1: ✠\nNacion 2: ☯") ;
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
        botonGanador = new JButton("1");
        botonGanador.setEnabled(false);
        
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
    private void inicializarTablero(int extension) {
        board = new JToggleButton[extension][extension];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = new JToggleButton();
                board[i][j].addActionListener(new BoardListener());
                contenedorTablero.add(board[i][j]);
            }
        }
    }
    private class BoardListener implements ActionListener {
        boolean hayCasillaSeleccionada = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean toContinue = true;
            if(!aux.isSelected()) {
                aux = (JToggleButton) e.getSource();
            }
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if(board[i][j] == (JToggleButton)e.getSource() && cantidadB == 0) {
                        if(tablero[i][j] == null) {
                            JOptionPane.showMessageDialog(rootPane, "No hay un Guerrero hay!");
                            board[i][j].setSelected(false);
                            cantidadB = 0;
                        } else {
                            //Hay una casilla seleccionada
                            cantidadB++;
                            auxGuerrero = tablero[i][j];
                            fila = i;
                            columna = j;
                            
                            if(!String.valueOf(auxGuerrero.getBando()).equals(botonGanador.getText())) {
                                JOptionPane.showMessageDialog(rootPane, "No es tu turno!");
                                board[i][j].setSelected(false);
                                cantidadB = 0;
                            }
                            
                            toContinue = false;
                        }
                    } else if(board[i][j] == (JToggleButton)e.getSource() && cantidadB == 1 && board[i][j].isSelected() && aux.isSelected()) {
                        //Hay dos casillas seleccionadas
                        cantidadB = 0;
                        
                        Guerrero guerreroAntes = auxGuerrero;
                        Guerrero guerreroAhora = tablero[i][j];
                        
                        if(guerreroAntes == null) {
                            board[i][j].setSelected(false);
                            aux.setSelected(false);
                        } else {
                            if(tablero[i][j] != null && tablero[i][j].getBando() != auxGuerrero.getBando()) {
                                JOptionPane.showMessageDialog(rootPane, "Hay Guerra!");
                                if(guerreroAhora.getVida() > guerreroAntes.getVida()) {
                                    JOptionPane.showMessageDialog(rootPane, "Ha ganado el guerrero defensor!");
                                    tablero[fila][columna] = null;
                                } else if(guerreroAhora.getVida() < guerreroAntes.getVida()) {
                                    JOptionPane.showMessageDialog(rootPane, "Ha ganado el guerrero atacante!");
                                    tablero[i][j] = guerreroAntes;
                                    tablero[fila][columna] = null;
                                } else {
                                    Random rand = new Random();
                                    JOptionPane.showMessageDialog(rootPane, "Muerte súbita!");
                                    if(rand.nextInt(2) == 1) {
                                        JOptionPane.showMessageDialog(rootPane, "Ha ganado el guerrero defensor!");
                                        tablero[fila][columna] = null;
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Ha ganado el guerrero atacante!");
                                        tablero[i][j] = guerreroAntes;
                                        tablero[fila][columna] = null;
                                    }
                                }
                                if(botonGanador.getText().equals("1")) {
                                    botonGanador.setText("2");
                                } else {
                                    botonGanador.setText("1");
                                }
                                //turno++;
                            } else if(tablero[i][j] != null && tablero[i][j].getBando() == auxGuerrero.getBando()) {
                                JOptionPane.showMessageDialog(rootPane, "No puede haber una Guerra Civil!");
                                //turno++;
                            } else {
                                tablero[i][j] = auxGuerrero;
                                tablero[fila][columna] = null;
                                //turno++;
                                if(botonGanador.getText().equals("1")) {
                                    botonGanador.setText("2");
                                } else {
                                    botonGanador.setText("1");
                                }
                            }
                            actualizarBoard();
                            //Desmarque
                            board[i][j].setSelected(false);
                            aux.setSelected(false);
                        
                            toContinue = false;
                        }
                    }
                    if(!toContinue) {
                        break;
                    }
                }
                if(!toContinue) {
                    break;
                }
            }
            int cantN1 = 0, cantN2 = 0;
            for(int i = 0; i < tablero.length; i++) {
                for(int j = 0; j < tablero[i].length; j++) {
                    if(tablero[i][j] != null) {
                        if(tablero[i][j].getBando() == 1) {
                            cantN1++;
                        } else {
                            cantN2++;
                        }   
                    }
                }
            }
            if(cantN1 == 0 || cantN2 == 0) {
                if(cantN1 == 0 && cantN2 != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Ha ganado la Nación 2!");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ha ganado la Nación1");
                }
                System.exit(0);
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
                    board[i][j].setOpaque(true);
                    board[i][j].setBackground(new Color(255, 255, 0));
                }
            }
        }
    }
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
