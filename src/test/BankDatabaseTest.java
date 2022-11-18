package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Database.BankDatabase;

public class BankDatabaseTest {
    @Test
    public void testAuthenticateUser() {
        BankDatabase bankDatabase = new BankDatabase();
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
    }

    @Test
    public void testCredit() {

    }

    @Test
    public void testDebit() {

    }

    @Test
    public void testGetAvailableBalance() {

    }

    @Test
    public void testGetTotalBalance() {

    }
}
