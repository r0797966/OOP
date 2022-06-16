package domain;

public class Appartement extends Verblijf{
    private int aantalKamers;

    // constructor
    public Appartement(int verdiepingsnr, int verblijfsnr, Euro prijsPerVierkanteMeter, int oppervlakte, int aantalKamers){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
        if(aantalKamers < 0) throw new IllegalArgumentException("Ongeldig aantal kamers");
        this.aantalKamers = aantalKamers;
    }

    // methodes
    @Override
    public Euro getTotalePrijs(){
        Euro totaal = super.getTotalePrijs();
        if(aantalKamers >= 3) {
            Euro prijsKamers = new Euro(100, 0).produkt(aantalKamers);
            totaal = totaal.som(prijsKamers);
        }
        return totaal;
    }
}
