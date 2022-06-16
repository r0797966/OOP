package domain;

public class Studentenverblijf extends Verblijf {
    private boolean isBelastingBetaald;

    // constructor
    public Studentenverblijf(int verdiepingsnr, int verblijfsnr, Euro prijsPerVierkanteMeter, int oppervlakte){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
    }

    // getters
    public boolean isBelastingBetaald(){return isBelastingBetaald;}

    // setters
    public void setBelastingBetaald(){
        this.isBelastingBetaald = !this.isBelastingBetaald;
    }


}
