/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */

package com.mthree.birthdaycalendar.ui;

/**
 * 
 * @author Steven
 */
public interface UI {
    /**
     * Displays a string
     * @param message the String to display to the user
     */
    public void say(String message);
    
    /**
     * Requests a String from the user
     * @return the String inputted by the user
     */
    public String readString();
}
