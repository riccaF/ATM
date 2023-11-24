package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import code.Database.*;
import code.Business_Logic.*;
import code.Business_Logic.Keypad;
import code.GUI.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestATM {
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        ATM theATM = new ATM();    
        theATM.run();

        // det up System.in to provide input to the Keypad.
        String input = "12345\n54321\n"; // User enters account number and PIN
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // set up System.out to capture output from the Screen.
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void ViewBalance() {
        String input = "1"; // option to view balance
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals();
    }

    @Test
    public void Withdraw() {
        String input = "2"; // option to withdraw
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        input = "1"; // withdraw 20 dollars;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals();
    }

    @Test
    public void Deposit() {
        String input = "3"; // option to deposit
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        input = "100"; // withdraw 1 dollar;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals();
    }
}