import java.util.*;
public abstract class Guerrero {
    private String nacion;
    private String name;
    private String tipoGuerrero;
    private int bando; //Para Mapa
    
    //private int fila;
    //private String columna;
    
    private int nivel;
    private int vida;
    private int ataque;
    private int defensa;
    
    protected ArrayList<String>debilidades=new ArrayList<String>();
    protected ArrayList<String>fortalezas=new ArrayList<String>();
    
    public Guerrero(String n,int ni,int vid,int ata, int def){
        name=n;
        nivel=ni;
        vida=vid;
        ataque=ata;
        defensa=def;
    }
    public Guerrero(){
    }
    //Métodos set
    /*
    public void setFila(int f){
        fila=f;
    }
    
    public void setColumna(String c){
        columna=c;
    }
    */
    public void setNacion(String na){
        nacion=na;
    }
    public void setName(String na){
        name=na;
    }
    public void setNivel(int niv){
        nivel=niv;
    }
    public void setVida(int vid){
        vida=vid;
    }
    public void setAtaque(int at){
        ataque=at;
    }
    public void setDefensa(int def){
        defensa=def;
    }
    public void setTipoGuerrero(String n){
        tipoGuerrero=n;
    }
    public void setBando(int b) {
        bando = b;
    }
    //Métodos get
    /*
    public int getFila(){
        return fila;
    }
    public String getColumna(){
        return columna;
    }
    */
    public String getNacion(){
        return nacion;
    }
    public String getName(){
        return name;
    }
    public int getNivel(){
        return nivel;
    }
    public int getVida(){
        return vida;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefensa(){
        return defensa;
    }
    public String getTipoGuerrero(){
        return tipoGuerrero;
    }
    public int getBando() {
        return bando;
    }

    //Métodos
    public void verificarDOF(){
        System.out.println("Para ver si un guerrero es más fuerte que otro según su elemento este método sería mejor en el mapa");
    }
    public String toString() {
        return "Nivel Vida: " + getVida() + "\n" +
                "Nivel Ataque: " + getAtaque() + "\n" + 
                "Nivel Defensa: " + getDefensa();
    }
}
