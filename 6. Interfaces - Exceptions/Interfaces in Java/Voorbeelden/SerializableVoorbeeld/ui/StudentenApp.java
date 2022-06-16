package ui;
import domain.Student;
import domain.StudentGroep;

public class StudentenApp {

	public static void main(String[] args) {
		StudentGroep groep = StudentGroep.load();
		if (groep == null) {
			groep = new StudentGroep("informatica");
		}
		groep.voegStudentToe(new Student ("Karel","Vos"));
		System.out.println(groep);
		groep.save();		
	}
	//wanneer we deze app de eerste keer uitvoeren zal er 1 student in de groep zitten
	//wanneer we de app nog een uitvoeren zal dezelfde student 2 keer in de groep zitten
	// de student is immers opgelagen in een geserialiseerd bestand bij de eerste afsluiting
	//en wordt bij het opstarten de 2 de keer opnieuw ingelezen en aan de groep toegevoegd
}
