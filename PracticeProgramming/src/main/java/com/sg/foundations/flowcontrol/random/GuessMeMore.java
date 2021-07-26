/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.flowcontrol.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class GuessMeMore {
    public static void main(String[] args) {
        int guess;
        
        Random rand = new Random();
        Scanner reader = new Scanner(System.in);
        
        final int target = rand.nextInt(201) - 100;

        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        do {
            System.out.println("\nYour guess: ");
            guess = reader.nextInt();
            
            if (guess < target) {
                System.out.println("Too low");
            } else if (guess > target) {
                System.out.println("Too high");
            }
        } while (guess != target);
        
        System.out.println("\nWow, nice guess! That was it!");
    }
}
