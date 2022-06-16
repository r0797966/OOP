package domain;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {
    private Point2D.Double geldigMiddelpunt, geldigPunt, ongeldigPunt;
    private double geldigeStraal;
    private Cirkel c;

    @org.junit.Before
    public void setUp() throws Exception {
        this.geldigMiddelpunt = new Point2D.Double(350, 450);
        this.geldigeStraal = 200;
        this.c = new Cirkel(geldigMiddelpunt, geldigeStraal);
        this.geldigPunt = new Point2D.Double(370, 400);
        this.ongeldigPunt = new Point2D.Double(500, 600);
    }

    // Constructor
    @Test(expected = IllegalArgumentException.class)
    public void testCirkel_Met_middelpunt_null_Gooit_exception(){
        new Cirkel(null, geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkel_Met_straal_negatief_Gooit_exception(){
        new Cirkel(geldigMiddelpunt, -200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCirkel_Met_straal_groter_dan_X_Gooit_exception(){
        new Cirkel(geldigMiddelpunt, 400);
    }

    @Test
    public void testCirkel_Met_geldige_waarden_Maakt_object(){
        Cirkel c = new Cirkel(geldigMiddelpunt, geldigeStraal);

        assertEquals(c.getMiddelpunt(), this.geldigMiddelpunt);
        assertEquals(c.getStraal(), this.geldigeStraal, 0);
    }

    @Test
    public void testCirkel_Met_straal_gelijk_aan_min_middelpunt_Maakt_object(){
        Cirkel c = new Cirkel(geldigMiddelpunt, 350);

        assertEquals(c.getMiddelpunt(), this.geldigMiddelpunt);
        assertEquals(c.getStraal(), 350, 0);
    }

    //berekenOppervlakte
    @Test
    public void testBerekenOppervlakte_Met_geldige_waarden_Berekent_oppervlakte(){
        assertEquals(Math.PI * geldigeStraal * geldigeStraal, c.berekenOppervlakte(), 0);
    }

    // puntInCirkel
    @Test(expected = IllegalArgumentException.class)
    public void testPuntInCirkel_Met_punt_null_Gooit_exception(){
        c.puntInCirkel(null);
    }

    @Test
    public void testPuntInCirkel_Met_punt_in_cirkel_Geeft_true(){
        assertTrue(c.puntInCirkel(geldigPunt));
    }

    @Test
    public void testPuntInCirkel_Met_punt_op_cirkel_Geeft_true(){
        assertTrue(c.puntInCirkel(geldigMiddelpunt));
    }

    @Test
    public void testPuntInCirkel_Met_punt_buiten_cirkel_Geeft_false(){
        assertFalse(c.puntInCirkel(ongeldigPunt));
    }

    // vergrootCirkel
    @Test(expected = IllegalArgumentException.class)
    public void testVergrootCirkel_Met_negatieve_factor_Gooit_exception(){
        c.vergrootCirkel(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVergrootCirkel_Met_ongeldige_waarde_Gooit_exception(){
        c.vergrootCirkel(3);
    }

    @Test
    public void testVergrootCirkel_Met_geldige_waarde_Vergroot_cirkel(){
        c.vergrootCirkel(1.2);

        assertEquals(c.getStraal(), this.geldigeStraal*1.2, 0);
    }
}