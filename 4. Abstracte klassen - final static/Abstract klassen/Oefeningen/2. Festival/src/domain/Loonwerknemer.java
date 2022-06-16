package domain;

public class Loonwerknemer extends UurWerknemer {

    // constructor
    public Loonwerknemer(String naam, String voornaam, String rijksregisternr){
        super(naam, voornaam, rijksregisternr);
    }

    // methodes
    @Override
    public double berekenVerloning(){
        return this.uur * 10;
    }
}
