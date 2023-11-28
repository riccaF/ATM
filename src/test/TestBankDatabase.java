package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.*;
import code.Database.BankDatabase;
import code.Business_logic.Euro;

/*
 * Questo file contiene i test della classe BankDatabase, i test coinvolgono le funzioni principali,
 * i getter, l'authenticate (che viene analizzata in tutte le casistiche possibili: il caso in cui
 * l'utente ed il pin siano corretti, il caso in cui l'utente sia corretto ma il pin sbagliato ed il caso in cui
 * l'utente sia sbagliato)
 */

public class TestBankDatabase {
    private BankDatabase element;
    private Euro amount;

    @Before //setup iniziale per evitare di ripetere il codice
    public void setup() {
        element = new BankDatabase();
        amount = new Euro(1000);
    }

    @Test //primo test per authenticate, caso di utente e pin corretti
    public void Test_authenticateUser_true(){
        assertTrue(element.authenticateUser(12345, 54321));
    }

    @Test //secondo test per authenticate, caso di utente corretto e pin errato
    public void Test_authenticateUser_wrongPin(){
        assertFalse(element.authenticateUser(12345, 130));
    }

    @Test //terzo ed ultimo test di authenticate, caso di utente errato
    public void Test_authenticateUser_wrongUser(){
        assertFalse(element.authenticateUser(67890, 54321));
    }

    @Test //getter di avaible balance, caso in cui l'utente esista
    public void Test_getAvaiableBalance_existentAccount(){
        int expectedAvaiableBalance = 1000;
        assertEquals(expectedAvaiableBalance, (int)(element.getAvailableBalance(12345).getValoreD()));
    }
    @Test //getter di avaible balance, caso in cui l'utente non esista
    public void Test_getAvaiableBalance_nonExistentAccount(){
        assertThrows(NullPointerException.class, ()->{
            element.getAvailableBalance(-1);
        });
    }

    @Test //getter di total balance, caso in cui l'utente esista
    public void Test_getTotalBalance_existentAccount(){
        int expectedTotalBalance = 1200;
        assertEquals(expectedTotalBalance, (int)(element.getTotalBalance(12345).getValoreD()));
    }

    @Test //getter di total balance, caso in cui l'utente non esista
    public void Test_getTotalBalance_nonExistentAccount(){
        assertThrows(NullPointerException.class, ()->{
            element.getTotalBalance(-1);
        });
    }

    @Test //test della funzione BankDatabase.credit
    public void Test_credit(){
        element.credit(12345,amount);
        assertEquals(2200, (int)element.getTotalBalance(12345).getValoreD());
    }

    @Test //test della funzione BankDatabase.debit
    public void Test_deposit(){
        element.debit(12345, amount);
        assertEquals(200, (int)element.getTotalBalance(12345).getValoreD());
    }
}