package domain;

public class Prestatiewerknemer extends Werknemer {
    private String prestatie;
    private int bedrag;

    // constructor
    public Prestatiewerknemer(String naam, String voornaam, String rijksregisternr, String prestatie, int bedrag){
        super(naam, voornaam, rijksregisternr);
        if(prestatie == null || prestatie.isEmpty()) throw new IllegalArgumentException();
        if(bedrag < 20) throw new IllegalArgumentException();
        this.prestatie = prestatie;
        this.bedrag = bedrag;
    }

    // getters
    public String getPrestatie(){return this.prestatie;}

    public int getBedrag(){return this.bedrag;}

    // methodes
    @Override
    public String toString(){
        String s = super.toString() + "\n";
        s += "Verloning: " + this.bedrag + "\n";
        return s;
    }
}
