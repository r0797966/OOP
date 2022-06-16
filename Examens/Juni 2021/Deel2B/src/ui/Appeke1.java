package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

import domain.Persoon;

public class Appeke1 {

	public static void main(String[] args) {
			//inlezen CSV bestand met vaccinatiegegevens
		 	//TODO ???
			Map<String, LocalDate> vaccinatiedatum = new TreeMap<>();
	        File personenFile = new File("vaccinatieGegevens.csv");
	        try {
	            Scanner scannerFile = new Scanner(personenFile);
	            while (scannerFile.hasNextLine()) {
	            	String s =scannerFile.nextLine();
	                String[] delen = s.split(";");
	            	int geboortejaar = Integer.parseInt(delen[2]);
	                int geboortemaand = Integer.parseInt(delen[1]);
	                int geboortedag = Integer.parseInt(delen[0]);
	                String gsmNummer = "??";
	                if( delen.length == 5) gsmNummer = delen[4];
	                String email = delen[3];
	                //TODO ???
					vaccinatiedatum.put(email, LocalDate.of(geboortejaar, geboortemaand, geboortedag));
	            }
	            scannerFile.close();
	        }  catch (FileNotFoundException ex) {
	            System.out.println("fout bij inlezen");
	        }
	        catch(NumberFormatException e){
	            System.out.println("data niet numeriek");
	        }
	        
	        //opvragen van vaccinatiedatums aan de hand van email adres
	        Scanner scanner = new Scanner(System.in);
	        String emailAdres = "";
	        System.out.println("Typ emailadres (* = stoppen)");
        	emailAdres = scanner.nextLine();
	        while (!emailAdres.equals("*")) {	        	
	        	//TODO ???
				if(vaccinatiedatum.containsKey(emailAdres)){
					System.out.println("Vactinatiedatum is " + vaccinatiedatum.get(emailAdres));
				} else {
					System.out.println("geen vaccinatiedatum gevonden");
				}
	        	System.out.println("Typ emailadres (* = stoppen)");
	        	emailAdres = scanner.nextLine();
	        }
	        scanner.close();
	}
}
