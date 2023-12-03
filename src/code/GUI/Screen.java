package code.GUI;
import code.Business_logic.Euro;
// Screen.java
// Represents the screen of the ATM

public class Screen
{
   // displays a message without a carriage return
   public void displayMessage( String message ) 
   {
      System.out.print( message ); 
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine( String message ) 
   {
      System.out.println( message );   
   } // end method displayMessageLine

   // display a dollar amount
   public void displayEuroAmount( Euro amount )
   {
      System.out.printf( "$%,.2f", amount.getValore()/100.0 );
   } // end method displayEuroAmount 
} // end class Screen

/*In questo modo, il metodo displayEuroAmount accetta un oggetto di tipo Euro e lo formatta 
correttamente per essere visualizzato sulla schermata dell'ATM. L'importo viene diviso per 100.0
 perché la rappresentazione interna di Euro è in centesimi.*/





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