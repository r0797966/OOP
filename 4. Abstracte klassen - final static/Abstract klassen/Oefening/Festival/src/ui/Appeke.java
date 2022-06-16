package ui;

import domain.*;

import java.time.LocalDate;

public class Appeke {
    public static void main(String[] args){
        Festival a = new Festival("Pop", LocalDate.of(2022, 7, 10), LocalDate.of(2022, 7, 12));

        Uurwerknemer b = new Loonwerknemer("Alex", "Brams", "11.11.11-111.11");

        Werknemer c = new Prestatiewerknemer("Cedric", "Doorns", "22.22.22-222.22", "Verlichting", 200);

        Werknemer d = new Vrijwilliger("Eric", "Franks", "33.33.33-333.33");

        a.werknemerToevoegen(b);
        a.werknemerToevoegen(c);
        a.werknemerToevoegen(d);

        b.verhoogAantalUur(10);

        System.out.println(a);
    }
}
