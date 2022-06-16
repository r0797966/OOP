package domain;

public abstract class UurWerknemer extends Werknemer {
    protected int uur;

    // constructor
    public UurWerknemer(String naam, String voornaam, String rijksregisternr){
        super(naam, voornaam, rijksregisternr);
    }

    // methodes
    public void verhoogUur(int aantal){
        if(aantal <= 0) throw new IllegalArgumentException("Ongeldige verhoging");
        this.uur += aantal;
    }

    public void resetUur(){this.uur = 0;}

    @Override
    public String toString(){
        String s = super.toString() + "\n";
        s += "Aantal uur gewerkt (nog niet betaald): " + this.uur;
        return s;
    }
}
