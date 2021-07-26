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
public class AllTheTrivia {
    
    public static void main(String[] args) {
        String left, right;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What's on your left: ");
        left = inputReader.nextLine();
        
        System.out.println("What's on your right: ");
        right = inputReader.nextLine();
        
        System.out.println("I see. So " + right + " is on your left and " + left + " is on your right.");
    }
}
