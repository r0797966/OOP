package domain;


import java.time.LocalDate;

public class Persoon  {
    private String emailAdres, gsmnummer;
    private LocalDate vaccinatiedatum;

    public Persoon(String emailAdres, String gsmnummer){
        if (emailAdres == null || !emailAdres.contains("@")) {
            throw new DomainException("emailadres van een persoon moet een @ teken bevatten");
        }
        this.emailAdres = emailAdres;
        this.gsmnummer = gsmnummer;
    }

    public Persoon(String emailAdres, String gsmnummer, LocalDate vaccinatiedatum){
        if (emailAdres == null || !emailAdres.contains("@")) {
            throw new IllegalArgumentException("emailadres van een persoon moet een @ teken bevatten");
        }
        this.emailAdres = emailAdres;
        this.gsmnummer = gsmnummer;
        this.vaccinatiedatum = vaccinatiedatum;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public String getGsmnummer() {
        return gsmnummer;
    }

    public LocalDate getVaccinatieDatum() {
        return vaccinatiedatum;
    }

    public String toString(){
        return "Email  adres: " + this.emailAdres +  (this.gsmnummer!= null? "\nGsm nummer : " + this.gsmnummer:"");
    }

}
