package domain;

public class Adres {
    private String straat, gemeente;
    private int huisNummer, postcode;

    // constructor
    public Adres(String straat, int huisNummer, int postcode, String gemeente){
        if(straat == null || straat.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige straatnaam");
        if(huisNummer <= 0) throw new IllegalArgumentException("Ongeldig huisnummer");
        if(postcode <= 0) throw new IllegalArgumentException("Ongeldige postcode");
        if(gemeente == null || gemeente.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige gemeente");
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    // methodes
    public String toString(){
        String s = this.straat + " " + this.huisNummer + "\n";
        s += this.postcode + " " + this.gemeente;
        return s;
    }
}
