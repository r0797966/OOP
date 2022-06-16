package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    private final String naam;
    private final LocalDate startdatum, einddatum;
    ArrayList<Werknemer> werknemers;

    // constructor
    public Festival(String naam, LocalDate startdatum, LocalDate einddatum){
        if(naam == null || naam.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige naam");
        if(einddatum.isBefore(startdatum)) throw new IllegalArgumentException("Einddatum is voor startdatum");
        this.naam = naam;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.werknemers = new ArrayList<>();
    }

    // getters
    public String getNaam(){return naam;}

    public LocalDate getStartdatum(){return startdatum;}

    public LocalDate getEinddatum(){return einddatum;}

    // methodes
    public void voegWerknemerToe(Werknemer w){
        if(w == null) throw new IllegalArgumentException("Ongeldige werkenemer");
        this.werknemers.add(w);
    }

    public int totaalAantalBonnetjes(){
        int totaal = 0;
        for(Werknemer w: this.werknemers){
            if(w instanceof Vrijwilliger){
                totaal += w.berekenVerloning();
            }
        }
        return totaal;
    }

    public double gemiddeldBedragPrestaties(){
        double totaal = 0;
        int aantalWerknemers = 0;
        for(Werknemer w: this.werknemers){
            if(w instanceof PrestatieWerknemer) {
                totaal += w.berekenVerloning();
                aantalWerknemers++;
            }
        }
        return totaal / aantalWerknemers;
    }

    public ArrayList<String> lijstPrestaties(){
        ArrayList<String> res = new ArrayList<>();
        for(Werknemer w: this.werknemers){
            if(w instanceof PrestatieWerknemer) res.add(((PrestatieWerknemer) w).getPrestatie());
        }
        return res;
    }

    public String toString(){
        String s = this.getClass().getSimpleName() + " " + this.naam + "\n";
        s += startdatum + " - " + einddatum + "\n";
        s += "------------------------------------\n";
        for(Werknemer w: this.werknemers){
            s += w.toString() + "\n------------------\n";
        }
        return s;
    }
}
