package domain;

import java.util.ArrayList;

public class Residentie {
    private String naam;
    private Adres adres;
    private int aantalVerdiepingen;
    ArrayList<Verblijf> verblijven;

    // constructor
    public Residentie(String naam, Adres adres, int aantalVerdiepingen){
        if(naam == null || naam.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige naam");
        if(adres == null) throw new IllegalArgumentException("Ongeldig adres");
        if(aantalVerdiepingen < 0) throw new IllegalArgumentException("Ongledig aantal verdiepingen");
        this.naam = naam;
        this.adres = adres;
        this.aantalVerdiepingen = aantalVerdiepingen;
        this.verblijven = new ArrayList<>();
    }

    // getters
    public String getNaam(){return naam;}

    public Adres getAdres(){return adres;}

    public int getAantalVerdiepingen(){return aantalVerdiepingen;}

    // methodes
    public void voegVerblijfToe(Verblijf verblijf){
        if(verblijf == null) throw new IllegalArgumentException("Ongeldig verblijf");
        if(verblijf.getVerdiepingsnr() >= this.aantalVerdiepingen) throw new IllegalArgumentException("Niet genoeg verdiepingen voor verblijf");
        this.verblijven.add(verblijf);
    }

    public int aantalVrijeVerblijven(){
        int aantal = 0;
        for(Verblijf v: this.verblijven){
            if(!v.isVerhuurd()) aantal++;
        }
        return aantal;
    }

    public ArrayList<Verblijf> verblijvenNietBetaaldeBelastingen(){
        ArrayList<Verblijf> verblijven = new ArrayList<>();
        for(Verblijf v: this.verblijven) {
            if(v instanceof Studentenverblijf) {
                Studentenverblijf s = (Studentenverblijf)v;
                if(!s.isBelastingBetaald()) verblijven.add(s);
            }
        }
        return verblijven;
    }

    public Euro getTotalePrijs(){
        Euro totaal = new Euro(0, 0);
        for(Verblijf v: this.verblijven){
            totaal = totaal.som(v.getTotalePrijs());
        }
        return totaal;
    }

    public String toString(){
        String s = this.getClass().getSimpleName() + " " + this.naam + "\n";
        s += this.adres + "\n";
        s += "Nog vrij: " + this.aantalVrijeVerblijven() + " verblijven \n";
        s += "------------------------------------------------------------ \n";
        // EXTRA
        for(Verblijf v: this.verblijven){
            s += v.toString() + "\n";
        }
        return s;
    }
}
