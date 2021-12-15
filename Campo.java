import java.util.*;
public class Campo {
    private Guerrero[][] tablero;

    public Campo(int extension) {
        tablero = new Guerrero[extension][extension];
    }
    
    public int getExtension() {
        return tablero.length;
    }
    public void asignarPosiciones(ArrayList<Guerrero> guerreros) {
        Random rand = new Random();
        int randomFil, randomCol;
        for(Guerrero g: guerreros) {
            while(true) {
                randomFil = rand.nextInt(getExtension());
                randomCol = rand.nextInt(getExtension());
                if(tablero[randomFil][randomCol] == null) {
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
