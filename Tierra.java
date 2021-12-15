public class Tierra extends Guerrero{
    
    public Tierra(String n,int ni,int vid,int ata, int def){
        super(n,ni,vid,ata,def);
        setTipoGuerrero("Tierra");
        debilidades.add("Aire");
        fortalezas.add("Fuego");
        fortalezas.add("Agua");
    }
    public Tierra(){
    }
}