public class Aire extends Guerrero{
    public Aire(String n,int ni,int vid,int ata, int def){
        super(n,ni,vid,ata,def);
        setTipoGuerrero("Aire");
        debilidades.add("Fuego");
        fortalezas.add("Tierra");
        fortalezas.add("Agua");
    }
    public Aire(){
    }
}