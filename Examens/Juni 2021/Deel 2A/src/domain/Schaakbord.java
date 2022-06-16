package domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Schaakbord {
    private List<Schaakstuk> schaakstukken;

    public Schaakbord(){
        schaakstukken = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            schaakstukken.add(new Pion(Color.BLACK, Positie.GELDIGE_KOLOM_NUMMERS[i]));
            schaakstukken.add(new Pion(Color.WHITE, Positie.GELDIGE_KOLOM_NUMMERS[i]));
        }
    }

    public List<HeeftWaarde> getSchaakstukkenInVolgordeVanWaarde(){
        List<HeeftWaarde> schaakstukkenGesorteerd = new ArrayList<>();

        for(Schaakstuk s: this.schaakstukken){
            if(s instanceof HeeftWaarde) schaakstukkenGesorteerd.add((HeeftWaarde) s);
        }

        schaakstukkenGesorteerd.sort(new ComparatorByWaarde());
        return schaakstukkenGesorteerd;
    }

    public int getTotaleWaarde(Color c){
        int waarde = 0;

        for (Schaakstuk s: this.schaakstukken){
            if(s.getKleur().equals(c) && s instanceof HeeftWaarde) waarde += ((HeeftWaarde) s).getWaarde();
        }

        return waarde;
    }

    public List<Schaakstuk> verwijderLijn(int lijn){
        List<Schaakstuk> verwijderd = new ArrayList<>();
        Iterator<Schaakstuk> iterator = schaakstukken.iterator();

        while(iterator.hasNext()){
            Schaakstuk s = iterator.next();
            if(s.getPositie().getLijnnummer() == lijn){
                verwijderd.add(s);
                iterator.remove();
            }
        }

        return verwijderd;
    }

    public String toString(){
        return "Schaakstukken: " + schaakstukken;
    }
}
