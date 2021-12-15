public class Fuego extends Guerrero{
    
   
    public Fuego(String n,int ni,int vid,int ata, int def){
        super(n,ni,vid,ata,def);
        setTipoGuerrero("Fuego");
        debilidades.add("Tierra");
        debilidades.add("Aire");
        fortalezas.add("Fuego");
    }
    public Fuego(){
    }
    
}