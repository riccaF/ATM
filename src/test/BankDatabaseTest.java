package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import code.Database.BankDatabase;
import code.GUI.Euro;

public class BankDatabaseTest {

    private BankDatabase bankDatabase;

    @BeforeEach
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void authenticateUser_CorrectCredentials_ShouldReturnTrue() {
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
    }

    @Test
    public void authenticateUser_IncorrectCredentials_ShouldReturnFalse() {
        assertFalse(bankDatabase.authenticateUser(12345, 9999));
    }

    @Test
    public void getAvailableBalance_ValidAccountNumber_ShouldReturnBalance() {
        assertEquals(new Euro(1000.0).getValore(), bankDatabase.getAvailableBalance(12345).getValore());
    }

    @Test
    public void getTotalBalance_ValidAccountNumber_ShouldReturnBalance() {
        assertEquals(new Euro(1200.0).getValore(), bankDatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void credit_ValidAccountNumber_ShouldUpdateBalance() {
        Euro initialBalance = bankDatabase.getTotalBalance(12345);
        Euro amountToCredit = new Euro(100.0);

        bankDatabase.credit(12345, amountToCredit);

        Euro newBalance = bankDatabase.getTotalBalance(12345);
        assertEquals(initialBalance.somma(amountToCredit), newBalance);
    }

    @Test
    public void debit_ValidAccountNumberWithSufficientFunds_ShouldUpdateBalance() {
        Euro initialBalance = bankDatabase.getTotalBalance(12345);
        Euro amountToDebit = new Euro(100.0);

        bankDatabase.debit(12345, amountToDebit);

        Euro newBalance = bankDatabase.getTotalBalance(12345);
        assertEquals(initialBalance.sottrai(amountToDebit), newBalance);
    }

    @Test
    public void debit_ValidAccountNumberWithInsufficientFunds_ShouldNotUpdateBalance() {
        Euro initialBalance = bankDatabase.getTotalBalance(12345);
        Euro amountToDebit = new Euro(1500.0); // Assuming the initial balance is 1200.0

        bankDatabase.debit(12345, amountToDebit);

        Euro newBalance = bankDatabase.getTotalBalance(12345);
        assertEquals(initialBalance, newBalance);
    }
}
