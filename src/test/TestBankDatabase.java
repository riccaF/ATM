package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Database.BankDatabase;
import code.Database.Euro;
import code.Database.Account;

public class TestBankDatabase {

    BankDatabase database;
    Account acc1;
    Account acc2;
    

    @Before
    public void setUp() {
        database = new BankDatabase();
    }

    // Tests for getAccount //

    @Test
    public void getAccountOKTest1() {
        acc1 = new Account(12345,54321, new Euro(1000.0), new Euro(1200.0));
        assertEquals(acc1.getAccountNumber(), database.getAccount(12345).getAccountNumber());
    }

    @Test
    public void getAccountOKTest2() {
        acc2 = new Account(98765,56789, new Euro(500.0), new Euro(520.0));
        assertEquals(acc2.getAccountNumber(), database.getAccount(98765).getAccountNumber());
    }

    @Test
    public void getAccountFAILURETest() {
        assertThrows(java.lang.NullPointerException.class, () ->
            database.getAccount(123213).getAccountNumber());
    }


    // Tests for authenticateUser //

    @Test
    public void authenticateUserOKTest1() {
        assertTrue(database.authenticateUser(12345, 54321));
    }

    @Test
    public void authenticateUserOKTest2() {
        assertTrue(database.authenticateUser(98765, 56789));
    }

    @Test
    public void authenticateUserFAILURETest() {
        assertFalse(database.authenticateUser(12712, 19922));
    }

    // Tests for getAvailableBalance //

    @Test
    public void getAvailableBalanceOKTest1() {
        assertEquals(100000, database.getAvailableBalance(12345).getValore());
    }

    @Test
    public void getAvailableBalanceOKTest2() {
        assertEquals(20000, database.getAvailableBalance(98765).getValore());
    }

    @Test
    public void getAvailableBalanceFAILURETest() {
        assertThrows(java.lang.NullPointerException.class, () ->
            database.getAvailableBalance(123213).getValore());
    }


    // Tests for getTotalBalance //

    @Test
    public void getTotalBalanceOKTest1() {
        assertEquals(120000, database.getTotalBalance(12345).getValore());
    }

    @Test
    public void getTotalBalanceOKTest2() {
        assertEquals(20000, database.getTotalBalance(98765).getValore());
    }

    @Test
    public void getTotalBalanceFAILURETest() {
        assertThrows(java.lang.NullPointerException.class, () ->
            database.getTotalBalance(123213).getValore());
    }


    // Tests for credit //

    @Test
    public void creditOKTest1() {
        Euro initialBalance = database.getTotalBalance(12345);
        database.credit(12345, new Euro(200));
        assertTrue(initialBalance.somma(new Euro(200)).ugualeA(database.getTotalBalance(12345)));
    }

    @Test
    public void creditOKTest2() {
        Euro initialBalance = database.getTotalBalance(98765);
        database.credit(98765, new Euro(500));
        assertTrue(initialBalance.somma(new Euro(500)).ugualeA(database.getTotalBalance(98765)));
    }

    // Ci aspettiamo che il saldo totale aumenti se l'importo da accreditare è negativo
    @Test
    public void creditFAILURETest() {
        Euro initialBalance = database.getTotalBalance(12345);
        database.credit(12345, new Euro(-200));
        assertTrue(initialBalance.sottrai(new Euro(200)).ugualeA(database.getTotalBalance(12345)));
    }

    // Tests for debit //

    @Test
    public void debitOKTest1() {
        Euro initialBalance = database.getAvailableBalance(12345);
        database.debit(12345, new Euro(200));
        assertTrue(initialBalance.sottrai(new Euro(200)).ugualeA(database.getAvailableBalance(12345)));
    }

    @Test
    public void debitOKTest2() {
        Euro initialBalance = database.getAvailableBalance(98765);
        database.debit(98765, new Euro(500));
        assertTrue(initialBalance.sottrai(new Euro(500)).ugualeA(database.getAvailableBalance(98765)));
    }

    // Ci aspettiamo che il saldo disponibile aumenti se l'importo da addebitare è negativo
    @Test
    public void debitFAILURETest() {
        Euro initialBalance = database.getAvailableBalance(12345);
        database.debit(12345, new Euro(-200));
        assertTrue(initialBalance.somma(new Euro(200)).ugualeA(database.getAvailableBalance(12345)));
    }
}