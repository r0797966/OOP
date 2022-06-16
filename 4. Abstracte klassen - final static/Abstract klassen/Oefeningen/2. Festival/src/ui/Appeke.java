package ui;

import domain.Festival;
import domain.Loonwerknemer;
import domain.PrestatieWerknemer;
import domain.Vrijwilliger;

import java.time.LocalDate;

public class Appeke {
    public static void main(String[] args){
        Loonwerknemer a = new Loonwerknemer("Alex", "Brando", "11.11.11-111.11");

        PrestatieWerknemer b = new PrestatieWerknemer("Cedric", "Dirks", "21.11.11-111.11", "Lichten", 100);

        Vrijwilliger c = new Vrijwilliger("Eric" , "Franks", "31.11.11-111.11");

        Festival d = new Festival("Pop", LocalDate.of(2022, 5, 17), LocalDate.of(2022, 5, 23));

        d.voegWerknemerToe(a);
        a.verhoogUur(5);

        d.voegWerknemerToe(b);

        d.voegWerknemerToe(c);
        c.verhoogUur(3);

        //a.resetUur();

        System.out.println(d);
    }
}
