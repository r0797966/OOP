package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import domain.Persoon;

public class Appeke2 {

	public static void main(String[] args) {
		//inlezen CSV bestand met vaccinatiegegevens
		//TODO ???
        Set<Persoon> personen = new TreeSet<>();
        Map<LocalDate, Integer> aantalPerDag = new TreeMap<>();
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
                Persoon p = new Persoon(email, gsmNummer, LocalDate.of(geboortejaar, geboortemaand, geboortedag));
                personen.add(p);
                int totaal = 1;
                if(aantalPerDag.containsKey(LocalDate.of(geboortejaar, geboortemaand, geboortedag))) {
                    totaal = aantalPerDag.get(LocalDate.of(geboortejaar, geboortemaand, geboortedag)) + 1;
                }
                aantalPerDag.put(LocalDate.of(geboortejaar, geboortemaand, geboortedag), totaal);
            }
            scannerFile.close();
        }  catch (FileNotFoundException ex) {
            System.out.println("fout bij inlezen");
        }
        catch(NumberFormatException e){
            System.out.println("data niet numeriek");
        }
        // console output lijst 1: overzicht van personen gesorteerd op gsm nummer en bij gelijk gsm nummer op email adres
        for (Persoon persoon:personen) {
        	System.out.println(String.format("%-10s %-30s %-10s", persoon.getGsmnummer(), persoon.getEmailAdres(),persoon.getVaccinatieDatum()));
        }        
        System.out.println();
        
        
        //genereren in het geheugen van lijst 2 (oplopende lijst van vaccinatiedatums met per datum aantal te vaccineren personen)
        //TODO ???
        
		
		// console output van lijst 2
		// String.format("%-10s: %2d", datum, aantal) zorgt ervoor dat de output in 2 kolommen is uitgelijnd)
        
		//TODO ???
        for (Map.Entry<LocalDate, Integer> entry : aantalPerDag.entrySet()) {
            System.out.printf("%-10s: %2d%n", entry.getKey(), entry.getValue());
        }

		        
	}
}
