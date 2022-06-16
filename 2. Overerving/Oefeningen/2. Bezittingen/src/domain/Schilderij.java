package domain;

public class Schilderij extends Bezittingen {
    private String titel, artist;

    // constructor
    public Schilderij(String titel, String artist, Euro waarde){
        super(waarde);
        this.setTitel(titel);
        this.setArtist(artist);
    }

    // setters
    public void setTitel(String titel){
        if(titel == null || titel.isBlank()) throw new IllegalArgumentException("Ongeldige titel");
        this.titel = titel;
    }

    public void setArtist(String artist){
        if(artist == null || artist.isBlank()) throw new IllegalArgumentException("Ongeldige artist");
        this.artist = artist;
    }

    // getters
    public String getTitel(){return titel;}

    public String getArtist(){return artist;}

    // methodes
    public String format(){
        return this.getClass().getSimpleName() + " - " + "Titel: " + this.getTitel() + " - Artist: " + this.getArtist() + " - " + super.format();
    }
}
