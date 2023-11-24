package test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import code.Business_logic.Euro;
import code.Database.Account;
import code.Database.BankDatabase;

public class TestBankDatabase {

    private Account accounts[];
    private BankDatabase bankDatabase;

    @Before
    public void setUp(){
        accounts = new Account[ 2 ]; // just 2 accounts for testing
        accounts[ 0 ] = new Account( 12345, 54321, new Euro(1000.0), new Euro(1200.0));
        accounts[ 1 ] = new Account( 98765, 56789, new Euro(200.0), new Euro(200.0));
        bankDatabase = new BankDatabase();
    }

    @After
    public void tearDown(){
        accounts = null;
        bankDatabase = null;
    }

    @Test
    public void testBankDatabaseAuthenticateUserSuccess(){
        assertTrue(bankDatabase.authenticateUser(accounts[0].getAccountNumber(), 54321));
        assertTrue(bankDatabase.authenticateUser(accounts[1].getAccountNumber(), 56789));
    }

    @Test
    public void testBankDatabaseAuthenticateUserFailure(){
        assertFalse(bankDatabase.authenticateUser(accounts[0].getAccountNumber(), 6666));
        assertFalse(bankDatabase.authenticateUser(accounts[1].getAccountNumber(), 6666));
    }

    @Test
    public void testBankDatabaseGetAvailableBalance(){
        assertEquals(accounts[0].getAvailableBalance().getValore(), bankDatabase.getAvailableBalance(accounts[0].getAccountNumber()).getValore());
        assertEquals(accounts[1].getAvailableBalance().getValore(), bankDatabase.getAvailableBalance(accounts[1].getAccountNumber()).getValore());
    }

    @Test
    public void testBankDatabaseGetTotalBalance(){
        assertEquals(accounts[0].getTotalBalance().getValore(), bankDatabase.getTotalBalance(accounts[0].getAccountNumber()).getValore());
        assertEquals(accounts[1].getTotalBalance().getValore(), bankDatabase.getTotalBalance(accounts[1].getAccountNumber()).getValore());
    }

    @Test
    public void testBankDatabaseCredit(){
        Euro creditAmount = new Euro(50, 0);
        bankDatabase.credit(accounts[0].getAccountNumber(), creditAmount);
        assertEquals(new Euro(1250, 0).getValore(), bankDatabase.getTotalBalance(accounts[0].getAccountNumber()).getValore());
    }

    @Test
    public void testBankDatabaseDebit(){
        Euro debitAmount = new Euro(50, 0);
        bankDatabase.debit(accounts[0].getAccountNumber(), debitAmount);
        assertEquals(new Euro(950, 0).getValore(), bankDatabase.getAvailableBalance(accounts[0].getAccountNumber()).getValore());
        assertEquals(new Euro(1150, 0).getValore(), bankDatabase.getTotalBalance(accounts[0].getAccountNumber()).getValore());
    }
}