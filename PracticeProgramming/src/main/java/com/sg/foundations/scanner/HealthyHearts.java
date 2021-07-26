/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class HealthyHearts {
    
    public static void main(String[] args) {
        int age, max;
        double targetMin, targetMax;
        
        Scanner inputReader = new Scanner(System.in);
        
        max = 220;
        
        System.out.println("What is your age? ");
        age = Integer.parseInt(inputReader.nextLine());
        
        max = 220 - age;
        targetMin = max * .5;
        targetMax = max * .85;
        
        System.out.println("Your maximum heart rate should be " + max + " beats per minute.");
        System.out.println("Your target HR Zone is " + (int)targetMin + " - " + (int)targetMax + " beats per minute.");
    }
}
