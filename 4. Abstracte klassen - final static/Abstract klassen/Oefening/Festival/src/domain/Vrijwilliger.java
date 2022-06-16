package domain;

public class Vrijwilliger extends Uurwerknemer{

    // constructor
    public Vrijwilliger(String naam, String voornaam, String rijksregsiternr){
        super(naam, voornaam, rijksregsiternr);
    }

    // methodes
    public int getTotaleVerloning(){
        return 2 * super.getAantalUur();
    }
}
