import java.util.*;
public class Aplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Nacion nacion1, nacion2;
        //nacion1 = new Nacion();
        //nacion2 = new Nacion();
        String op;
        boolean toContinue = true;
        //Se implementará una interfaz gráfica posteriormente
        //new Menu();
        //Vista en la Ventana de Comandos
        do {
            mostrarMenu();
            System.out.print("Introduzca una opcion: ");
            op = sc.next();
            switch(op) {
                case "1":
                    mostrarMenuPartidas();
                    System.out.print("Introduzca una opcion: ");
                    op = sc.next();
                    switch(op) {
                        case "1":
                            Random rand = new Random();
                            Nacion nacion1 = new Nacion("1");
                            nacion1.generarNacion(rand.nextInt(5) + 1);
                            Nacion nacion2 = new Nacion("2");
                            nacion2.generarNacion(rand.nextInt(5) + 1);
                            Campo elCampo = new Campo(7);
                            elCampo.asignarPosiciones(nacion1.getGuerreros());
                            elCampo.asignarPosiciones(nacion2.getGuerreros());
                            elCampo.mostrarTablero();
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Entrada no valida!");
                    }
                    op = "";
                    break;
                case "2":
                    toContinue = false;
                    break;
                default:
                    System.out.println("Entrada no valida!");
            }
            System.out.println();
        } while(toContinue);
    }
    public static void mostrarMenu() {
        System.out.println("The Elemental War");
        System.out.println("1.- Jugar partida");
        System.out.println("2.- Salir");
    }
    public static void mostrarMenuPartidas() {
        System.out.println("1.- Juego Rápido");
        System.out.println("2.- Juego Normal");
        System.out.println("3.- Juego Avanzado");
    }
}
