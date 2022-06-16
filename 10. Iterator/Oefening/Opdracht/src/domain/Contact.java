package domain;

import java.util.Objects;

/**
 * Deze klasse stelt een Contact voor.
 */
public class Contact  {

	private String achternaam;
	private String voornaam;
	private String tel;

	/**
	 * Constructor voor een contact
	 * @param achternaam De achternaam voor het contact.
	 * @param voornaam De achternaam voor het contact.
	 * @param tel De telefoonnummer voor het contact.
	 * @ Wanneer achternaam, voornaam of telefoonnummer ongeldig zijn.
	 */
	public Contact(String achternaam, String voornaam, String tel)  {
		setAchternaam(achternaam);
		setVoornaam(voornaam);
		setTel(tel);
	}

	/**
	 * Retourneert de achternaam van het contact.
	 * @return De achternaam van het contact.
	 */
	public String getAchternaam() {
		return achternaam;
	}

	private void setAchternaam(String achternaam)
			 {
		if (achternaam == null || achternaam.equals("")) {
			throw new IllegalArgumentException("Ongeldige achternaam.");
		}
		this.achternaam = achternaam;
	}

	/**
	 * Retourneert de voornaam van het contact.
	 * @return De voornaam van het contact.
	 */
	public String getVoornaam() {
		return voornaam;
	}

	private void setVoornaam(String voornaam)  {
		if (voornaam == null || voornaam.equals("")) {
			throw new IllegalArgumentException("Ongeldige voornaam.");
		}
		this.voornaam = voornaam;
	}

	/**
	 * Retourneert het telefoonnummer van het contact.
	 * @return Het telefoonnummer van het contact.
	 */
	public String getTel() {
		return tel;
	}

	private void setTel(String tel)  {
		if (tel == null) {
			throw new IllegalArgumentException("Ongeldig telefoonnummer.");
		}
		this.tel = tel;
	}

	/**
	 * Retourneert de hashcode van het contact.
	 */
	@Override
	public int hashCode() {
		// TODO Maak de hashCode
		return Objects.hash(achternaam,voornaam,tel);
	}

	
	/**
	 * toString
	 */
	@Override
	public String toString(){
		return String.format("%-15s%-15s%10s", getAchternaam(),getVoornaam(),getTel());
	}
	
	//TODO Voeg de ontbrekende methodes toe

	
}
