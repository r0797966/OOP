package domain;

public class Studio extends Verblijf implements heeftGemeenteBelastingBetaald {
    public int oppervlakteBadkamer;
    private boolean gemeenteBelastingBetaald;

    // constructor
    public Studio(int verdiepingsnr, int verblijfsnr, Euro prijsPerVierkanteMeter, int oppervlakte, int oppervlakteBadkamer){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
        if(oppervlakteBadkamer <= 0) throw new IllegalArgumentException("Ongeldig oppervlakte badkamer");
        this.oppervlakteBadkamer = oppervlakteBadkamer;
    }

    // methodes
    @Override
    public Euro getTotalePrijs(){
        Euro totaal = super.getTotalePrijs();
        Euro prijsBadkamer = super.getPrijsPerVierkanteMeter().produkt(oppervlakteBadkamer).produkt(2);
        return totaal.som(prijsBadkamer);
    }

    public boolean heeftGemeenteBelastingBetaald(){return gemeenteBelastingBetaald;}

    public void setGemeenteBelastingenBetaald(boolean gemeenteBelasting){
        this.gemeenteBelastingBetaald = gemeenteBelasting;
    }
}
