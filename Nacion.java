import java.util.*;
public class Nacion {
    
    private ArrayList<Guerrero>miNacion=new ArrayList<Guerrero>();
    private String nombreNacion;
    
    public Nacion(String n){
        nombreNacion=n;
    }
    public Nacion(){
    }
    public ArrayList<Guerrero> getGuerreros() {
        return miNacion;
    }
    
    public void generarNacion(int a){
        Random rand=new Random();
        for(int i=0;i<a;i++){
            Guerrero miGuerrero;
            int tipoDeGuerrero=rand.nextInt(4)+1;
            if(tipoDeGuerrero==1){
                String nombre="WaterOP"+(i+1);
                int nivel=rand.nextInt(3)+1;
                int vida = rand.nextInt(7)+1;
                int ataque = rand.nextInt(5)+1;
                int defensa = rand.nextInt(5)+1;
                miGuerrero=new Agua(nombre,nivel,vida,ataque,defensa);
                miGuerrero.setNacion(nombreNacion);
                miNacion.add(miGuerrero);
                
            }
            else if(tipoDeGuerrero==2){
                String nombre="FireOP"+(i+1);
                int nivel=rand.nextInt(3)+1;
                int vida = rand.nextInt(7)+1;
                int ataque = rand.nextInt(5)+1;
                int defensa = rand.nextInt(5)+1;
                miGuerrero=new Tierra(nombre,nivel,vida,ataque,defensa);
                miGuerrero.setNacion(nombreNacion);
                miNacion.add(miGuerrero);
            }
            else if(tipoDeGuerrero==3){
                String nombre="EarthOP"+(i+1);
                int nivel=rand.nextInt(3)+1;
                int vida = rand.nextInt(7)+1;
                int ataque = rand.nextInt(5)+1;
                int defensa = rand.nextInt(5)+1;
                miGuerrero=new Aire(nombre,nivel,vida,ataque,defensa);
                miGuerrero.setNacion(nombreNacion);
                miNacion.add(miGuerrero);
            }
            else if(tipoDeGuerrero==4){
                String nombre="AirOP"+(i+1);
                int nivel=rand.nextInt(3)+1;
                int vida = rand.nextInt(7)+1;
                int ataque = rand.nextInt(5)+1;
                int defensa = rand.nextInt(5)+1;
                miGuerrero=new Fuego(nombre,nivel,vida,ataque,defensa);
                miGuerrero.setNacion(nombreNacion);
                miNacion.add(miGuerrero);
            }
        }
    }
}