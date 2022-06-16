package domain;

import java.util.ArrayList;
import java.util.List;

public class Familie {
    private final String naam;
    private List<Persoon> personen;
    private static final int maxAantal = 3;

    public Familie(String naam) {
        if (naam == null || naam.trim().isEmpty())
            throw new DomainException("Geef een effectieve naam voor de familie");
        this.naam = naam;
        personen = new ArrayList<>();
    }

    public void voegFamilielidToe(String naam, String leeftijd) {
            Persoon persoon = new Persoon(naam, Integer.parseInt(leeftijd));
            this.voegFamilielidToe(persoon);
    }

    public void voegFamilielidToe(Persoon persoon) {
        if (persoon == null)
            throw new DomainException("Alleen effectieve personen kunnen toegevoegd worden");
        if (familieBevatReedsPersoon(persoon))
            throw new IllegalStateException("Deze familie bevat reeds deze persoon");
        if (personen.size() == maxAantal)
            throw new IllegalStateException("Deze familie bevat reeds het maximaal aantal personen");
        personen.add(persoon);

    }

    private boolean familieBevatReedsPersoon(Persoon persoon) {
        return personen.contains(persoon);
    }

    @Override
    public String toString() {
        String result = "Familie " + this.naam;
        result += " bestaat uit " + personen.size() + " personen:";
        for (Persoon persoon : personen) {
            result += "\n" + persoon;
        }
        return result;
    }



}
