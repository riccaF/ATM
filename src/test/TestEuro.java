package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {
    
    Euro Euro1;
    Euro Euro2;
    Euro Euro3;
    Euro Euro4;
    Euro Euro5;

    @Before
    public void init(){
        Euro1 = new Euro(0,20);
        Euro2 = new Euro(0.50);
        Euro3 = new Euro(1,0);
        Euro4 = new Euro(2);
        Euro5 = new Euro(5, 0);
    }

    @Test
    public void testGetValore() {
        assertEquals(20, Euro1.getValore());
        assertEquals(50, Euro2.getValore());
        assertEquals(100, Euro3.getValore());
        assertEquals(200, Euro4.getValore());
        assertEquals(500, Euro5.getValore());
    }

    @Test
    public void testMinoreDi() {
        assertTrue("Errore riscontrato in MinoreDi(Test1): Euro1 ("+Euro1.getValore()+") dovrebbe avere un valore più basso di Euro2 ("+Euro2.getValore()+")", Euro1.minoreDi(Euro2));
        assertTrue("Errore riscontrato in MinoreDi(Test2): Euro2 ("+Euro2.getValore()+") dovrebbe avere un valore più basso di Euro5 ("+Euro5.getValore()+")", Euro2.minoreDi(Euro5));
        assertTrue("Errore riscontrato in MinoreDi(Test3): Euro3 ("+Euro3.getValore()+") dovrebbe avere un valore più basso di Euro4 ("+Euro4.getValore()+")", Euro3.minoreDi(Euro4));
        assertFalse("Errore riscontrato in MinoreDi(Test4): Euro5 ("+Euro5.getValore()+") dovrebbe avere un valore più alto di Euro4 ("+Euro4.getValore()+")", Euro5.minoreDi(Euro4));
        assertFalse("Errore riscontrato in MinoreDi(Test5): Euro4 ("+Euro4.getValore()+") dovrebbe avere un valore più alto di Euro1 ("+Euro1.getValore()+")", Euro4.minoreDi(Euro1));
        assertFalse("Errore riscontrato in MinoreDi(Test6): Euro3 ("+Euro3.getValore()+") dovrebbe avere un valore più alto di Euro2 ("+Euro2.getValore()+")", Euro3.minoreDi(Euro2));
    }

    @Test
    public void testSomma() {
        assertEquals(250, Euro2.somma(Euro4).getValore());
        assertEquals(120, Euro1.somma(Euro3).getValore());
        assertEquals(600, Euro3.somma(Euro5).getValore());
    }

    @Test
    public void testSottrai() {
        assertEquals(300, Euro5.sottrai(Euro4).getValore());
        assertEquals(180, Euro4.sottrai(Euro1).getValore());
        assertEquals(50, Euro3.sottrai(Euro2).getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("0.2 euro", Euro1.stampa());
        assertEquals("0.5 euro", Euro2.stampa());
        assertEquals("1.0 euro", Euro3.stampa());
        assertEquals("2.0 euro", Euro4.stampa());
        assertEquals("5.0 euro", Euro5.stampa());
    }
    
    @Test
    public void testUgualeA() {
        Euro Euro6 = new Euro(2, 0);
        assertTrue("Errore riscontrato in UgualeA(Test1): Euro4 ("+Euro4.getValore()+") e Euro6 ("+Euro6.getValore()+") dovrebbero avere lo stesso valore", Euro4.ugualeA(Euro6));
    }
}
