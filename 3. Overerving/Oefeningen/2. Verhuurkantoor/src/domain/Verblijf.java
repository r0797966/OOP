package domain;

public class Verblijf {
    private int verdiepingsnr, verblijfsnr, oppervlakte;
    private Euro prijsPerVierkanteMeter;
    private boolean isVerhuurd;

    // constructor
    public Verblijf(int verdiepingsnr, int verblijfsnr, Euro prijsPerVierkanteMeter, int oppervlakte){
        if(verdiepingsnr < 0) throw new IllegalArgumentException("Ongeldige verdiepingsnummer");
        if(verblijfsnr < 1) throw new IllegalArgumentException("Ongeldig verblijfsnummer");
        if(oppervlakte < 12) throw new IllegalArgumentException("Ongeldig oppervlakte");
        this.verdiepingsnr = verdiepingsnr;
        this.verblijfsnr = verblijfsnr;
        this.setPrijsPerVierkanteMeter(prijsPerVierkanteMeter);
        this.oppervlakte = oppervlakte;
        this.isVerhuurd = false;
    }

    // setters
    public void setVerhuurstatus(){
        this.isVerhuurd = !this.isVerhuurd;
    }

    public void setPrijsPerVierkanteMeter(Euro prijs){
        if(prijs == null || prijs.isNegatief()) throw new IllegalArgumentException("Ongeldige prijs");
        this.prijsPerVierkanteMeter = prijs;
    }

    // getters
    public int getVerdiepingsnr(){return verdiepingsnr;}

    public int getVerblijfsnr(){return verblijfsnr;}

    public int getOppervlakte(){return oppervlakte;}

    public boolean isVerhuurd(){return isVerhuurd;}

    public Euro getPrijsPerVierkanteMeter(){return prijsPerVierkanteMeter;}

    // methodes
    public Euro getTotalePrijs(){ // nog aan te passen
        return this.prijsPerVierkanteMeter.produkt(this.oppervlakte);
    }

    public String toString(){
        String s = this.getClass().getSimpleName() + "\n";
        s += "Bus " + this.verdiepingsnr + "." + this.verblijfsnr + "\n";
        s += "Prijs " + this.getTotalePrijs() + "euro \n";
        s += "Grootte " + this.oppervlakte + "m² \n";
        s += (this.isVerhuurd ? "" : "niet ") + "verhuurd \n";
        return s;
    }


}
