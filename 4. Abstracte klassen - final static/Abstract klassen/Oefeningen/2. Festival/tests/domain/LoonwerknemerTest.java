package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoonwerknemerTest {
    private String geldigeNaam, geldigeVoornaam, geldigRijksregisternr;
    private String ongeldigRijkregisternr;
    private Loonwerknemer l;

    @org.junit.Before
    public void setUp() throws Exception {
        this.geldigeNaam = "Brando";
        this.geldigeVoornaam = "Alex";
        this.geldigRijksregisternr = "31.11.11-111.11";
        this.ongeldigRijkregisternr = "111.111.111";
        this.l = new Loonwerknemer(geldigeNaam, geldigeVoornaam, geldigRijksregisternr);
        l.verhoogUur(2); // voor bereken verloning
    }

    // constructor
    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_naam_null_Gooit_exception(){
        new Loonwerknemer(null, geldigeVoornaam, geldigRijksregisternr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_naam_spaties_Gooit_exception(){
        new Loonwerknemer("   ", geldigeVoornaam, geldigRijksregisternr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_voornaam_null_Gooit_exception(){
        new Loonwerknemer(geldigeNaam, null, geldigRijksregisternr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_voornaam_spaties_Gooit_exception(){
        new Loonwerknemer(geldigeNaam, "      ", geldigRijksregisternr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_rijksregisternr_null_Gooit_exception(){
        new Loonwerknemer(geldigeNaam, geldigeVoornaam, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_rijksregisternr_spaties_Gooit_exception(){
        new Loonwerknemer(geldigeNaam, geldigeVoornaam, "      ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loonwerknemer_Met_rijksregisternr_ongeldige_vorm_Gooit_exception(){
        new Loonwerknemer(geldigeNaam, geldigeVoornaam, ongeldigRijkregisternr);
    }

    @Test
    public void test_Loonwerknemer_Met_geldige_waarden_maakt_object(){
        Loonwerknemer l = new Loonwerknemer(geldigeNaam, geldigeVoornaam, geldigRijksregisternr);
        assertEquals(geldigeNaam, l.getNaam());
        assertEquals(geldigeVoornaam, l.getVoornaam());
        assertEquals(geldigRijksregisternr, l.getRijksregisternr());
    }

    // verhoogUur
    @Test(expected = IllegalArgumentException.class)
    public void test_VerhoogUur_Met_negatief_getal_Gooit_exception(){
        l.verhoogUur(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_VerhoogUur_Met_0_Gooit_exception(){
        l.verhoogUur(0);
    }

    @Test
    public void test_VerhoogUur_Met_positief_getal_Verhoogt_uur(){
        l.verhoogUur(2);
        assertEquals(l.uur, 2);
    }

    // resetUur
    @Test
    public void test_Resetuur_Zet_uur_op_0(){
        l.resetUur();
        assertEquals(l.uur, 0);
    }

    @Test
    public void test_BerekenVerloning_Geeft_verloning(){
        assertEquals(l.berekenVerloning(), 20, 0);
    }


}