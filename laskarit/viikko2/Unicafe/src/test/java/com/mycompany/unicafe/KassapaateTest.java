/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author parta
 */
public class KassapaateTest {

    public KassapaateTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    Kassapaate kassapaate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(500);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void alkuArvoOikeinRahat() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void alkuArvoOikeinLounaat() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void myyntiKateinenEdullinenRahatRiittaa() {
        assertEquals(260, kassapaate.syoEdullisesti(500));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void myyntiKateinenMaukasRahatRiittaa() {
        assertEquals(100, kassapaate.syoMaukkaasti(500));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void myyntiKateinenEdullinenRahatEiRiita() {
        assertEquals(200, kassapaate.syoEdullisesti(200));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void myyntiKateinenMaukasRahatEiRiita() {
        assertEquals(200, kassapaate.syoMaukkaasti(200));
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void myyntiKorttiEdullinenRahatRiittaa() {
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void myyntiKorttiMaukasRahatRiittaa() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void myyntiKorttiEdullinenRahatEiRiita() {
        kassapaate.syoMaukkaasti(kortti);
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void myyntiKorttiMaukasRahatEiRiita() {
        kassapaate.syoMaukkaasti(kortti);
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void rahatEiMuutuKassassaKorttiostossa() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void rahanLatausKortilleToimiiOikein(){
        kassapaate.lataaRahaaKortille(kortti, 150);
        assertEquals(100150, kassapaate.kassassaRahaa());
        assertEquals(650, kortti.saldo());
    }

    @Test
    public void rahanLatausKortilleToimiiOikeinNegisSumma(){
        kassapaate.lataaRahaaKortille(kortti, -150);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(500, kortti.saldo());
    }

}
