package test.Database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import code.Database.BankDatabase;
import code.Business_Logic.Euro;

public class BankDatabaseTest {

    BankDatabase testBankDatabase;

    @Before 
    public void setUp(){ testBankDatabase = new BankDatabase(); }
    
    @Test
    public void testAuthenticateUser() {
        assertTrue(testBankDatabase.authenticateUser(12345, 54321));
        assertFalse(testBankDatabase.authenticateUser(11111, 33333));
    }

    @Test
    public void testCredit() {
        testBankDatabase.credit(12345, new Euro(100));
        assertEquals(130000, testBankDatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        testBankDatabase.debit(12345, new Euro(100));
        assertEquals(110000, testBankDatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() { assertEquals(100000, testBankDatabase.getAvailableBalance(12345).getValore()); }

    @Test
    public void testGetTotalBalance() { assertEquals(120000, testBankDatabase.getTotalBalance(12345).getValore()); }
}
