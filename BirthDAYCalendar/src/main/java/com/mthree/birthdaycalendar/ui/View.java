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
public class View {
    final private UI ui;
    
    /**
     * Constructs a new View given the UI
     * @param ui the UI to use in this view
     */
    public View(UI ui) {
        this.ui = ui;
    }
    
    /**
     * Displays a String, then requests a String from the user
     * @param message the String to display to the user
     * @return the String the user inputted
     */
    public String promptString(String message) {
        String response;
        
        response = null;
        do {
            try {
                ui.say(message);
                response = ui.readString();
            } catch(Exception e) {
                continue;
            }
        } while (response == null);
        
        return response;
    }
    
    /**
     * Displays a string
     * @param message the String to display to the user
     */
    public void say(String message) {
        ui.say(message);
    }
}
