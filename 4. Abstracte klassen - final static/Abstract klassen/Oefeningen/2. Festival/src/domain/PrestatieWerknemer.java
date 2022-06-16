package domain;

public class PrestatieWerknemer extends Werknemer {
    private String prestatie;
    private double bedrag;

    // constructor
    public PrestatieWerknemer(String naam, String voornaam, String rijksregisternr, String prestatie, double bedrag){
        super(naam, voornaam, rijksregisternr);
        if(prestatie == null || prestatie.trim().isEmpty()) throw new IllegalArgumentException("Ongeldige prestatie");
        if(bedrag < 20) throw new IllegalArgumentException("Ongeldig bedrag");
        this.prestatie = prestatie;
        this.bedrag = bedrag;
    }

    // getters
    public String getPrestatie(){return prestatie;}

    public double getBedrag(){return bedrag;}

    // methodes
    @Override
    public double berekenVerloning(){
        return bedrag;
    }

    public String toString(){
        String s = super.toString() + "\n";
        s += "Prestatie: " + this.prestatie;
        return s;
    }
}
