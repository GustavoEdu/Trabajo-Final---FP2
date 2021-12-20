import java.util.*;
public class Campo {
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;
    private Guerrero[][] tablero;

    public Campo(int extension) {
        tablero = new Guerrero[extension][extension];
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
    public void mostrarTablero() {
        System.out.println("Nacion 1: ✠");
        System.out.println("Nacion 2: ☯");

        int counter = 1;
        boolean bandera = true;
        for(int i = 0; i < getExtension(); i++) {
            if(bandera) {
                System.out.print("\t");
                for(int k = 1; k <= getExtension(); k++) {
                    System.out.print(k + "\t");
                }
                System.out.println();
                bandera = false;
            }
            for(int j = 0; j < getExtension(); j++) {
                if(i >= 0 && j == 0) {
                    System.out.print(counter + "\t");
                    counter++;
                }
                if(tablero[i][j] != null) {
                    switch(tablero[i][j].getNacion()) {
                        case "1":
                            System.out.print("✠" + getSymbol(tablero[i][j]) + tablero[i][j].getVida() + "\t");
                            break;
                        case "2":
                            System.out.print("☯" + getSymbol(tablero[i][j]) + tablero[i][j].getVida() + "\t");
                            break;
                    }
                } else {
                    System.out.print("|_\t");
                }
            }
            System.out.println();
        }
    }
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
