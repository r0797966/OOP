package domain;

import db.OpdrachtDatabank;

import java.util.*;

public class Quiz {
	
	// TODO Vervang door een een gepaste collectie en initialiseer ze
	private List<Opdracht> opdrachten;
		
	public Quiz(){
		// TODO
		this.opdrachten = new ArrayList<>();
		opdrachten = OpdrachtDatabank.getOpdrachten();
	}
	
	// hoeveel opdracht objecten zitten er in de opdrachtenCollectie
	public int getAantalOpdrachten(){
		// TODO
		return this.opdrachten.size();
	}
		
	public boolean isLeeg(){
		// TODO
		return opdrachten.isEmpty();
	}
		
		
	//voegt een nieuwe opdracht toe achteraan de opdrachtenCollectie
	// let op opdracht mag niet al voorkomen volgens equals
	
	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		// TODO
		if(opdrachtNieuw == null) return false;
		if(this.opdrachten.contains(opdrachtNieuw)) return false;
		this.opdrachten.add(opdrachtNieuw);
		return true;
	}
	
		
	// TODO verwijder de eventuele opdracht op met opdrachtId in de opdrachtenCollectie
	//geeft de verwijderde opdracht terug TIP: gebruik iterator
	public Opdracht verwijderOpdracht(int opdrachtId) {
		Iterator<Opdracht> iterator = this.opdrachten.iterator();
		boolean gevonden = false;
		Opdracht opdracht = null;
		while(iterator.hasNext() && !gevonden){
			opdracht = iterator.next();
			if(opdracht.getOpdrachtID() == opdrachtId){
				iterator.remove();
				gevonden = true;
			}
		}
		return opdracht;
	}

	//TODO geeft willekeurige opdracht terug	
	public Opdracht getRandomOpdracht(){
 		if(this.opdrachten.isEmpty()) return null;
		 int i = (int)(Math.random() * this.opdrachten.size());
		 return this.opdrachten.get(i);
	}
		
	// TODO elke opdracht uit de opdrachtenCollectie(volgens toString van Opdracht klasse), elke
	//opdracht op een nieuwe lijn
	public String toString(){
		String uit = "";
		for (Opdracht o: this.opdrachten){
			uit += o + "\n";
		}
		return uit;
	}
}
