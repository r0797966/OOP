package domain;

import java.util.ArrayList;

public class Residentie {
    private String naam;
    private Adres adres;
    private int aantalVerdiepingen;
    private ArrayList<Verblijf> verblijfen;

    // constructor
    public Residentie(String naam, Adres adres, int aantalVerdiepingen){
        this.setNaam(naam);
        this.setAdres(adres);
        this.setAantalVerdiepingen(aantalVerdiepingen);
        this.verblijfen = new ArrayList<>();
    }

    // setters
    public void setNaam(String naam){
        if(naam == null || naam.isEmpty()) throw new IllegalArgumentException();
        this.naam = naam;
    }

    public void setAdres(Adres adres){
        if(adres == null) throw new IllegalArgumentException();
        this.adres = adres;
    }

    public void setAantalVerdiepingen(int aantal){
        if(aantal < 0) throw new IllegalArgumentException();
        this.aantalVerdiepingen = aantal;
    }

    // getters
    public String getNaam(){return this.naam;}

    public Adres getAdres(){return this.adres;}

    public int getAantalVerdiepingen(){return this.aantalVerdiepingen;}

    // methodes
    public void voegVerblijfToe(Verblijf verblijf){
        if(verblijf == null) throw new IllegalArgumentException();
        if(verblijf.getVerdiepingsnr() >= this.aantalVerdiepingen) throw new IllegalArgumentException();
        this.verblijfen.add(verblijf);
    }

    public int aantalVrijeVerblijf(){
        int aantal = 0;

        for(Verblijf v: this.verblijfen){
            if(!v.isVerhuurd()) aantal++;
        }
        return aantal;
    }

    public int aantalNogTeBetalenGemeentebelasting(){
        int aantal = 0;

        for(Verblijf v: this.verblijfen){
            if(v instanceof StudentenVerblijf) {
                StudentenVerblijf s = (StudentenVerblijf) v;
                if(s.isGemeenteBelastingBetaald()) aantal++;
            }
        }
        return aantal;
    }

    public double totalePrijs(){
        int totaal = 0;

        for(Verblijf v: this.verblijfen){
            totaal += v.getTotalePrijs();
        }
        return totaal;
    }

    public String toString(){
        String s = "Residentie " + this.getNaam() + "\n";
        s += this.adres.toString() + "\n";
        s += "Nog vrij: " + this.aantalVrijeVerblijf() + " verblijven \n";
        s += "-----------------------------------------\n";

        for(Verblijf v: this.verblijfen){
            s += v.toString() + "\n";
            s += "---------------\n";
        }

        return s;
    }
}
