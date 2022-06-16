package domain;

public class Studentenkamer extends Verblijf implements heeftGemeenteBelastingBetaald {
    private boolean isBelastingBetaald;

    // constructor
    public Studentenkamer(int verdiepingsnr, int verblijfsnr, double prijsPerVierkanteMeter, double oppervlakte){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
        this.isBelastingBetaald = false;
    }

    // methodes
    public boolean heeftGemeenteBelastingBetaald(){return this.isBelastingBetaald;}

    public void setGemeenteBelastingBetaald(boolean b){
        this.isBelastingBetaald = b;
    }
}
