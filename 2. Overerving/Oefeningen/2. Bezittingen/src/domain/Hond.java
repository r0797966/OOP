package domain;

public class Hond extends Bezittingen{
    private String naam;
    private double aantalHondenbrokken;

    // constructor
    public Hond(String naam, double aantalHondenbrokken, Euro waarde){
        super(waarde);
        this.setNaam(naam);
        this.setAantalHondenbrokken(aantalHondenbrokken);
    }

    // setters
    public void setNaam(String naam){
        if(naam == null || naam.isBlank()) throw new IllegalArgumentException("Ongeldige naam");
        this.naam = naam;
    }

    public void setAantalHondenbrokken(double aantalHondenbrokken){
        if(aantalHondenbrokken <= 0) throw new IllegalArgumentException("Ongeldige naam");
        this.aantalHondenbrokken = aantalHondenbrokken;
    }

    // getters
    public String getNaam(){return naam;}

    public double getAantalHondenbrokken(){return aantalHondenbrokken;}

    // methodes
    public String format(){
        return this.getClass().getSimpleName() + " - " + this.getNaam() + " - aantal brokken: " + this.getAantalHondenbrokken() + "g - " + super.format();
    }
}
