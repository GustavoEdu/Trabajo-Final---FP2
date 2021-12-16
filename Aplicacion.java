import java.util.*;
public class Aplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    Random rand = new Random();
                    switch(op) {
                        case "1":
                            jugarPartida(rand.nextInt(4) + 10);
                            break;
                        case "2":
                            jugarPartida(rand.nextInt(3) + 15);
                            break;
                        case "3":
                            jugarPartida(rand.nextInt(4) + 20);
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
        System.out.println("The Elemental War 1ra Parte");
        System.out.println("1.- Jugar partida");
        System.out.println("2.- Salir");
    }
    public static void mostrarMenuPartidas() {
        System.out.println("1.- Juego Rápido");
        System.out.println("2.- Juego Normal");
        System.out.println("3.- Juego Avanzado");
    }
    public static void jugarPartida(int cant) {
        Nacion nacion1 = new Nacion("1");
        nacion1.generarNacion(cant);
        Nacion nacion2 = new Nacion("2");
        nacion2.generarNacion(cant);
        Campo elCampo = new Campo(cant);
        elCampo.asignarPosiciones(nacion1.getGuerreros());
        elCampo.asignarPosiciones(nacion2.getGuerreros());
        elCampo.mostrarTablero();
        mostrarGanador(nacion1, nacion2);
    }
    public static void mostrarGanador(Nacion nacion1, Nacion nacion2) {
        int average1, average2;
        average1 = getAverage(nacion1.getGuerreros());
        average2 = getAverage(nacion2.getGuerreros());

        double total = average1 + average2, prob1, prob2, aleatorio;
        prob1 = (average1 / total) * 100;
        prob2 = 100 - prob1;
        aleatorio = Math.random() * 100;

        System.out.println("Intervalo de la Nacion 1: [0; " + redondear(prob1) + ">");
        System.out.println("Intervalo de la Nacion 2: [" + redondear(prob1) + "; 100]");
        System.out.println("Numero aleatorio: " + redondear(aleatorio));

        if(aleatorio <= prob1) {
            System.out.println("La Nacion 1 ha ganado la Partida!");
        } else {
            System.out.println("La Nacion 2 ha ganado la Partida!");
        }
    }
    public static int getAverage(ArrayList<Guerrero> guerreros) {
        int sum = 0;
        for(Guerrero g: guerreros) {
            sum += g.getVida();
            sum += g.getAtaque();
            sum += g.getDefensa();
        }
        return (int)(Math.round(sum / guerreros.size()));
    }
    public static double redondear(double num) {
        return Math.round(num * 10) / 10.0;
    }
}
