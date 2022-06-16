package domain;

public class Studio extends StudentenVerblijf{
    private double grootteBadkamer;

    // constructor
    public Studio(int verdiepingsnr, int verblijfsnr, double prijsPerVierkanteMeter, double oppervlakte, double grootteBadkamer){
        super(verdiepingsnr, verblijfsnr, prijsPerVierkanteMeter, oppervlakte);
        this.setGrootteBadkamer(grootteBadkamer);
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
}
