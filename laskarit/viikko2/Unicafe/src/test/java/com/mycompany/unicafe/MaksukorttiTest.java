package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(1595);
//rahaa on kortilla 1605 senttiä
        assertEquals("saldo: 16.5", kortti.toString());
//        sentit ilman kymmeniä käsitellään tooStringissä väärin
    }

    @Test
    public void saldoVaheneeOikeinKunRahaRiittaa() {
        kortti.lataaRahaa(1595);
//rahaa on kortilla 1605 senttiä
        kortti.otaRahaa(1505);
        assertEquals("saldo: 1.0", kortti.toString());
    }

    @Test
    public void saldoEiVaheneKunRahaEiRiita() {
//rahaa on kortilla 10 senttiä
        kortti.otaRahaa(1505);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void otaRahaaPalauttaaTrueKunRahaRiittaa() {
        kortti.lataaRahaa(1595);
//rahaa on kortilla 1605 senttiä
        assertTrue(kortti.otaRahaa(1505));
    }

    @Test
    public void otaRahaaPalauttaaFalseKunRahaEiRiitta() {
//rahaa on kortilla 10 senttiä
        assertFalse(kortti.otaRahaa(1505));
    }

}
