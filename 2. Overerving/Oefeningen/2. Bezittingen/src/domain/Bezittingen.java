package domain;

public class Bezittingen {
    private Euro waarde;

    // constructor
    public Bezittingen(Euro waarde){
        this.setWaarde(waarde);
    }

    // setters
    public void setWaarde(Euro waarde){
        if(waarde == null || waarde.isNegatief()) throw new IllegalArgumentException("Ongeldige waarde");
        this.waarde = waarde;
    }

    // getters
    public Euro getWaarde(){return waarde;}

    // methodes
    public String format(){
        return "waarde: " + this.getWaarde().geefInfoAlsString();
    }
}
