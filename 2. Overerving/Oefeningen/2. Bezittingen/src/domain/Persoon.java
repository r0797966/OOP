package domain;

import java.util.ArrayList;

public class Persoon {
    private ArrayList<Bezittingen> bezittingen;

    // constructor
    public Persoon(){
        this.bezittingen = new ArrayList<>();
    }

    // methodes
    public void voegBezittingToe(Bezittingen bezitting){
        if(bezitting == null) throw new IllegalArgumentException("Ongeldige bezitting");
        this.bezittingen.add(bezitting);
    }

    public Euro totaleWaarde(){
        Euro totaal = new Euro(0, 0);
        for(Bezittingen b: this.bezittingen){
           totaal = totaal.som(b.getWaarde());
        }
        return totaal;
    }

    public double totaleHondenbrokkenVoorDagen(int dagen){
        double totaal = 0;
        for(Bezittingen b: this.bezittingen){
            if(b instanceof Hond){
                Hond h = (Hond)b;
                totaal += h.getAantalHondenbrokken();
            }
        }
        return totaal;
    }

    public String format(){
        String s = "Bezittingen: \n";
        for(Bezittingen b: this.bezittingen){
            s += b.format() + "\n";
        }
        s += "Totaal: " + this.totaleWaarde().geefInfoAlsString() + "\n";
        // UITBREIDING
        s += "Grootste inhoud: " + this.grootsteInhoud().format() + "\n";
        return s;

    }

    // UITBREIDING
    public boolean bevatSchilder(String schilder){
        if(schilder == null || schilder.isBlank()) throw new IllegalArgumentException("Ongeldige schilder");
        for(Bezittingen b: this.bezittingen){
            if(b instanceof Schilderij){
                Schilderij s = (Schilderij)b;
                if(s.getArtist().equalsIgnoreCase(schilder)) return true;
            }
        }
        return false;
    }

    public Wagen grootsteInhoud(){
        Wagen w = null;
        for(Bezittingen b: this.bezittingen){
            if(b instanceof Wagen a){
                if(w == null) w = a;
                if(w.getCilinderInhoud() < a.getCilinderInhoud()) w = a;
            }
        }
        return w;
    }

}
