package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Database.BankDatabase;

public class BankDatabaseTest {
    private BankDatabase bankDatabase;

    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
}

    @Test
    public void testAuthenticateUser() {
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
        assertTrue(bankDatabase.authenticateUser(98765, 56789));
        assertFalse(bankDatabase.authenticateUser(87654321, 1234));
    }
 
    @Test
    public void testGetAvailableBalance() {
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345), 0.0);
        assertEquals(200.0, bankDatabase.getAvailableBalance(98765), 0.0);
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(1200.0, bankDatabase.getTotalBalance(12345), 0.0);
        assertEquals(200.0, bankDatabase.getTotalBalance(98765), 0.0);;
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(12345, 500.0);
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345), 0.0);
        assertEquals(1700.0, bankDatabase.getTotalBalance(12345), 0.0);
    }

    @Test
    public void testDebit() {
        bankDatabase.debit(98765, 200.0);
        assertEquals(0.0, bankDatabase.getAvailableBalance(98765), 0.0);
        assertEquals(0.0, bankDatabase.getTotalBalance(98765), 0.0);
    }

}
