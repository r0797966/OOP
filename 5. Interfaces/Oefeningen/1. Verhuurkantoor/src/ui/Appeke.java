package ui;

import domain.*;

public class Appeke {
    public static void main(String[] args){
        Adres adres = new Adres("Maanstraat", 785, 3001, "Heverlee");

        Appartement a = new Appartement(1, 1, new Euro(25, 0), 20, 1);
        Appartement b = new Appartement(1, 2, new Euro(25, 0), 20, 4);

        Studentenkamer c = new Studentenkamer(1, 3, new Euro(20, 0), 15);

        Studio d = new Studio(1, 4, new Euro(18, 0), 20, 10);

        Residentie e = new Residentie("Pegasus", adres, 2);

        e.voegVerblijfToe(a);
        e.voegVerblijfToe(b);
        e.voegVerblijfToe(c);
        e.voegVerblijfToe(d);

        System.out.println(e);
        System.out.println(e.verblijvenNietBetaaldeBelastingen());
        d.setGemeenteBelastingenBetaald(true);
        System.out.println(e.verblijvenNietBetaaldeBelastingen());
    }
}
