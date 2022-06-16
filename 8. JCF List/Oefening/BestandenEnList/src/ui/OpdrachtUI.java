package ui;

import javax.swing.JOptionPane;

import domain.Opdracht;

public class OpdrachtUI {

	public static void main(String[] args) {
		// We maken 1 opdracht
		int id = 1;
		String auteur = "Leentje";
		String categorie = Opdracht.CATEGORIE_AARDRIJKSKUNDE;
		String vraag = "Wat is de hoofdstad van Belgie?";
		String antwoordhint = "Je vindt er het atomium";
		String antwoord = "Brussel";
		boolean isHoofdlettergevoelig = true;
		Opdracht opdracht1 = new Opdracht(id, vraag, antwoord,
				isHoofdlettergevoelig, antwoordhint, categorie, auteur);
		System.out.println(opdracht1);

		// TODO gebruik de OpdrachtDatabase klasse  om opdrachten van een txt
		// bestand te lezenen en hier een Quiz van te maken
		
		
		// TODO schrijf de main methode verder uit zodat volgende gebeurt
		// Kies een willekeurige opdracht en toon de vraag aan de gebruiker in de console, 
		// waarbij hij een antwoord kan geven in de console dat gecontroleerd wordt met het juiste antwoord.
		// bij foutieve antwoord van de gebruiker kan de hint gegeven worden
		// zie forum --> discussielijn met de naam "JOptionPane" van Greetje Jongen voor inlezen console

	}

}
