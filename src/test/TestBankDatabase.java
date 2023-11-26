package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Database.BankDatabase;
import code.Database.Euro;


public class TestBankDatabase {

    BankDatabase database;

    @Before
    public void setUp() {
        database = new BankDatabase();
    }


    // Tests for authenticateUser //

    @Test
    public void authenticateUserTest1() {
        assertTrue(database.authenticateUser(12345, 54321));
    }

    @Test
    public void authenticateUserTest2() {
        assertTrue(database.authenticateUser(98765, 56789));
    }

    @Test
    public void authenticateUserFailureTest() {
        assertFalse(database.authenticateUser(12712, 19922));
    }

    // Tests for getAvailableBalance //

    @Test
    public void getAvailableBalanceTest1() {
        assertEquals(100000, database.getAvailableBalance(12345).getValore());
    }

    @Test
    public void getAvailableBalanceTest2() {
        assertEquals(20000, database.getAvailableBalance(98765).getValore());
    }

    @Test
    public void getAvailableBalanceFailureTest() {
        assertThrows(java.lang.NullPointerException.class, () ->
            database.getAvailableBalance(123213).getValore());
    }


    // Tests for getTotalBalance //

    @Test
    public void getTotalBalanceTest1() {
        assertEquals(120000, database.getTotalBalance(12345).getValore());
    }

    @Test
    public void getTotalBalanceTest2() {
        assertEquals(20000, database.getTotalBalance(98765).getValore());
    }

    @Test
    public void getTotalBalanceFailureTest() {
        assertThrows(java.lang.NullPointerException.class, () ->
            database.getTotalBalance(123213).getValore());
    }


    // Tests for credit //

    @Test
    public void creditTest1() {
        Euro initialBalance = database.getTotalBalance(12345);
        database.credit(12345, new Euro(200));
        assertTrue(initialBalance.somma(new Euro(200)).ugualeA(database.getTotalBalance(12345)));
    }

    @Test
    public void creditTest2() {
        Euro initialBalance = database.getTotalBalance(98765);
        database.credit(98765, new Euro(500));
        assertTrue(initialBalance.somma(new Euro(500)).ugualeA(database.getTotalBalance(98765)));
    }

    // Ci aspettiamo che il saldo totale aumenti se l'importo da accreditare è negativo
    @Test
    public void creditFailureTest() {
        Euro initialBalance = database.getTotalBalance(12345);
        database.credit(12345, new Euro(-200));
        assertTrue(initialBalance.sottrai(new Euro(200)).ugualeA(database.getTotalBalance(12345)));
    }

    // Tests for debit //

    @Test
    public void debitTest1() {
        Euro initialBalance = database.getAvailableBalance(12345);
        database.debit(12345, new Euro(200));
        assertTrue(initialBalance.sottrai(new Euro(200)).ugualeA(database.getAvailableBalance(12345)));
    }

    @Test
    public void debitTest2() {
        Euro initialBalance = database.getAvailableBalance(98765);
        database.debit(98765, new Euro(500));
        assertTrue(initialBalance.sottrai(new Euro(500)).ugualeA(database.getAvailableBalance(98765)));
    }

    // Ci aspettiamo che il saldo disponibile aumenti se l'importo da addebitare è negativo
    @Test
    public void debitFailureTest() {
        Euro initialBalance = database.getAvailableBalance(12345);
        database.debit(12345, new Euro(-200));
        assertTrue(initialBalance.somma(new Euro(200)).ugualeA(database.getAvailableBalance(12345)));
    }
}