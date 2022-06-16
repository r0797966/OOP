package ui;

import domain.*;

public class Appeke {
    public static void main(String[] args){
        Verblijf a = new Appartement(1, 1, 20, 15, 1);

        Verblijf b = new Studentenkamer(1, 2, 20, 15);

        Verblijf c = new Studio(1, 3, 20, 15, 10);

        Adres adres = new Adres("straat", 2, "gemeente", 3080);
        Residentie r = new Residentie("test", adres, 2);

        c.setVerhuurd(true);

        r.voegVerblijfToe(a);
        r.voegVerblijfToe(b);
        r.voegVerblijfToe(c);

        System.out.println(r);
    }
}
