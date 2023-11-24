package test;

import org.junit.Test;
import static org.junit.Assert.*;
import code.Business_logic.Euro;
import code.Database.Account;

public class TestAccount {
    @Test
    public void testAccountConstructorAndGetters() {
        int accountNumber = 12345;
        int pin = 54321;
        Euro availableBalance = new Euro(100, 0);
        Euro totalBalance = new Euro(200, 0);
        Account account = new Account(accountNumber, pin, availableBalance, totalBalance);
        
        assertEquals(accountNumber, account.getAccountNumber());
        assertTrue(account.validatePIN(pin));
        assertEquals(availableBalance.getValore(), account.getAvailableBalance().getValore());
        assertEquals(totalBalance.getValore(), account.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN() {
        Account account = new Account(12345, 6789, new Euro(100, 0), new Euro(200, 0));
        assertTrue(account.validatePIN(6789));
        assertFalse(account.validatePIN(1234));
    }

    @Test
    public void testCredit() {
        Euro availableBalance = new Euro(100, 0);
        Euro totalBalance = new Euro(200, 0);
        Account account = new Account(12345, 6789, availableBalance, totalBalance);
        
        Euro creditAmount = new Euro(50, 0);
        account.credit(creditAmount);
        
        assertEquals(new Euro(250, 0).getValore(), account.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Euro availableBalance = new Euro(500, 0);
        Euro totalBalance = new Euro(1000, 0);
        Account account = new Account(12345, 6789, availableBalance, totalBalance);
        
        Euro debitAmount = new Euro(50, 0);
        account.debit(debitAmount);
        
        assertEquals(new Euro(450, 0).getValore(), account.getAvailableBalance().getValore());
        assertEquals(new Euro(950, 0).getValore(), account.getTotalBalance().getValore());
    }
}