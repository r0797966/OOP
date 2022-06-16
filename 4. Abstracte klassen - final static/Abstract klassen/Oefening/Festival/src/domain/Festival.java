package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    private String naam;
    private LocalDate startdatum, einddatum;
    private ArrayList<Werknemer> werknemers;

    // constructor
    public Festival(String naam, LocalDate startdatum, LocalDate einddatum){
        this.setNaam(naam);
        this.setStartdatum(startdatum);
        this.setEinddatum(einddatum);
        this.werknemers = new ArrayList<>();
    }

    // setters
    public void setNaam(String naam){
        if(naam == null || naam.isEmpty()) throw new IllegalArgumentException();
        this.naam = naam;
    }

    public void setStartdatum(LocalDate startdatum){
        this.startdatum = startdatum;
    }

    public void setEinddatum(LocalDate einddatum){
        if(einddatum.isBefore(this.startdatum)) throw new IllegalArgumentException();
        this.einddatum = einddatum;
    }

    // getters
    public String getNaam(){return this.naam;}

    public LocalDate getStartdatum(){return this.startdatum;}

    public LocalDate getEinddatum(){return this.einddatum;}

    public ArrayList<Werknemer> getWerknemers(){return this.werknemers;}

    // methodes
    public void werknemerToevoegen(Werknemer w){
        if(w == null) throw new IllegalArgumentException();
        this.werknemers.add(w);
    }

    public int aantalBonnetjes(){
        int aantal = 0;

        for(Werknemer w: this.werknemers){
            if(w instanceof Vrijwilliger v){
                aantal += v.getTotaleVerloning();
            }
        }

        return aantal;
    }

    public int gemiddeldBedrag(){
        int totaal = 0;
        int aantal = 0;

        for(Werknemer w: this.werknemers){
            if(w instanceof Prestatiewerknemer p) {
                totaal += p.getBedrag();
                aantal ++;
            }
        }
        return totaal / aantal;
    }

    public ArrayList<String> lijstPrestaties(){
        ArrayList<String> prestaties = new ArrayList<>();

        for(Werknemer w: this.werknemers){
            if(w instanceof Prestatiewerknemer p) prestaties.add(p.getPrestatie());
        }
        return prestaties;
    }

    public String toString(){
        String s = "Festival " + this.getNaam() + "\n";
        s += this.startdatum + " - " + this.einddatum + "\n";
        s += "-------------------------------------\n";
        for(Werknemer w: this.werknemers){
            s += w.toString() + "\n";
            s += "----------\n";
        }

        return s;
    }
}
