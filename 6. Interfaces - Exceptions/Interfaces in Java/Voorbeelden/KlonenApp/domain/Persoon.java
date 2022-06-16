package domain;
import domain.Date;

public class Persoon implements Cloneable {
    private String naam, voornaam;
    private Date geboortedatum;

    public Persoon(String naam, String voornaam, Date geboortedatum){
        if (Checker.isEmptyString(naam))
            throw new IllegalArgumentException("Geef geldige naam voor persoon");
        if (Checker.isEmptyString(voornaam))
            throw new IllegalArgumentException("Geef geldige voornaam voor persoon");
        if (geboortedatum == null)
            throw new IllegalArgumentException("Geef geldige geboortedatum");
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }
    
    public void setGeboorteDatum(Date datum){
    	this.geboortedatum = datum;
    }

   
    @Override
    public boolean equals(Object ander) {
        if (!(ander instanceof Persoon))
            return false;
        Persoon anderPersoon = (Persoon) ander;
        return this.getNaam().equals(anderPersoon.getNaam())
                && this.getVoornaam().equals(anderPersoon.getVoornaam())
                && this.getGeboortedatum().equals(anderPersoon.getGeboortedatum());
    }

    @Override
    public Persoon clone() throws CloneNotSupportedException {
            return new Persoon(this.getNaam(),this.getVoornaam(),this.getGeboortedatum().clone());
    }
    
    @Override
    public String toString(){
    	return this.getNaam()+" "+this.getVoornaam()+" GeboorteDatum:"+this.geboortedatum;
    }
}
