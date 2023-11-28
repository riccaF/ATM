package test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import code.Businness_logic.*;

public class TestEuro{

    private Account account;

    @Before
    public void setUp() {
        account = new Account(123, 321, 100.00, 100.00); // Impostazioni iniziali dell'account
    }

    @Test
    public void testAccountNumber() {
        assertEquals(123, account.getAccountNumber()); // Verifica che il numero dell'account sia corretto
    }

    @Test
    public void testInitialBalanceAfterAccountCreation() {
        Euro expected = new Euro(100.0);
        assertEquals("", expected.stampa(), account.getAvailableBalance().stampa());
        assertEquals("", expected.stampa(), account.getTotalBalance().stampa());
    }

    @Test
    public void testDebitLessThanAvailableBalance() {
        Euro expected = new Euro(50.0);
        Euro operation = new Euro(50.0);
        account.debit(operation);
        assertEquals("", expected.stampa(), account.getAvailableBalance().stampa());
    }

    @Test
    public void testDebitEqualToAvailableBalance() {
        Euro operation = new Euro(100.0);
        account.debit(operation);
        assertEquals("", new Euro(0.0).stampa(), account.getAvailableBalance().stampa());
    }

    @Test
    public void testCreditPositiveAmount() {
        Euro expected = new Euro(150.0);
        Euro operation = new Euro(50.0);
        account.credit(operation);
        assertEquals("", expected.stampa(), account.getTotalBalance().stampa());
    }

    @Test
    public void testInvalidPIN() {
        assertFalse(account.validatePIN(789)); // Supponiamo che il PIN corretto sia 321
    }

    @Test
    public void testValidPIN() {
        assertTrue(account.validatePIN(321));
    }


}