package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;
import code.Database.Account;

public class TestAccount{

    private Account account;

    @Before
    public void setUp(){
        // Inizializza l'oggetto Euro prima di ogni test
        account = new Account(5678, 8765, new Euro(5000, 0),  new Euro(5000, 0));
    }

    @Test
    public void testAccount(){
        // Verifica che l'oggetto Euro sia stato inizializzato correttamente
        assertEquals(5678, account.getAccountNumber());
        assertTrue(account.validatePIN(8765));
        assertEquals(500000, account.getAvailableBalance().getValore());
        assertEquals(500000, account.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN(){
        // Verifica che il metodo validatePIN() restituisca true se il PIN è
        // corretto
        assertTrue(account.validatePIN(8765));
        // Verifica che il metodo validatePIN() restituisca false se il PIN è
        // errato
        assertFalse(account.validatePIN(9876));
        assertFalse(account.validatePIN(98765));
        assertFalse(account.validatePIN(1));
    }
    
    @Test
    public void testGetAvailableBalance(){
        // Verifica che il metodo getAvailableBalance() restituisca il saldo disponibile
        assertEquals(500000, account.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance(){
        // Verifica che il metodo getTotalBalance() restituisca il saldo totale
        assertEquals(500000, account.getTotalBalance().getValore());
    }

    @Test
    public void testCredit(){
        // Verifica che il metodo credit() aggiunga il saldo al totale
        account.credit(new Euro(100, 0));
        assertEquals(510000, account.getTotalBalance().getValore());
        // Ci si aspetta fallisca.
        assertEquals(500000, account.getAvailableBalance().getValore());
    }

    @Test
    public void testDebit(){
        account.debit(new Euro(100, 0));
        assertEquals(490000, account.getTotalBalance().getValore());
        // Ci si aspetta fallisca.
        assertEquals(490000, account.getAvailableBalance().getValore());
    }

    @Test
    public void testGetAccountNumber(){
        // Verifica che il metodo getAccountNumber() restituisca true 
        // se il numero dell'account è corretto
        assertEquals(5678, account.getAccountNumber());
        // Verifica che il metodo getAccountNumber() restituisca false
        // se il numero dell'account è errato
        assertNotEquals(568, account.getAccountNumber());
        assertNotEquals(5688, account.getAccountNumber());
        assertNotEquals(8, account.getAccountNumber());
    }
}