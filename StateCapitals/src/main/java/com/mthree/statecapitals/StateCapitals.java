/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 28 Jul 2021
 */
package com.mthree.statecapitals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Steven
 */
public class StateCapitals {
    public static void main(String[] args) {
        HashMap<String, String> capitals;
        Set<String> states;
        Iterator iterator;
        
        capitals = buildHashMap();
        
        states = capitals.keySet();
        
        System.out.println("STATES:\n=======");
        /*
        iterator = states.iterator();
        while (iterator.hasNext()) {
            String state = iterator.next();
            System.out.println(state);
        }
        */
        for (var state : states) {
            System.out.println(state);
        }
        
        System.out.println("\nCAPITALS:\n=========");
        for (var state : states) {
            String capital;
            
            capital = capitals.get(state);
            System.out.println(capital);
        }
        
        System.out.println("\nSTATE/CAPITAL PAIRS:\n====================");
        for (var state : states) {
            String capital;
            
            capital = capitals.get(state);
            System.out.println(state + " - " + capital);
        }
    }
    
    /**
     * Generates the HashMap with state/capital pairs for each US state
     */
    private static HashMap<String, String> buildHashMap() {
        HashMap<String, String> capitals;
                
        capitals = new HashMap<>();
        capitals.put("Alabama", "Montgomery");
        capitals.put("Alaska", "Juneau");
        capitals.put("Arizona", "Phoenix");
        capitals.put("Arkansas", "Little Rock");
        capitals.put("New Jersey", "Trenton");
        
        return capitals;
    }
}
