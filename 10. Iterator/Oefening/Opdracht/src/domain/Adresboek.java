package domain;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Deze klasse stelt een adresboek voor.
 */
public class Adresboek {

	private Set<Contact> contacten;


	/**
	 * Constructor voor het leeg adresboek.
	 */
	public Adresboek() {
		this(new LinkedHashSet<Contact>());
	}

	/**
	 * Constructor voor een adresboek met gegeven contacten.
	 *
	 * @param contacten De contacten voor het adresboek
	 */
	public Adresboek(Set<Contact> contacten) {
		this.contacten = contacten;
	}

	/**
	 * Retourneert de contacten het het adresboek.
	 *
	 * @return De contacten van het adresboek
	 */
	private Set<Contact> getContacten() {
		return contacten;
	}


	/**
	 * Geeft een adresboek-object terug, met daarin de gemeenschappelijke contacten van het adresboek, vergeleken
	 * met het adresboek dat als parameter meegegeven wordt.
	 *
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek met gemeenschappelijke contacten.
	 */
	public Adresboek gemeenschappelijkeContacten(Adresboek teVergelijken){
		Set <Contact> contacten = new TreeSet<Contact>(this.getContacten());
		contacten.retainAll(teVergelijken.getContacten());
		return new Adresboek(contacten);
	}

	/**
	 * Geeft een adresboek-object terug, waarin alle vrienden van het huidige adresboek en het meegegeven adresboek staan.
	 * Er staan geen dubbels in.
	 *
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek waarin alle contacten van de samengevoegde adresboeken staan, zonder dubbels.
	 */
	public Adresboek gezamelijkeContacten(Adresboek teVergelijken) {
		Set <Contact> contacten = new TreeSet<Contact>(this.getContacten());
		contacten.addAll(teVergelijken.getContacten());
		return new Adresboek(contacten);
	}

	/**
	 * Geeft een adresboek-object terug, waarin alle vrienden van het huidige adresboek
	 * die niet voorkomen in het meegegeven adresboek.
	 *
	 * @param teVergelijken Het adresboek waarmee vergeleken wordt.
	 * @return Het adresboek waarin de contacten staan die dit adresboek wel heeft het het meegegeven adresboek niet.
	 */
	public Adresboek verschillendeContacten (Adresboek teVergelijken){
		Set <Contact> contacten = new TreeSet<Contact>(this.getContacten());
		contacten.removeAll(teVergelijken.getContacten());
		return new Adresboek(contacten);
	}


	/**
	 * Voegt een contact toe aan het adresboek
	 *
	 * @param contact Het contact dat toegevoegd dient te worden.
	 * @return true wanneer het contact nog niet aanwezig is in het adresboek
	 */
	public boolean voegToe(Contact contact) {
		//if (getContacten().contains(contact)) return false;
		return getContacten().add(contact);
		//return true;
	}

	/**
	 * Verwijder alle contacten uit het adresboek met gegeven achternaam. Dit contact bevat de meegegegeven achternaam, voornaam en telefoonnummer.
	 * @param achternaam De achternaam van het contacten die moeten verwijderd worden uit het adresboek.
	 * @return aantal verwijderde contacten

	 */
	public int verwijder (String achternaam){
		int aantal = 0;
		Iterator <Contact> it = getContacten().iterator();
		while (it.hasNext()){
			Contact contact = it.next();
			if (contact.getAchternaam().equals(achternaam)){
				it.remove();
				aantal++;
			}
		}
		return aantal;
	}

	/**
	 * toString
	 */
	@Override
	public String toString(){
		String output ="";
		output+="Aantal contacten:"+getContacten().size()+"\n";
		Iterator<Contact>it = getContacten().iterator();
		while (it.hasNext()){
			Contact contact = it.next();
			output+=contact.toString()+"\n";
		}
		return output;
	}
}

