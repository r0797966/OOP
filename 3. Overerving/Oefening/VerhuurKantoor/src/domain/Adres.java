package domain;

public class Adres {
    private String straat, gemeente;
    private int nummer, postcode;

    // constructor
    public Adres(String straat, int nummer, String gemeente, int postcode){
        if(straat == null || straat.isEmpty()) throw new IllegalArgumentException();
        if(nummer <= 0) throw new IllegalArgumentException();
        if(gemeente == null || gemeente.isEmpty()) throw new IllegalArgumentException();
        if(postcode <= 0) throw new IllegalArgumentException();
        this.straat = straat;
        this.nummer = nummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
    }

    //methodes
    public String toString(){
        String s = this.straat + " " + this.nummer + "\n";
        s += this.postcode + " " + this.gemeente;
        return s;
    }
}
