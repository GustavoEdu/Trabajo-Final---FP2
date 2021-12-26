import java.util.*;
public class Agua extends Guerrero{
    public Agua(String n,int ni,int vid,int ata, int def){
        super(n,ni,vid,ata,def);
        setTipoGuerrero("Agua");
        debilidades.add("Tierra");
        debilidades.add("Aire");
        fortalezas.add("Fuego");
    }
    public Agua(){
    }
}