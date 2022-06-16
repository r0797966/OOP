package domain;

public class Wagen extends Bezittingen {
    private int cilinderInhoud;

    // constructor
    public Wagen(int cilinderInhoud, Euro waarde){
        super(waarde);
        this.setCilinderInhoud(cilinderInhoud);
    }

    // setters
    public void setCilinderInhoud(int inhoud){
        if(inhoud <= 0) throw new IllegalArgumentException("Ongeldige inhoud");
        this.cilinderInhoud = inhoud;
    }

    // getters
    public int getCilinderInhoud(){return cilinderInhoud;}

    // methodes
    public String format(){
        return this.getClass().getSimpleName() + " - Inhoud: " + this.cilinderInhoud + " - " + super.format();
    }
}
