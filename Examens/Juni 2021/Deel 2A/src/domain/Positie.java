package domain;

public class Positie {
    private final char kolomnummer;
    private final int lijnnummer;
    public static final char[] GELDIGE_KOLOM_NUMMERS = "ABCDEFGGH".toCharArray();
    public static final int MINIMUM_LIJNNUMMER = 1;
    public static final int MAXIMUM_LIJNNUMMER = 8;

    // constructor
    public Positie(char kolomnummer, int lijnnummer) {
        char hulp = 0;
        for (char c : GELDIGE_KOLOM_NUMMERS) {
            if (kolomnummer == c) {
                hulp = c;
            }
        }
        if (hulp == 0) throw new DomainException("Ongeldige kolomnummer");
        if (lijnnummer < MINIMUM_LIJNNUMMER || lijnnummer > MAXIMUM_LIJNNUMMER) throw new IllegalArgumentException("Ongeldig lijnnummer!");
        this.kolomnummer = kolomnummer;
        this.lijnnummer = lijnnummer;
    }

    // getters
    public char getKolomnummer(){return this.kolomnummer;}

    public int getLijnnummer(){return this.lijnnummer;}

    // methode
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Positie)) return false;
        Positie positie = (Positie) o;
        return getKolomnummer() == positie.getKolomnummer() && lijnnummer == positie.getLijnnummer();
    }

    @Override
    public String toString(){
        String s = "";
        s += Character.toString(kolomnummer) + lijnnummer;
        return s;
    }
}
