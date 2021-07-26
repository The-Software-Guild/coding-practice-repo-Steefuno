/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class FieldDay {
    
    public static void main(String[] args) {
        String name, team;
    
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What is your name?: ");
        name = inputReader.nextLine();
        
        if (name.compareTo("Baggins") < 0) {
            team = "Red Dragons";
        } else if (name.compareTo("Dresden") < 0) {
            team = "Dark Wizards";
        } else if (name.compareTo("Howl") < 0) {
            team = "Moving Castles";
        } else if (name.compareTo("Potter") < 0) {
            team = "Golden Snitches";
        } else if (name.compareTo("Vimes") < 0) {
            team = "Night Guards";
        } else {
            team = "Black Holes";
        }
        
        System.out.println("You're on team \"" + team + "\"!");
        System.out.println("Good luck!");
    }
}
