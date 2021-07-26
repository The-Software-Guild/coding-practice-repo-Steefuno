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
public class DoItBetter {
    
    public static void main(String[] args) {
        double miles, hotdogs, languages;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("How many miles can you run: ");
        miles = Double.parseDouble(inputReader.nextLine());
        
        System.out.println("How many hot dogs can you eat: ");
        hotdogs = Double.parseDouble(inputReader.nextLine());
        
        System.out.println("How many languages do you know: ");
        languages = Double.parseDouble(inputReader.nextLine());
        
        miles = miles * 2 + 1;
        hotdogs = hotdogs * 2 + 1;
        languages = languages * 2 + 1;
        
        System.out.println("Ha. I can run " + miles + " miles.");
        System.out.println("I can eat " + hotdogs + " hot dogs.");
        System.out.println("And I can speak " + languages + " languages.");
    }
}
