package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.*;
import code.Database.BankDatabase;
import code.Business_logic.Euro;

public class TestBankDatabase {
    private BankDatabase element;
    private Euro amount;

    @Before
    public void setup() {
        element = new BankDatabase();
        amount = new Euro(1000);
    }

    @Test
    public void Test_authenticateUser_true(){
        assertTrue(element.authenticateUser(12345, 54321));
    }

    @Test
    public void Test_authenticateUser_wrongPin(){
        assertFalse(element.authenticateUser(12345, 130));
    }

    @Test
    public void Test_authenticateUser_wrongUser(){
        assertFalse(element.authenticateUser(67890, 54321));
    }

    @Test
    public void Test_getAvaiableBalance_existentAccount(){
        int expectedAvaiableBalance = 1000;
        assertEquals(expectedAvaiableBalance, (int)(element.getAvailableBalance(12345).getValoreD()));
    }
    @Test
    public void Test_getAvaiableBalance_nonExistentAccount(){
        assertThrows(NullPointerException.class, ()->{
            element.getAvailableBalance(-1);
        });
    }

    @Test
    public void Test_getTotalBalance_existentAccount(){
        int expectedTotalBalance = 1200;
        assertEquals(expectedTotalBalance, (int)(element.getTotalBalance(12345).getValoreD()));
    }

    @Test
    public void Test_getTotalBalance_nonExistentAccount(){
        assertThrows(NullPointerException.class, ()->{
            element.getTotalBalance(-1);
        });
    }

    @Test
    public void Test_credit(){
        element.credit(12345,amount);
        assertEquals(2200, (int)element.getTotalBalance(12345).getValoreD());
    }

    @Test
    public void Test_deposit(){
        element.debit(12345, amount);
        assertEquals(200, (int)element.getTotalBalance(12345).getValoreD());
    }
}