package domain;
import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String naam;
	private String voornaam;
	
	public Student (String naam, String voornaam) {
		this.naam = naam;
		this.voornaam = voornaam;
	}
	
	@Override
	public String toString() {
		return voornaam+" "+naam;
	}

}
