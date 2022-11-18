package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class BankDatabaseTest {
    @Test
    public void testAuthenticateUser() {
        BankDatabase bankDatabase = new BankDatabase();
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
    }

    @Test
    public void testCredit() {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.credit(12345, new Euro(100));
        assertEquals(130000,bankDatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.debit(12345, new Euro(100));
        assertEquals(110000,bankDatabase.getTotalBalance(12345).getValore());

    }

    @Test
    public void testGetAvailableBalance() {
        BankDatabase bankDatabase = new BankDatabase();
        assertEquals(100000,bankDatabase.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        BankDatabase bankDatabase = new BankDatabase();
        assertEquals(120000,bankDatabase.getTotalBalance(12345).getValore());

    }
}
