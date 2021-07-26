/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.sg.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class MiniMadLibs {
    
    public static void main(String[] args) {
        String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("I need a noun: ");
        s1 = inputReader.nextLine();
        
        System.out.println("Now an adjective: ");
        s2 = inputReader.nextLine();
        
        System.out.println("Another noun: ");
        s3 = inputReader.nextLine();
        
        System.out.println("And a number: ");
        s4 = inputReader.nextLine();
        
        System.out.println("Another adjective: ");
        s5 = inputReader.nextLine();
        
        System.out.println("A plural noun: ");
        s6 = inputReader.nextLine();
        
        System.out.println("Another one: ");
        s7 = inputReader.nextLine();
        
        System.out.println("One more: ");
        s8 = inputReader.nextLine();
        
        System.out.println("A verb (infinitive form): ");
        s9 = inputReader.nextLine();
        
        System.out.println("Same verb (past participle): ");
        s10 = inputReader.nextLine();
        
        System.out.println("\n" + s1 + ": the " + s2 + " frontier. These are the voyages of the starship " + s3 + ". Its " + s4 + "-year mission: to explore strange " + s5 + " " + s6 + ", to seek out " + s5 + " " + s7 + " and " + s5 + " " + s8 + ", to boldly " + s9 + " where no one has " + s10 + " before.");
    }
}
