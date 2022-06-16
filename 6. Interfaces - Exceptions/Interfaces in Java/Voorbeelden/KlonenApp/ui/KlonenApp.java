package ui;

import java.time.LocalDate;

import domain.Date;
import domain.Persoon;

public class KlonenApp {

	public static void main(String[] args) {
		Persoon p1 = new Persoon("Jansen","Piet",new Date(4,11,1960));
		Persoon p2 = p1;
		System.out.println("p1 = p2");
		System.out.println("p1-> "+p1);
		System.out.println("p2-> "+p2);
		System.out.println();
		
		p1.setGeboorteDatum(new Date(11,11,1980));
		System.out.println("p1 = p2 en datum p1 gewijzigd");
		System.out.println("p1-> "+p1);
		System.out.println("p2-> "+p2);
		System.out.println();
		
		Persoon p3;
		try {
			p3 = p1.clone();
			System.out.println("p3 is clone van p1");
			System.out.println("p1-> "+p1);
			System.out.println("p3-> "+p3);
			System.out.println();
			
			p1.setGeboorteDatum(new Date(11,11,2000));
			System.out.println("p3 is clone van p1 en datum p1 gewijzigd");
			System.out.println("p1-> "+p1);
			System.out.println("p3-> "+p3);		
			System.out.println();
			
			p3 = p1.clone();
			Date d1 = p1.getGeboortedatum();
			d1.setYear(2010);
			System.out.println("p3 is clone van p1 en het jaartal van de datum van p1 is gewijzigd");
			System.out.println("p1-> "+p1);
			System.out.println("p3-> "+p3);				
		} catch (CloneNotSupportedException e) {
			System.out.println("clonen niet gelukt");
		}	
	}
}


