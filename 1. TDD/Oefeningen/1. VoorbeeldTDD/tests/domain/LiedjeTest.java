package domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LiedjeTest {
    private String geldigeNaam, geldigeMuzikant, geldigeStijl, tweedeStijl, derdeStijl, vierdeStijl;
    private Euro geldigePrijs, nulPrijs, negatievePrijs, anderePrijs;
    private String[] stijlen1;
    private Liedje l, a;

    @org.junit.Before
    public void setUp() throws Exception {
        this.geldigeNaam = "this is me trying";
        this.geldigeMuzikant = "Taylor Swift";
        this.geldigeStijl = "Indie";
        this.geldigePrijs = new Euro(4, 99);
        this.nulPrijs = new Euro(0, 0);
        this.negatievePrijs = new Euro(-2, 99);
        this.stijlen1 = new String[3];
        this.l = new Liedje(geldigeNaam, geldigeMuzikant, geldigeStijl, geldigePrijs);
        this.anderePrijs = new Euro(3, 99);
        this.tweedeStijl = "Pop";
        this.derdeStijl = "Rock";
        this.vierdeStijl = "Country";
        l.voegStijlToe(tweedeStijl);
        l.voegStijlToe(derdeStijl);
        this.a = new Liedje(geldigeNaam, geldigeMuzikant, geldigeStijl, geldigePrijs);
    }

    // constructor
    @Test(expected = IllegalArgumentException.class)
    public void test_Liedje_Met_naam_null_Gooit_exception(){
        new Liedje(null, geldigeMuzikant, geldigeStijl, geldigePrijs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Liedje_Met_naam_enkel_uit_spaties_Gooit_exception(){
        new Liedje("     ", geldigeMuzikant, geldigeStijl, geldigePrijs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Liedje_Met_stijl_null_spaties_Gooit_exception(){
        new Liedje(geldigeNaam, geldigeMuzikant, null, geldigePrijs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Liedje_Met_stijl_enkel_uit_spaties_Gooit_exception(){
        new Liedje(geldigeNaam, geldigeMuzikant, "  ", geldigePrijs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Liedje_Met_prijs_null_Gooit_exception(){
        new Liedje(geldigeNaam, geldigeMuzikant, geldigeStijl, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Liedje_Met_prijs_negatief_bedrag_Gooit_exception(){
        new Liedje(geldigeNaam, geldigeMuzikant, geldigeStijl, negatievePrijs);
    }

    @Test
    public void test_Liedje_Met_alle_parameters_geldige_waarden_en_prijs_nul_euro_Maakt_object(){
        Liedje l = new Liedje(geldigeNaam, geldigeMuzikant, geldigeStijl, nulPrijs);
        assertEquals(geldigeNaam, l.getNaam());
        assertEquals(geldigeMuzikant, l.getMuzikant());
        assertEquals(geldigeStijl, l.getStijl(1));
        assertEquals(nulPrijs, l.getPrijs());
    }

    @Test
    public void test_Liedje_Met_alle_parameters_geldige_waarden_en_muzikant_verschillende_van_null_Maakt_object(){
        Liedje l = new Liedje(geldigeNaam, geldigeMuzikant, geldigeStijl, geldigePrijs);
        assertEquals(geldigeNaam, l.getNaam());
        assertEquals(geldigeMuzikant, l.getMuzikant());
        assertEquals(geldigeStijl, l.getStijl(1));
        assertEquals(geldigePrijs, l.getPrijs());
    }

    @Test
    public void test_Liedje_Met_alle_parameters_geldige_waarden_en_muzikant_null_Maakt_object(){
        Liedje l = new Liedje(geldigeNaam, null, geldigeStijl, nulPrijs);
        assertEquals(geldigeNaam, l.getNaam());
        assertNull(l.getMuzikant());
        assertEquals(geldigeStijl, l.getStijl(1));
        assertEquals(nulPrijs, l.getPrijs());
    }

    // setPrijs
    @Test(expected = IllegalArgumentException.class)
    public void test_SetPrijs_Met_prijs_null_Gooit_exception(){
        l.setPrijs(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetPrijs_Met_prijs_negatief_bedrag_Gooit_exception(){
        l.setPrijs(negatievePrijs);
    }

    @Test
    public void test_SetPrijs_Met_prijs_nul_euro_Veranderd_prijs(){
        l.setPrijs(nulPrijs);
        assertEquals(nulPrijs, l.getPrijs());
    }

    @Test
    public void test_SetPrijs_Met_prijs_positief_bedrag_Veranderd_prijs(){
        l.setPrijs(anderePrijs);
        assertEquals(anderePrijs, l.getPrijs());
    }

    // bevatStijl
    @Test
    public void test_BevatStijl_Met_gegevenStijl_null_Geeft_false(){
        assertFalse(l.bevatStijl(null));
    }

    @Test
    public void test_BevatStijl_Met_gegevenStijl_komt_voor_in_ander_vorm_Geeft_true(){
        assertTrue(l.bevatStijl("indIE"));
    }

    @Test
    public void test_BevatStijl_Met_gegevenStijl_komt_niet_voor_Geeft_false(){
        assertFalse(l.bevatStijl(vierdeStijl));
    }

    @Test
    public void test_BevatStijl_Met_gegevenStijl_komt_voor_in_zelfde_vorm_Geeft_true(){
        assertTrue(l.bevatStijl("Indie"));
    }

    // voegStijlToe
    @Test(expected = IllegalArgumentException.class)
    public void test_VoegStijlToe_Met_nieuweStijl_null_Gooit_exception(){
        l.voegStijlToe(null);
    }

    @Test(expected = IllegalStateException.class)
    public void test_VoegStijlToe_Met_nieuweStijl_komt_nog_niet_voor_meer_geen_plaats_meer_Gooit_exception(){
        l.voegStijlToe(vierdeStijl);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_VoegStijlToe_Met_nieuweStijl_komt_voor_in_verschillende_vorm_Gooit_exception(){
        a.voegStijlToe("inDie");
    }

    @Test
    public void test_VoegStijlToe_Met_nieuweStijl_komt_niet_voor_en_nog_geen_drie_stijlen_toegevoegd_Gooit_exception(){
        a.voegStijlToe(tweedeStijl);
        assertEquals(tweedeStijl, a.getStijl(2));
    }

    // getStijl
    @Test
    public void test_GetStijl_Met_i_is_1_Geeft_eerste_stijl(){
        assertEquals(geldigeStijl, l.getStijl(1));
    }

    @Test
    public void test_GetStijl_Met_i_is_2_Geeft_tweede_stijl(){
        assertEquals(tweedeStijl, l.getStijl(2));
    }

    @Test
    public void test_GetStijl_Met_i_is_3_Geeft_derde_stijl(){
        assertEquals(derdeStijl, l.getStijl(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_GetStijl_Met_i_is_0_Gooit_exception(){
        l.getStijl(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_GetStijl_Met_i_is_negatief_Gooit_exception(){
        l.getStijl(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_GetStijl_Met_i_is_4_Gooit_exception(){
        l.getStijl(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_GetStijl_Met_i_is_hoger_dan_4_Gooit_exception(){
        l.getStijl(6);
    }

}