package domain;

import java.util.regex.Pattern;

public class Werknemer {
    private final String naam, voornaam, rijksregisternr; // verplicht, opvraagbaar, niet wijzigbaar

    // constructor
    public Werknemer(String naam, String voornaam, String rijksregisternr){
        if(naam == null || naam.isEmpty()) throw new IllegalArgumentException();
        if(voornaam == null || voornaam.isEmpty()) throw new IllegalArgumentException();
        if(rijksregisternr == null || rijksregisternr.isEmpty()) throw new IllegalArgumentException();
        if(!geldigeRijksregisternr(rijksregisternr)) throw new IllegalArgumentException();
        this.naam = naam;
        this.voornaam = voornaam;
        this.rijksregisternr = rijksregisternr;
    }

    // hulp
    public boolean geldigeRijksregisternr(String rijksregisternr){
        return Pattern.matches("[0-9]{2}.[0-9]{2}.[0-9]{2}-[0-9]{3}.[0-9]{2}", rijksregisternr);
    }

    // getters
    public String getNaam(){return this.naam;}

    public String getVoornaam(){return this.voornaam;}

    public String getRijksregisternr(){return this.rijksregisternr;}

    // methodes
    public String toString(){
        return this.getClass().getSimpleName() + ": " + this.voornaam + " " + this.naam + " (" + this.rijksregisternr + ") ";
    }
}
