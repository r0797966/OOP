package domain;

import java.util.ArrayList;

public class Liedje {
    private String naam, muzikant;
    private Euro prijs;
    private String[] stijlen;

    // constructor
    public Liedje(String naam, String muzikant, String stijl, Euro prijs){
        this.setNaam(naam);
        this.setMuzikant(muzikant);
        if(stijl == null || stijl.isBlank()) throw new IllegalArgumentException("Ongeldige stijl");
        this.stijlen = new String[3];
        this.stijlen[0] = stijl;
        this.setPrijs(prijs);
    }

    //setters
    public void setNaam(String naam){ // niet leeg
        if(naam == null || naam.isBlank()) throw new IllegalArgumentException("Ongeldige naam");
        this.naam = naam;
    }

    public void setMuzikant(String muzikant){this.muzikant = muzikant;}

    public void setPrijs(Euro prijs){ // niet leeg, prijs >= 0
        if(prijs == null || prijs.isNegatief()) throw new IllegalArgumentException("Ongeldige prijs");
        this.prijs = prijs;
    }

    // getters
    public String getNaam(){return naam;}

    public String getMuzikant(){return muzikant;}

    public Euro getPrijs(){return prijs;}

    public String getStijl(int i){return this.stijlen[i - 1];}

    // methodes
    public boolean bevatStijl(String gegevenStijl){
        if(gegevenStijl == null || gegevenStijl.isBlank()) return false;
        for(String s: this.stijlen){
            if(s!= null && s.equalsIgnoreCase(gegevenStijl)) return true;
        }
        return false;
    }

    public void voegStijlToe(String nieuweStijl){
        if(nieuweStijl == null || nieuweStijl.isBlank()) throw new IllegalArgumentException("Ongeldige stijl");
        if (this.bevatStijl(nieuweStijl)) throw new IllegalArgumentException("Stijl al in lijst");
        boolean a = false;
        for(int i = 1; i < this.stijlen.length && !a; i++){
            if(this.stijlen[i] == null) {
                a = true;
                this.stijlen[i] = nieuweStijl;
            }
        }
        if(!a) throw new IllegalStateException();
    }

}
