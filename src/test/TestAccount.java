package test;
import static org.junit.Assert.*;
import org.junit.*;

import code.Business_logic.Account;
import code.Business_logic.Euro;
/*   
 * Questo file contiene i test della classe Account, i test dei costruttori (ne abbiamo aggiunto uno parallelo con il tipo Euro)
 * sono stati divisi in modo che venisse valutato ogni parametro richiesto dal costruttore.
 * Infine sono stati fatti i test dei due metodi pubblici principali, credit e deposit.
*/


public class TestAccount {
    //i test valgono anche per il Constructor B1, B2, B3, B4
    @Test //controllo dell'account number
    public void testConstructorA1(){
        Account user= new Account(000001, 1234, 100.0, 100.0);
        assertEquals(000001, user.getAccountNumber());
    
    }
    @Test //controllo avaiable balance
    public void testConstructorA3(){
        Account user= new Account(000001, 1234, 100.0, 100.0);
        assertEquals(100.0, user.getAvailableBalance().getValoreD(),0.01);
    }
    @Test //controllo total balance
    public void testConstructorA4(){
        Account user= new Account(000001, 1234, 100.0, 100.0);
        assertEquals(100.0, user.getTotalBalance().getValoreD(),0.01);
    }
    //---------------
    @Test //controllo funzione credit
    public void TestCredit(){
        Account account = new Account(0001, 1234, 100.0, 100.0);
        Euro amount = new Euro(50, 25);
        account.credit(amount);
        Euro totalBalance = account.getTotalBalance();
        assertEquals(150.25, totalBalance.getValoreD(), 0.01);
    }
    
    @Test //controllo funzione debit
    public void testDebit() {
        Account account = new Account(0001, 1234, 100.0, 100.0);
        Euro amount = new Euro(50, 25);
        account.debit(amount);
        Euro totalBalance = account.getTotalBalance();
        assertEquals(49.75, totalBalance.getValoreD(), 0.01);
    }
}