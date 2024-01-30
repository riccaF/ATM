package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Account;
import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class TestBankDatabase {
    
    BankDatabase Bank0;

    Account Account1;
    Account Account2;

    Euro Euro0;

    @Before
    public void setup() {
        Bank0       = new BankDatabase();

        Account1    = new Account( 12345, 54321, new Euro(1000,0), new Euro(1200,0) );
        Account2    = new Account( 98765, 56789, new Euro(200,0), new Euro(200,0) ); 

        Euro0       = new Euro(500);
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue(Bank0.authenticateUser(12345, 54321));
        assertFalse(Bank0.authenticateUser(12345, 12345));

        assertTrue(Bank0.authenticateUser(Account1.getAccountNumber(), 54321));
        assertFalse(Bank0.authenticateUser(Account1.getAccountNumber(), 12345));

        assertTrue(Bank0.authenticateUser(98765, 56789));
        assertFalse(Bank0.authenticateUser(98765, 98765));

        assertTrue(Bank0.authenticateUser(Account2.getAccountNumber(), 56789));
        assertFalse(Bank0.authenticateUser(Account2.getAccountNumber(), 98765));
    }

    @Test
    public void testCredit() {
        Bank0.credit(98765, Euro0);
        assertEquals(70000, Bank0.getTotalBalance(98765).getValore());

        Bank0.credit(Account1.getAccountNumber(), Euro0);
        assertEquals(170000, Bank0.getTotalBalance(Account1.getAccountNumber()).getValore());
    }

    @Test
    public void testDebit() {
        Bank0.debit(12345, Euro0);
        assertEquals(50000, Bank0.getAvailableBalance(12345).getValore());
        assertEquals(70000, Bank0.getTotalBalance(12345).getValore());

        Bank0.debit(Account2.getAccountNumber(), Euro0);
        assertEquals(-30000, Bank0.getAvailableBalance(Account2.getAccountNumber()).getValore());
        assertEquals(-30000, Bank0.getTotalBalance(Account2.getAccountNumber()).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, Bank0.getAvailableBalance(12345).getValore());
        assertEquals(20000, Bank0.getAvailableBalance(Account2.getAccountNumber()).getValore());
        
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000, Bank0.getTotalBalance(Account1.getAccountNumber()).getValore());
        assertEquals(20000, Bank0.getTotalBalance(98765).getValore());
    }
    
}
