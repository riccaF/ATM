package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Buisness_logic.Euro;
import code.Database.BankDatabase;

public class BankDatabaseTest {
    @Test
    public void testAuthenticateUser() {
        BankDatabase user = new BankDatabase();
        assertEquals(true, user.authenticateUser(12345, 54321));
    }

    @Test
    public void testDebit() {
        BankDatabase database = new BankDatabase();
        database.debit(12345, new Euro(500.0));
        assertEquals(70000, database.getTotalBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        BankDatabase database = new BankDatabase();
        assertEquals(100000, database.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        BankDatabase database = new BankDatabase();
        assertEquals(120000, database.getTotalBalance(12345).getValore());
    }
}
