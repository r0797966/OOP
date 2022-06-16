package domain;

public class Persoon {
    private String naam;
    private int leeftijd;

    public Persoon(String naam, int leeftijd) {
        if (naam == null || naam.trim().isEmpty())
            throw new DomainException("Geen effectieve naam");
        this.naam = naam;
        if (leeftijd < 10)
            throw new DomainException("Geen geldige leeftijd");
        this.leeftijd = leeftijd;
    }
    
    @Override
    public String toString() {
        return this.naam;
    }

}
