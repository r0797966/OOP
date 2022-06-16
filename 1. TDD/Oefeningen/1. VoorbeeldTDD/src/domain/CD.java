package domain;

import java.util.ArrayList;
import java.util.List;

public class CD {
    private String naam;
    private double kortingsPercentage;
    private ArrayList<Liedje> liedjes;

    // constructor
    public CD(String naam){
        this.setNaam(naam);
        this.setKortingsPercentage(0);
        this.liedjes = new ArrayList<>();
    }

    public CD(String naam, double kortingsPercentage){
        this.setNaam(naam);
        this.setKortingsPercentage(kortingsPercentage);
        this.liedjes = new ArrayList<>();
    }

    public CD(String naam, double kortingsPercentage, Liedje lied){
        this.setNaam(naam);
        this.setKortingsPercentage(kortingsPercentage);
        this.liedjes = new ArrayList<>();
        if(lied == null) throw new IllegalArgumentException("Ongeldige lied");
        this.liedjes.add(lied);
    }

    // setters
    public void setNaam(String naam){ // niet leeg, minstens 6 tekens
        if(naam == null || naam.length() <= 5) throw new IllegalArgumentException("Ongeldige naam");
        this.naam = naam;
    }

    public void setKortingsPercentage(double kortingsPercentage){
        if(kortingsPercentage < 0 || kortingsPercentage >= 1) throw new IllegalArgumentException("Ongeldig percentage");
        this.kortingsPercentage = kortingsPercentage;
    }

    // getters
    public String getNaam(){return naam;}

    public double getKortingsPercentage(){return kortingsPercentage;}

    public Liedje getLied(int i){return this.liedjes.get(i - 1);}

    // methodes
    public Euro getTotalePrijs(){
        Euro totaal = new Euro(0, 0);
        for(Liedje l: this.liedjes){
            totaal = totaal.som(l.getPrijs());
        }
        double korting = kortingsPercentage * 100;
        totaal.produkt((int)korting);
        return totaal.verschil(totaal.produkt((int)kortingsPercentage*100).deling(100));
    }

    public void voegLiedjeToe(Liedje liedje){
        if(liedje == null) throw new IllegalArgumentException("Ongeldige liedje");
        if(this.liedjes.size() == 0) this.liedjes.add(liedje);
        boolean a = false;
        for(Liedje l: this.liedjes){
            for(int i = 1; i <= 3 && !a; i++){
                String s = liedje.getStijl(i);
                if(s!= null && l.bevatStijl(s)) a = true;
            }
            if (!a) throw new IllegalArgumentException("Past niet in lijst");
        }
        this.liedjes.add(liedje);
    }
}
