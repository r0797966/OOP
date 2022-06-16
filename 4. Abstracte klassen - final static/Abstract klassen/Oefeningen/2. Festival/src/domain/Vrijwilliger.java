package domain;

public class Vrijwilliger extends UurWerknemer {

    // constructor
    public Vrijwilliger(String naam, String voornaam, String rijksregisternr){
        super(naam, voornaam, rijksregisternr);
    }

    // methodes
    public double berekenVerloning(){
        return 2 * this.uur;
    }
}
