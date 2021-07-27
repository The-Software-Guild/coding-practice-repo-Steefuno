/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.flowcontrol.methods;

import java.util.Random;

/**
 *
 * @author Steven
 */
public class BarelyControlledChaos {
    private static final String[] COLORS = {
        "red", "orange", "yellow", "green", "blue", "indigo", "violet",
    };
    private static final String[] ANIMALS = {
        "cat", "kiwi", "bear", "dog", "lizard", "snake", "rabbit", "guinea pig",
    };
    private static final Random RAND = new Random();
    
    public static void main(String[] args) {
        String color = getColor(); // call color method here
        String animal = getAnimal(); // call animal method again here
        String colorAgain = getColor(); // call color method again here
        int weight = getNumber(5, 200); // call number method,
            // with a range between 5 - 200
        int distance = getNumber(10, 20); // call number method,
            // with a range between 10 - 20
        int number = getNumber(10000, 20000); // call number method,
            // with a range between 10000 - 20000
        int time = getNumber(2, 6); // call number method,
            // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }

    public static String getColor() {
        int value;
        
        value = RAND.nextInt(COLORS.length);
        return COLORS[value];
    }
    
    public static String getAnimal() {
        int value;
        
        value = RAND.nextInt(ANIMALS.length);
        return ANIMALS[value];
    }
    
    public static int getNumber(int min, int max) {
        int range, value;
        
        range = max - min;
        value = RAND.nextInt(range) + min;
        
        return value;
    }
}