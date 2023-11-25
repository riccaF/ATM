package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import code.GUI.Account;
import code.GUI.Euro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        // Set up an account with initial balances
        Euro initialAvailableBalance = new Euro(100, 0);
        Euro initialTotalBalance = new Euro(150, 0);
        account = new Account(123456, 1234, initialAvailableBalance, initialTotalBalance);
    }

    @Test
    public void validatePIN_CorrectPIN_ShouldReturnTrue() {
        assertTrue(account.validatePIN(1234));
    } // pin corretto

    @Test
    public void validatePIN_IncorrectPIN_ShouldReturnFalse() {
        assertFalse(account.validatePIN(5678));
    } // pin errato

    @Test
    public void getAvailableBalance_ShouldReturnCorrectBalance() {
        Euro balance = account.getAvailableBalance();
        assertEquals(new Euro(100, 0).getValore(), balance.getValore());
    } // saldo totale

    @Test
    public void getTotalBalance_ShouldReturnCorrectBalance() {
        Euro balance = account.getTotalBalance();
        assertEquals(new Euro(150, 0).getValore(), balance.getValore());
    } // saldo disponibile

    @Test
    public void credit_AddAmountToTotalBalance() {
        Euro amountToCredit = new Euro(50, 0);
        account.credit(amountToCredit);

        Euro expectedTotalBalance = new Euro(200, 0);
        assertEquals(expectedTotalBalance.getValore(), account.getTotalBalance().getValore());
    } // aggiunguiamo soldi al conto, dovrebbe essere 200

    @ParameterizedTest
    @CsvSource({ "30, 70, 120" })
    public void debit_SubtractAmountFromBalances(int amountToDebit, int expectedAvailable, int expectedTotal) {
        account.debit(new Euro(amountToDebit, 0));

        Euro expectedAvailableBalance = new Euro(expectedAvailable, 0);
        Euro expectedTotalBalance = new Euro(expectedTotal, 0);

        assertEquals(expectedAvailableBalance.getValore(), account.getAvailableBalance().getValore());
        assertEquals(expectedTotalBalance.getValore(), account.getTotalBalance().getValore());
    }

    @Test
    public void getAccountNumber_ShouldReturnCorrectAccountNumber() {
        assertEquals(123456, account.getAccountNumber());
    }
}
