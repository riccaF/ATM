import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import code.Database.BankDatabase;
import code.Business_logic.Euro;

public class BankDatabaseTest {
    Euro amount;
    BankDatabase d;
    
    
    @Before
    public void setUp() { 
        d = new BankDatabase();
        amount = new Euro(500);       
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue(d.authenticateUser(98765, 56789));
        //pin non corretto
        assertFalse(d.authenticateUser(12345, 92382137));
    }

    @Test
    public void testCredit() {
        d.credit( 12345, amount);
        assertEquals(1700*100, d.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        d.debit(12345, new Euro(200.0));
        assertEquals(1000*100, d.getTotalBalance(12345).getValore());
        assertEquals(800*100, d.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(1000*100, d.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(1200*100, d.getTotalBalance(12345).getValore());
    }
}