package test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Business_logic.Account;
import Business_logic.Euro;

public class TestAccount {
    Account Account_0;
    Account Account_1;
    Account Account_2;
    Euro euro;

    @Before
    public void setUp() {
        Account_0 = new Account(0, 20,new Euro(1000), new Euro(1100));
        Account_1 = new Account(1, 21,new Euro(2000), new Euro(1200));
        Account_2 = new Account(2, 22,new Euro(3000), new Euro(1300));
        euro = new Euro(1000);
    }
    @Test
    public void testCredit() {
        Account_0.credit(euro);
        assertEquals(210000, Account_0.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Account_1.debit(euro);
        assertEquals(100000, Account_1.getAvailableBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(0, Account_0.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(300000, Account_2.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(130000, Account_2.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN() {
        assertTrue("ValidatePIN failed!", Account_2.validatePIN(22));
    }
}
