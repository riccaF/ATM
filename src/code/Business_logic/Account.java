package Business_logic;
// Account.java
// Represents a bank account

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private Euro availableBalance; // funds available for withdrawal   ; changed Double in "Euro"
   private Euro totalBalance; // funds available + pending deposits   ; changed double in "Euro"

   // Account constructor initializes attributes
   public Account( int theAccountNumber, int thePIN, 
      Euro theAvailableBalance, Euro theTotalBalance )               //Account(int,int,Euro,Euro)
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   } // end Account constructor

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // end method validatePIN
   
   // returns available balance
   public Euro getAvailableBalance()               //changed double in Euro
   {
      return availableBalance;
   } // end getAvailableBalance

   // returns the total balance
   public Euro getTotalBalance()                   //changed double in Euro
   {
      return totalBalance;
   } // end method getTotalBalance

   // credits an amount to the account
   public void credit( Euro amount )               //method credit(Euro)
   {
      totalBalance.somma(amount); // add to total balance    ;  use function .somma() from class Euro
   } // end method credit

   // debits an amount from the account
   public void debit( Euro amount )          //method debit(Euro)
   {
      availableBalance.sottrai(amount);    // subtract from available balance       ; use function .sottrai() from class Euro
      totalBalance.sottrai(amount); // subtract from total balance                 ;use function .sottrai() from class Euro
   } // end method debit

   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account


/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/