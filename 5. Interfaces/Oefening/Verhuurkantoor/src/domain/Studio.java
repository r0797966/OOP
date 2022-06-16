package domain;

public class Studio extends Verblijf implements heeftGemeenteBelastingBetaald{
    private double grootteBadkamer;
    private boolean isBelastingBetaald;

    // constructor
    public Studio(int verdiepingsnr, int verblijfsnr, double prijsPerVierkanteMeter, double oppervlakte, double grootteBadkamer){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
        this.setGrootteBadkamer(grootteBadkamer);
        this.isBelastingBetaald = false;
    }

    // setters
    public void setGrootteBadkamer(double grootte){
        if(grootte <= 0) throw new IllegalArgumentException();
        this.grootteBadkamer = grootte;
    }

    // getters
    public double getGrootteBadkamer(){return this.grootteBadkamer;}

    // methodes
    @Override
    public double getTotalePrijs(){
        return super.getTotalePrijs() + (2 * grootteBadkamer);
    }

    public boolean heeftGemeenteBelastingBetaald(){return this.isBelastingBetaald;}

    public void setGemeenteBelastingBetaald(boolean b){
        this.isBelastingBetaald = b;
    }
}
