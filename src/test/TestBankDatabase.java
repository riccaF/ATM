package test;

import code.Business_logic.Euro;
import code.Database.BankDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBankDatabase {

    private BankDatabase bankDatabase;

    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void testAuthenticateUser() {
        Assert.assertTrue(bankDatabase.authenticateUser(12345, 54321));
        Assert.assertFalse(bankDatabase.authenticateUser(12345, 12345));
    }

    @Test
    public void testGetAvailableBalance() {
        Assert.assertEquals(100000, bankDatabase.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        Assert.assertEquals(120000, bankDatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(12345, new Euro(500, 0));
        Assert.assertEquals(170000, bankDatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        bankDatabase.debit(12345, new Euro(500, 0));
        Assert.assertEquals(50000, bankDatabase.getAvailableBalance(12345).getValore());
    }
}