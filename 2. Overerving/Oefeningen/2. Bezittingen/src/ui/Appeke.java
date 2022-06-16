package ui;

import domain.*;

public class Appeke {
    public static void main(String[] args){
        Hond a = new Hond("Ace", 22.5, new Euro(330, 30));
        Schilderij b = new Schilderij("The Kiss", "Klimt", new Euro(400, 99));

        Persoon p = new Persoon();

        p.voegBezittingToe(a);
        p.voegBezittingToe(b);

        //System.out.println(p.format());

        // UITBREIDING
        Wagen c = new Wagen(300, new Euro(100, 99));
        Wagen d = new Wagen(500, new Euro(300, 0));

        p.voegBezittingToe(c);
        p.voegBezittingToe(d);

        System.out.println(p.format());
        System.out.println(p.bevatSchilder("Klimt"));
        System.out.println(p.bevatSchilder("Da Vinci"));
    }
}
