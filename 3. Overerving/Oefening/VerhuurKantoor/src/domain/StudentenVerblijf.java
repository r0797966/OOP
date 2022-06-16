package domain;

public class StudentenVerblijf extends Verblijf{
    private boolean gemeenteBelastingBetaald;

    // constructor
    public StudentenVerblijf(int verdiepingsnr, int verblijfsnr, double prijsPerVierkanteMeter, double oppervlakte){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
    }

    // setter
    public void setGemeenteBelastingBetaald(){this.gemeenteBelastingBetaald = !this.gemeenteBelastingBetaald;}

    // getter
    public boolean isGemeenteBelastingBetaald(){return this.gemeenteBelastingBetaald;}
}
