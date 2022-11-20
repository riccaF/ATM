package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Database.BankDatabase;
import code.Business_Logic.Euro;

public class TestBankDatabase {
    
    BankDatabase bankDB;
    
    @BeforeEach
    public void setUp(){
        bankDB = new BankDatabase();
    }
    
    @Test
    void testAuthenticateUser() {
        assertTrue(bankDB.authenticateUser(12345, 54321));
        assertFalse(bankDB.authenticateUser(54321, 54321));
    }

    @Test
    void testCredit() {
        bankDB.credit(12345, new Euro(1000));
        assertEquals(220000, bankDB.getTotalBalance(12345).getValore());
    }

    @Test
    void testDebit() {
        bankDB.debit(12345, new Euro(1000));
        assertEquals(20000, bankDB.getTotalBalance(12345).getValore());
    }

    @Test
    void testGetAvailableBalance() {
        assertEquals(100000, bankDB.getAvailableBalance(12345).getValore());
    }

    @Test
    void testGetTotalBalance() {
        assertEquals(120000, bankDB.getTotalBalance(12345).getValore());
    }
}
