package domain;

import java.awt.*;
import java.util.List;

public abstract class Schaakstuk {
    private Color kleur;
    private Positie positie;

    // constructor
    public Schaakstuk(Color kleur){
        if(!isValidKleur(kleur)) throw new IllegalArgumentException();
        this.kleur = kleur;
    }

    // getters
    public Color getKleur(){return this.kleur;}

    public Positie getPositie(){return this.positie;}

    // methodes
    public abstract List<Positie> beginPosities();

    public int getBeginLijnnummer(){
        return this.kleur.equals(Color.BLACK) ? 1 : 8;
    }

    public boolean isValidKleur(Color kleur){
        return kleur.equals(Color.BLACK) || kleur.equals(Color.WHITE);
    }

    protected void setBeginPositie(char kolomnummer) {
        this.positie = new Positie(kolomnummer, this.getBeginLijnnummer());
    }

    public String toString(){
        return "Schaakstuk{" + this.getClass().getSimpleName() + " kleur = " + this.kleur + ", positie = " + this.getPositie() + "}";
    }
}
