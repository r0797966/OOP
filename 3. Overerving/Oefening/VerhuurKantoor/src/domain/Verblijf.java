package domain;

import java.util.ArrayList;

public class Verblijf {
    private int verdiepingsnr, verblijfsnr;
    private double prijsPerVierkanteMeter, oppervlakte;
    private boolean isVerhuurd;

    // constructor
    public Verblijf(int verdiepingsnr, int verblijfsnr, double prijsPerVierkanteMeter, double oppervlakte){
        this.setVerdiepingsnr(verdiepingsnr);
        this.setVerblijfsnr(verblijfsnr);
        this.setPrijsPerVierkanteMeter(prijsPerVierkanteMeter);
        this.setVerhuurd(false);
        this.setOppervlakte(oppervlakte);
    }

    // setters
    public void setVerdiepingsnr(int verdiepingsnr){
        if(verdiepingsnr < 0) throw new IllegalArgumentException();
        this.verdiepingsnr = verdiepingsnr;
    }

    public void setVerblijfsnr(int verblijfsnr){
        if(verblijfsnr <= 0) throw new IllegalArgumentException();
        this.verblijfsnr = verdiepingsnr;
    }

    public void setPrijsPerVierkanteMeter(double prijs){
        if(prijs < 0) throw new IllegalArgumentException();
        this.prijsPerVierkanteMeter = prijs;
    }

    public void setOppervlakte(double oppervlakte){
        if(oppervlakte < 12) throw new IllegalArgumentException();
        this.oppervlakte = oppervlakte;
    }

    public void setVerhuurd(boolean b){this.isVerhuurd = b;}

    // getters
    public int getVerdiepingsnr(){return this.verdiepingsnr;}

    public int getVerblijfsnr(){return this.verblijfsnr;}

    public double getPrijsPerVierkanteMeter(){return this.prijsPerVierkanteMeter;}

    public double getOppervlakte(){return this.oppervlakte;}

    public boolean isVerhuurd(){return this.isVerhuurd;}

    //methodes
    public double getTotalePrijs(){
        return prijsPerVierkanteMeter * oppervlakte;
    }

    public String toString(){
        String s = this.getClass().getSimpleName() + "\n";
        s += "Bus " + this.getVerdiepingsnr() + "." + this.verblijfsnr + "\n";
        s += "Prijs: " + this.getTotalePrijs() + "euro \n";
        s += "Grootte: " + this.getOppervlakte() + "m² \n";
        s += (this.isVerhuurd ? "" : "niet ") + "verhuurd";
        return s;
    }
}
