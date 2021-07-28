/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 28 Jul 2021
 */
package com.mthree.statecapitals2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class StateCapitals2 {
    final static String FILEPATH = "./StateCapitals.txt";
    
    public static void main(String[] args) {
        HashMap<String, String> capitals;
        Random rand;
        Object[] states;
        int randomStateID;
        String state, capital, guess;
        Scanner inputReader;
        
        // Build the hashmap
        capitals = buildHashMap();
        states = capitals.keySet().toArray();
        
        // Get a random state and capital pair
        rand = new Random();
        randomStateID = rand.nextInt(states.length);
        state = (String)states[randomStateID];
        capital = capitals.get(state);
        
        // Prompt to guess capital given state
        inputReader = new Scanner(System.in);
        System.out.println("\nREADY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF '" + state + "'?");
        guess = inputReader.nextLine().toLowerCase();
        
        // Check if correct
        if (guess.equals(capital.toLowerCase())) {
            System.out.println("NICE! " + capital + " IS CORRECT!");
        } else {
            System.out.println("NOPE! IT'S " + capital + "!");
        }
    }
    
    /**
     * Generates the HashMap with state/capital pairs for each US state
     */
    private static HashMap<String, String> buildHashMap() {
        HashMap<String, String> capitals;
        Scanner fileReader;
        String states;
        
        capitals = new HashMap<>();
        
        // Load the file
        try {
            fileReader = new Scanner(
                new BufferedReader(
                    new FileReader(FILEPATH)
                )
            );
        } catch(FileNotFoundException ex) {
            System.out.println(FILEPATH + " not found");
            System.exit(-1);
            return null;
        }
        
        // Unmarchal the data
        System.out.println("=====\nHERE ARE THE STATES:");
        states = "";
        while (fileReader.hasNextLine()) {
            String currentLine, state, capital;
            String[] data;
            
            currentLine = fileReader.nextLine();
            data = currentLine.split("::");
            if (data.length != 2) {
                System.out.println("Invalid file format");
                System.exit(-1);
                return null;
            }
            
            state = data[0];
            capital = data[1];
            capitals.put(state, capital);
            states += state + " ";
        }
        System.out.println(states);
        
        return capitals;
    }
}
