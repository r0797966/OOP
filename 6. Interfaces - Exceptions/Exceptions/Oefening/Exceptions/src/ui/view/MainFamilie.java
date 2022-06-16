package ui.view;

import domain.DomainException;
import domain.Familie;
import domain.Persoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFamilie {
    public static void main(String[] args) throws IOException {
        Persoon anne, bert, chris;

        anne = new Persoon("anne", 10);
        bert = new Persoon("bert", 12);
        chris = new Persoon("chris", 13);

        Familie familie = new Familie("Rodenburg");

		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Geef voornaam voor familielid");
		String naam = reader.readLine();
		System.out.println("Geef leeftijd van familielid");
		String leeftijd = reader.readLine();
		familie.voegFamilielidToe(naam, leeftijd);

		familie.voegFamilielidToe(anne);
		familie.voegFamilielidToe(bert);
		familie.voegFamilielidToe(chris);
		
        System.out.println(familie);

    }
}
