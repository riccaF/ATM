package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import code.BusinessLogic.Euro;
import code.database.BankDatabase;

public class testBankDatabase {

    private BankDatabase bankDatabase;

    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
        assertFalse(bankDatabase.authenticateUser(12345, 1111));
        assertFalse(bankDatabase.authenticateUser(11111, 54321));
    }

    @Test
    public void testGetAvailableBalance() {
        assertTrue(new Euro(1000.0).ugualeA(bankDatabase.getAvailableBalance(12345)));
        assertTrue(new Euro(200.0).ugualeA(bankDatabase.getAvailableBalance(98765)));
    }

    @Test
    public void testGetTotalBalance() {
        assertTrue(new Euro(1200.0).ugualeA(bankDatabase.getTotalBalance(12345)));
        assertTrue(new Euro(200.0).ugualeA(bankDatabase.getTotalBalance(98765)));
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(12345, new Euro(100.0));
        assertTrue(new Euro(1300.0).ugualeA(bankDatabase.getTotalBalance(12345)));
    }

    @Test
    public void testDebit() {
        bankDatabase.debit(12345, new Euro(50.0));
        assertTrue(new Euro(950.0).ugualeA(bankDatabase.getAvailableBalance(12345)));
    }
}
