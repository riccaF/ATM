package Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

import code.Database.Account;
import code.Business_logic.Euro;

public class TestAccount{
   
    private Account account1;

    @Before
    public void setUp(){
        // Inizializza gli oggetti Account prima di ogni test
        account1 = new Account(12345, 54321, new Euro(1000), new Euro(1200));
    }

    @After
    public void cleanUp(){
        account1 = null;
    }

    @Test
    public void testConstructor(){
        assertEquals(12345, account1.getAccountNumber());
        assertEquals(100000, account1.getAvailableBalance().getValore());
        assertEquals(120000, account1.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN(){
        assertTrue(account1.validatePIN(54321));
        assertFalse(account1.validatePIN(00000));
    }

    @Test
    public void testCredit(){
        account1.credit(new Euro(500));
        assertEquals(170000, account1.getTotalBalance().getValore());
    }

    @Test
    public void testDebit(){
        account1.debit(new Euro(500));
        assertEquals(50000, account1.getAvailableBalance().getValore());
        assertEquals(70000, account1.getTotalBalance().getValore());
    }
}
