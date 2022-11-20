package test;

// import assertions
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// import code to test
import code.Business_logic.Euro;
import code.Business_logic.Account;

public class TestAccount {

    Account testAccount;

    @Before
    public void SetUp() {
        int accountNumber = 12345;
        int pin = 54321;
        Euro availableBalance = new Euro(100000);
        Euro totalBalance = new Euro(120000);
        testAccount = new Account(accountNumber, pin, availableBalance, totalBalance);
    }

    
    @Test
    public void testGetAvailableBalance() {
        assertEquals(10000000, testAccount.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(12000000, testAccount.getTotalBalance().getValore());
    }

    @Test
    public void testValidValidatePIN() {
        assertEquals(true, testAccount.validatePIN(54321));
    }

    @Test
    public void testInvalidValidatePIN() {
        assertEquals(false, testAccount.validatePIN(5432));
    }


    @Test
    public void testValidCredit() {
        Euro amount = new Euro(1000);
        testAccount.credit(amount);
        assertEquals(12100000, testAccount.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Euro amount = new Euro(1000);
        testAccount.debit(amount);
        assertEquals(11900000, testAccount.getTotalBalance().getValore());

    }
}