package domain;

public class Loonwerknemer extends Uurwerknemer {

    // constructor
    public Loonwerknemer(String naam, String voornaam, String rijksregisternr){
        super(naam, voornaam, rijksregisternr);
    }

    // methodes
    public int getTotaleVerloning(){
        return 10 * super.getAantalUur();
    }
}
