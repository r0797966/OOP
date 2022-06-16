package domain;

public abstract class Uurwerknemer extends  Werknemer{
    private int aantalUur;

    // constructor
    public Uurwerknemer(String naam, String voornaam, String rijksregisternr){
        super(naam, voornaam, rijksregisternr);
        this.aantalUur = 0;
    }

    // getter
    public int getAantalUur(){return this.aantalUur;}

    // setter
    public void setAantalUur(int aantal){
        if(aantal < 0) throw new IllegalArgumentException();
        this.aantalUur = aantal;
    }

    // methodes
    public void verhoogAantalUur(int aantal){
        if(aantal < 0) throw new IllegalArgumentException();
        this.aantalUur += aantal;
    }

    public void resetAantalUur(){
        this.aantalUur = 0;
    }

    public abstract int getTotaleVerloning();

    @Override
    public String toString(){
        String s = super.toString() + "\n";
        s += "Verloning: " + this.getTotaleVerloning() + "\n";
        s += "Aantal uur gewerkt (nog niet betaald): " + this.getAantalUur();
        return s;
    }
}
