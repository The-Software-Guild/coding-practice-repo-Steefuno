/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.ui;

/**
 * 
 * @author Steven
 */
public class View {
    final private UI ui;
    
    /**
     * Constructs a new View given the ui
     * @param ui the ui that handles the interactions
     */
    public View(UI ui) {
        this.ui = ui;
    }
    
    /**
     * Displays a message for the user
     * @param message the message to display
     */
    public void say(String message) {
        ui.say(message);
    }
    
    /**
     * Prompts the user to enter a string
     * @param message the message to display
     * @return string entered by the user
     */
    public String promptString(String message) {
        String response;
        
        do {
            try {
                ui.say(message);
                response = ui.readString();
            } catch (Exception e) {
                continue;
            }
            break;
        } while (true);
        
        return response;
    }
    
    /**
     * Prompts the user to enter a natural number, positive integer including 0
     * @param message the message to display
     * @return the int entered by the user
     */
    public int promptNaturalNumber(String message) {
        int response;
        
        do {
            try {
                ui.say(message);
                response = ui.readInt();
                
                if (response < 0) {
                    continue;
                }
            } catch (Exception e) {
                continue;
            }
            break;
        } while (true);
        
        return response;
    }
}
