/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.ui;

import java.util.Scanner;

/**
 * 
 * @author Steven
 */
public class UIConsoleImplementation implements UI {
    final private Scanner inputReader;
    
    /**
     * Constructs a new UIConsoleImplementation
     */
    public UIConsoleImplementation() {
        inputReader = new Scanner(System.in);
    }
    
    /**
     * Displays a message for the user
     * @param message the message to display
     */
    public void say(String message) {
        System.out.println(message);
    }
    
    /**
     * Reads an inputted String
     * @return the String
     */
    public String readString() {
        String input;
        
        input = inputReader.nextLine();
        return input;
    }
    
    /**
     * Reads an inputted int
     * @return the int
     */
    public int readInt() throws NumberFormatException {
        String input;
        int result;
        
        input = inputReader.nextLine();
        result = Integer.parseInt(input);
        return result;
    }
}
