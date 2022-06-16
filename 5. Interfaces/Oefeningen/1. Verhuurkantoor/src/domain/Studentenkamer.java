package domain;

public class Studentenkamer extends Verblijf implements heeftGemeenteBelastingBetaald {
    private boolean gemeenteBelastingBetaald;

    // constructor
    public Studentenkamer(int verdiepingsnr, int verblijfsnr, Euro prijsPerVierkanteMeter, int oppervlakte){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
    }

    public boolean heeftGemeenteBelastingBetaald(){return gemeenteBelastingBetaald;}

    public void setGemeenteBelastingenBetaald(boolean gemeenteBelasting){
        this.gemeenteBelastingBetaald = !this.gemeenteBelastingBetaald;
    }
}
