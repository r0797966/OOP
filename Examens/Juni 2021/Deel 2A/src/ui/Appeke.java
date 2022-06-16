package ui;

import domain.*;
import java.awt.*;

public class Appeke {
    public static void main(String[] args) {

        Schaakbord s = new Schaakbord();

        System.out.println("Verwijderde schaakstukken: " + s.verwijderLijn(2));

        System.out.println(s);

        System.out.println(s.getTotaleWaarde(Color.WHITE));

    }

}
