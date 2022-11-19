package test;

import static org.junit.Assert.*;
import org.junit.*;

import code.Business_logic.Euro;
import code.Database.Account;
import code.Database.BankDatabase;

public class TestBankDatabase {

    private BankDatabase bankdatabase;
    private Account accounts[] = new Account[1];

    @Before
    public void init() {
        bankdatabase = new BankDatabase();
        accounts[0] = new Account(12345, 54321, new Euro(1000.0), new Euro(1200.0));
    }

    @After
    public void clear() {
        accounts = null;
        bankdatabase = null;
        assertNull(accounts);
        assertNull(bankdatabase);
    }

    @Test
    public void testInvalidAuthenticateUser() {
        assertFalse(bankdatabase.authenticateUser(12345, 76532));
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue(bankdatabase.authenticateUser(12345, 54321));
    }

    @Test
    public void testCredit() {
        Euro euro = new Euro(200.0);
        bankdatabase.credit(12345, euro);
        long totalBalance = 1400 * 100;
        assertEquals(bankdatabase.getTotalBalance(12345).getValore(), totalBalance);
    }

    @Test
    public void testDebit() {
        Euro euro = new Euro(200.0);
        bankdatabase.debit(12345, euro);
        long availableBalance = 800 * 100;
        long totalBalance = 1000 * 100;
        assertEquals(bankdatabase.getAvailableBalance(12345).getValore(), availableBalance);
        assertEquals(bankdatabase.getTotalBalance(12345).getValore(), totalBalance);
    }
}
