package domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pion extends Schaakstuk implements HeeftWaarde{
    public static final int WAARDE = 1;

    public Pion(Color kleur, char kolom){
        super(kleur);
        this.setBeginPositie(kolom);
    }

    @Override
    public List<Positie> beginPosities(){
        List<Positie> mogelijkBeginPositiesPion = new ArrayList<>();
        char[] GELDIGE_KOLOM_NUMMERS = "ABCDEFGH".toCharArray();

        for(int i = 0; i < 8; i++){
            mogelijkBeginPositiesPion.add(new Positie(GELDIGE_KOLOM_NUMMERS[i], this.getBeginLijnnummer()));
        }

        return mogelijkBeginPositiesPion;
    }

    @Override
    public int getBeginLijnnummer(){
        return this.getKleur().equals(Color.BLACK) ? 2 : 7;
    }

    public int getWaarde(){
        return this.WAARDE;
    }

    @Override
    public String toString(){
        return "Pion " + getPositie().toString();
    }


}
