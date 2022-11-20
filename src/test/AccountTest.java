package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Euro;
import code.Database.Account;

public class AccountTest {
    @Test
    public void testCredit() {
        Account a=new Account(1234, 1234, new Euro(100), new Euro(100));
        a.credit(new Euro(100));
        assertEquals(20000,a.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Account a=new Account(1234, 1234, new Euro(100), new Euro(100));
        a.debit(new Euro(100));
        assertEquals(0,a.getAvailableBalance().getValore());
        assertEquals(0,a.getTotalBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        Account a=new Account(1234, 1234, new Euro(100), new Euro(100));
        assertEquals(1234,a.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        Account a=new Account(1234, 1234, new Euro(100), new Euro(100));
        assertEquals(10000,a.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        Account a=new Account(1234, 1234, new Euro(100), new Euro(100));
        assertEquals(10000,a.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN() {
        Account a=new Account(1234, 1234, new Euro(100), new Euro(100));
        assertTrue(a.validatePIN(1234));
    }
}
