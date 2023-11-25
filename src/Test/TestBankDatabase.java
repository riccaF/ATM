package Test;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

import code.Database.BankDatabase;
import code.Business_logic.Euro;



public class TestBankDatabase {

    private BankDatabase bankDatabase;

    @Before
    public void setUp() {
        // Inizializza la classe BankDatabase prima di ogni test
        bankDatabase = new BankDatabase();
    }

    @After
    public void cleanUp(){
        bankDatabase = null;
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
        assertFalse(bankDatabase.authenticateUser(12345, 9999));
        assertFalse(bankDatabase.authenticateUser(11111, 54321));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000.0, bankDatabase.getAvailableBalance(12345).getValore(), 0.001);
        assertEquals(20000.0, bankDatabase.getAvailableBalance(98765).getValore(), 0.001);
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000.0, bankDatabase.getTotalBalance(12345).getValore(), 0.001);
        assertEquals(20000.0, bankDatabase.getTotalBalance(98765).getValore(), 0.001);
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(12345, new Euro(500,0));
        assertEquals(170000.0, bankDatabase.getTotalBalance(12345).getValore(), 0.001);
    }

    @Test
    public void testDebit() {
        bankDatabase.debit(98765, new Euro(100,0));
        assertEquals(10000.0, bankDatabase.getTotalBalance(98765).getValore(), 0.001);
    }
    
}
