package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Business_logic.Euro;
import database.BankDatabase;

public class TestBankDatabase {
    BankDatabase bk;
    Euro euro;

    @Before
    public void setUp() {
        bk = new BankDatabase();
        euro = new Euro(1000);
    }


    @Test
    public void testAuthenticateUser() {
        assertTrue("Pin corretto", bk.authenticateUser(12345, 54321));
        assertFalse("utente errato", bk.authenticateUser(12349, 54321));
        assertFalse("Pin errato", bk.authenticateUser(12345, 999));
    }

    @Test
    public void testCredit() {
        bk.credit(12345, euro);
        assertEquals(220000, bk.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        bk.debit(12345, euro);
        assertEquals(0, bk.getAvailableBalance(12345).getValore());
        assertEquals(20000, bk.getTotalBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(20000, bk.getAvailableBalance(98765).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(20000, bk.getTotalBalance(98765).getValore());
    }
}
