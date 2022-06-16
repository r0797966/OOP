package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CDTest {
    private String geldigeNaam, zesTekens, eenTeken, vijfTekens;
    private double geldigeKortingsPercentage, negatiefPercentage, tweePercentage, nulPercentage, eenPercentage, anderPercentage;
    private ArrayList<Liedje> liedjes;
    private Liedje geldigLied, tweedeLied, derdeLied;
    private CD c, a;

    @Before
    public void setUp() throws Exception {
        this.geldigeNaam = "folklore";
        this.geldigeKortingsPercentage = 0.50;
        this.liedjes = new ArrayList<>();
        this.zesTekens = "azerty";
        this.eenTeken = "a";
        this.vijfTekens = "azert";
        this.negatiefPercentage = -0.5;
        this.tweePercentage = 2;
        this.nulPercentage = 0;
        this.eenPercentage = 1;
        this.geldigLied = new Liedje("this is me trying", "Taylor Swift", "Indie", new Euro(4, 99));
        this.c = new CD(geldigeNaam, geldigeKortingsPercentage, geldigLied);
        this.anderPercentage = 0.75;
        this.a = new CD(geldigeNaam);
        this.tweedeLied = new Liedje("Loveless", "PVRIS", "Synth", new Euro(2, 99));
        this.derdeLied = new Liedje("hoax", "Taylor Swift", "Indie", new Euro(3, 49));
    }

    // constructor 1 parameter
    @Test(expected = IllegalArgumentException.class)
    public void test_CD_1_parameter_Met_naam_is_null_Gooit_exception(){
        new CD(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_1_parameter_Met_naam_bevat_minder_dan_6_tekens_Gooit_exception(){
        new CD(eenTeken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_1_parameter_Met_naam_bevat_5_tekens_Gooit_exception(){
        new CD(vijfTekens);
    }

    @Test
    public void test_CD_1_parameter_Met_naam_bevat_precies_6_tekens_Maakt_object(){
        CD c = new CD(zesTekens);
        assertEquals(zesTekens, c.getNaam());
        assertEquals(0, c.getKortingsPercentage(), 0);
    }

    @Test
    public void test_CD_1_parameter_Met_naam_bevat_meer_dan_6_tekens_Maakt_object(){
        CD c = new CD(geldigeNaam);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(0, c.getKortingsPercentage(), 0);
    }

    // constructor 2 parameters
    @Test(expected = IllegalArgumentException.class)
    public void test_CD_2_parameters_Met_naam_is_null_Gooit_exception(){
        new CD(null, geldigeKortingsPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_2_parameters_Met_naam_bevat_5_tekens_Gooit_exception(){
        new CD(vijfTekens, geldigeKortingsPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_2_parameters_Met_naam_bevat_minder_dan_6_tekens_Gooit_exception(){
        new CD(eenTeken, geldigeKortingsPercentage);
    }

    @Test
    public void test_CD_2_parameters_Met_naam_bevat_precies_6_tekens_Maakt_object(){
        CD c = new CD(zesTekens, geldigeKortingsPercentage);
        assertEquals(zesTekens, c.getNaam());
        assertEquals(geldigeKortingsPercentage, c.getKortingsPercentage(), 0);
    }

    @Test
    public void test_CD_2_parameters_Met_naam_bevat_meer_dan_6_tekens_Maakt_object(){
        CD c = new CD(geldigeNaam, geldigeKortingsPercentage);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(geldigeKortingsPercentage, c.getKortingsPercentage(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_2_parameters_Met_kortingspercentage_negatief_Gooit_exception(){
        new CD(geldigeNaam, negatiefPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_2_parameters_Met_kortingspercentage_1_Gooit_exception(){
        new CD(geldigeNaam, eenPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_2_parameters_Met_kortingspercentage_meer_dan_1_Gooit_exception(){
        new CD(geldigeNaam, tweePercentage);
    }

    @Test
    public void test_CD_2_parameters_Met_kortingspercentage_nul_Maakt_object(){
        CD c = new CD(geldigeNaam, nulPercentage);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(nulPercentage, c.getKortingsPercentage(), 0);
    }

    @Test
    public void test_CD_2_parameters_Met_kortingspercentage_tussen_nul_en_een_Maakt_object(){
        CD c = new CD(geldigeNaam, geldigeKortingsPercentage);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(geldigeKortingsPercentage, c.getKortingsPercentage(), 0);
    }

    // constructor 3 parameters
    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_naam_is_null_Gooit_exception(){
        new CD(null, geldigeKortingsPercentage, geldigLied);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_naam_bevat_minder_dan_6_tekens_Gooit_exception(){
        new CD(eenTeken, geldigeKortingsPercentage, geldigLied);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_naam_bevat_5_tekens_Gooit_exception(){
        new CD(vijfTekens, geldigeKortingsPercentage, geldigLied);
    }

    @Test
    public void test_CD_3_parameters_Met_naam_bevat_precies_6_tekens_Maakt_object(){
        CD c = new CD(zesTekens, geldigeKortingsPercentage, geldigLied);
        assertEquals(zesTekens, c.getNaam());
        assertEquals(geldigeKortingsPercentage, c.getKortingsPercentage(), 0);
        assertEquals(geldigLied, c.getLied(1));
    }

    @Test
    public void test_CD_3_parameters_Met_naam_bevat_meer_dan_6_tekens_Maakt_object(){
        CD c = new CD(geldigeNaam, geldigeKortingsPercentage, geldigLied);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(geldigeKortingsPercentage, c.getKortingsPercentage(), 0);
        assertEquals(geldigLied, c.getLied(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_kortingspercentage_negatief_Gooit_exception(){
        new CD(geldigeNaam, negatiefPercentage, geldigLied);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_kortingspercentage_1_Gooit_exception(){
        new CD(geldigeNaam, eenPercentage, geldigLied);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_kortingspercentage_meer_dan_1_Gooit_exception(){
        new CD(geldigeNaam, tweePercentage, geldigLied);
    }

    @Test
    public void test_CD_3_parameters_Met_kortingspercentage_nul_Maakt_object(){
        CD c = new CD(geldigeNaam, nulPercentage, geldigLied);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(nulPercentage, c.getKortingsPercentage(), 0);
        assertEquals(geldigLied, c.getLied(1));
    }

    @Test
    public void test_CD_3_parameters_Met_kortingspercentage_tussen_nul_en_een_Maakt_object(){
        CD c = new CD(geldigeNaam, geldigeKortingsPercentage, geldigLied);
        assertEquals(geldigeNaam, c.getNaam());
        assertEquals(geldigeKortingsPercentage, c.getKortingsPercentage(), 0);
        assertEquals(geldigLied, c.getLied(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CD_3_parameters_Met_Liedje_null_Gooit_exception(){
        new CD(geldigeNaam, geldigeKortingsPercentage, null);
    }

    // wijzigKortingsPercentage
    @Test(expected = IllegalArgumentException.class)
    public void test_SetKortingsPercentage_Met_kortingsPercentage_negatief_Gooit_exception(){
        c.setKortingsPercentage(negatiefPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetKortingsPercentage_Met_kortingsPercentage_1_Gooit_exception(){
        c.setKortingsPercentage(eenPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetKortingsPercentage_Met_kortingsPercentage_meer_dan_1_Gooit_exception(){
        c.setKortingsPercentage(tweePercentage);
    }

    @Test
    public void test_SetKortingsPercentage_Met_kortingsPercentage_nul_Veranderd_kortingsPercentage(){
        c.setKortingsPercentage(nulPercentage);
        assertEquals(nulPercentage, c.getKortingsPercentage(), 0);
    }

    @Test
    public void test_SetKortingsPercentage_Met_kortingsPercentage_tussen_0_en_1_Veranderd_kortingsPercentage(){
        c.setKortingsPercentage(anderPercentage);
        assertEquals(anderPercentage, c.getKortingsPercentage(), 0);
    }

    // getTotalePrijs

    // voegLiedjeToe
    @Test(expected = IllegalArgumentException.class)
    public void test_VoegLiedjeToe_Met_Liedje_null_Gooit_exception(){
        c.voegLiedjeToe(null);
    }

    @Test
    public void test_VoegLiedjeToe_Met_nog_geen_liedjes_op_cd_Voegt_Liedje_Toe(){
        a.voegLiedjeToe(geldigLied);
        assertEquals(geldigLied, a.getLied(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_VoegLiedjeToe_Met_meerdere_liedjes_op_cd_geen_gemeenschappelijke_stijl_Gooit_exception(){
        c.voegLiedjeToe(tweedeLied);
    }

    @Test
    public void test_VoegLiedjeToe_Met_meerdere_liedjes_op_cd_en_gemeenschappelijke_stijl_Voegt_Liedje_Toe(){
        c.voegLiedjeToe(derdeLied);
        assertEquals(derdeLied, c.getLied(2));
    }

}