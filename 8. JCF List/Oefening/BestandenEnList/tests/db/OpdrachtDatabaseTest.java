package db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Opdracht;

public class OpdrachtDatabaseTest {
	private OpdrachtDatabank db;
	
	@Before
	public void setUp(){
		db = new OpdrachtDatabank("Opdrachten-1.txt");
	}

	@Test
	public void OpdrachtDatabank_leest_alle_afstanden_in() throws Exception {
		OpdrachtDatabank db = new OpdrachtDatabank("Opdrachten-1.txt");
		assertEquals(56, db.getOpdrachten().size());
	}

	@Test (expected = IllegalArgumentException.class)
	public void OpdrachtDatabank_gooit_een_IllegalArgumentException_als_het_input_bestand_niet_gevonden_wordt() throws Exception {
		new OpdrachtDatabank("Opdrachten-99.txt");
	}
	
	@Test
	public void voegToe_voegt_een_opdracht_toe_aan_de_lijst() throws Exception {
		Opdracht opdracht = new Opdracht(9999, "Hoeveel maanden zijn er in een jaar", "12", true, "meer dan 10", "Wetenschappen", "Karel");
		db.voegToe(opdracht);
		
		List<Opdracht> opdrachten = db.getOpdrachten();
		assertEquals(opdracht, opdrachten.get(opdrachten.size() - 1));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void voegToe_gooit_exception_als_geen_opdracht_mmegegeven_wordt() throws Exception {
		OpdrachtDatabank db = new OpdrachtDatabank("Opdrachten-1.txt");
		db.voegToe(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void voegToe_gooit_exception_als_de_opdracht_al_in_de_databank_zit() throws Exception {
		OpdrachtDatabank db = new OpdrachtDatabank("Opdrachten-1.txt");
		db.voegToe(null);
	}
}
