/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */

package com.mthree.vendingmachine.ui;

/**
 * 
 * @author Steven
 */
public interface UI {
    /**
     * Displays a message for the user
     * @param message the message to display
     */
    public void say(String message);
    
    /**
     * Reads an inputted String
     * @return the String
     */
    public String readString();
    
    /**
     * Reads an inputted int
     * @return the int
     */
    public int readInt();
}
