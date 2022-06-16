package domain;

public class Appartement extends Verblijf{
    private int aantalKamers;

    public Appartement(int verdiepingsnr, int verblijfsnr, double prijsPerVierkanteMeter, double oppervlakte, int aantalKamers){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
        this.setAantalKamers(aantalKamers);
    }

    // setter
    public void setAantalKamers(int aantal){
        if(aantal < 0) throw new IllegalArgumentException();
        this.aantalKamers = aantal;
    }

    // methodes
    @Override
    public double getTotalePrijs(){
        return super.getTotalePrijs() + (100 * aantalKamers);
    }
}
