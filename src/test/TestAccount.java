package test;

import org.junit.Assert;
import org.junit.Test;

import code.Business_logic.Euro;
import code.Business_logic.Account;

public class TestAccount {

    @Test
    public void testValidatePIN() {
        Account account = new Account(12345, 54321, new Euro(1000), new Euro(2000));
        Assert.assertTrue(account.validatePIN(54321));
        Assert.assertFalse(account.validatePIN(12345));
    }

    @Test
    public void testGetAvailableBalance() {
        Account account = new Account(12345, 54321, new Euro(1000), new Euro(2000));
        Assert.assertEquals(100000, account.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        Account account = new Account(12345, 54321, new Euro(1000), new Euro(2000));
        Assert.assertEquals(200000, account.getTotalBalance().getValore());
    }

    @Test
    public void testCredit() {
        Account account = new Account(12345, 54321, new Euro(1000), new Euro(2000));
        account.credit(new Euro(500));
        Assert.assertEquals(250000, account.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Account account = new Account(12345, 54321, new Euro(1000), new Euro(2000));
        account.debit(new Euro(500));
        Assert.assertEquals(50000, account.getAvailableBalance().getValore());
        Assert.assertEquals(150000, account.getTotalBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        Account account = new Account(12345, 54321, new Euro(1000), new Euro(2000));
        Assert.assertEquals(12345, account.getAccountNumber());
    }
}