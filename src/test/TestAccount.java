package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import code.Business_Logic.*;
import code.Database.Account;

public class TestAccount {
   
    Account acc;
	
	@BeforeEach
	public void setUp() {
		 acc = new Account(6789,9876,new Euro(1000.0), new Euro(1500.0));	
	} 

    @Test
    void testCredit() {
        acc.credit(new Euro(1200));
		assertEquals(acc.getTotalBalance().getValore(),270000);
    }

    @Test
    void testDebit() {
        acc.debit(new Euro(500));
        assertEquals(acc.getTotalBalance().getValore(),100000);
        assertTrue(50000==acc.getAvailableBalance().getValore());
		

    }

    @Test
    void testGetAccountNumber() {
        assertEquals(acc.getAccountNumber(),6789);
        assertFalse(acc.getAccountNumber()==12345);
    }

    @Test
    void testGetAvailableBalance() {
        assertEquals(100000,acc.getAvailableBalance().getValore());
        assertFalse(acc.getAvailableBalance().getValore()==50000);
    }

    @Test
    void testGetTotalBalance() {
        assertEquals(150000,acc.getTotalBalance().getValore());
        assertTrue(acc.getTotalBalance().getValore()!=250000);
    
    }

    @Test
    void testValidatePIN() {
        assertTrue(acc.validatePIN(9876));
        assertFalse(acc.validatePIN(12345));

    }
}
