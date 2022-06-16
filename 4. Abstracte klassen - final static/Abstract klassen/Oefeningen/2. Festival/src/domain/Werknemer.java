package domain;

public abstract class Werknemer {
    private final String naam, voornaam, rijksregisternr;

    // constructor
    public Werknemer(String naam, String voornaam, String rijksregisternr){
        if(naam == null || naam.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige naam");
        if(voornaam == null || voornaam.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige voornaam");
        if(rijksregisternr == null || rijksregisternr.trim().isEmpty()) throw new IllegalArgumentException("Leeg rijksregisternummer");
        if(!rijksregisternr.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}-[0-9]{3}\\.[0-9]{2}")) throw new IllegalArgumentException("Ongeldig rijksregisternummer");
        this.naam = naam;
        this.voornaam = voornaam;
        this.rijksregisternr = rijksregisternr;
    }

    // getters
    public String getNaam(){return naam;}

    public String getVoornaam(){return voornaam;}

    public String getRijksregisternr(){return rijksregisternr;}

    // methodes
    public abstract double berekenVerloning();

    public String toString(){
        String s = this.getClass().getSimpleName() + " " + this.naam + " (" + this.rijksregisternr + ") \n";
        s += "Verloning: " + this.berekenVerloning();
        return s;
    }
}
