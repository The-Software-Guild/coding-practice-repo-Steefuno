/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */

package com.mthree.birthdaycalendar.ui;

import java.util.Scanner;

/**
 * 
 * @author Steven
 */
public class UIConsoleImplementation implements UI {
    final private Scanner inputReader;
    
    public UIConsoleImplementation() {
        this.inputReader = new Scanner(System.in);
    }
    
    /**
     * Displays a string
     * @param message the String to display to the user
     */
    @Override
    public void say(String message) {
        System.out.println(message);
    }
    
    /**
     * Requests a String from the user
     * @return the String inputted by the user
     */
    @Override
    public String readString() {
        String input;
        
        input = inputReader.nextLine();
        return input;
    }
}
