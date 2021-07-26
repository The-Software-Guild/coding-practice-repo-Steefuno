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
public class BestAdderEver {
    
    public static void main(String[] args) {
        double a, b, c, sum;
        
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Input 3 numbers: ");
        a = Double.parseDouble(inputReader.nextLine());
        b = Double.parseDouble(inputReader.nextLine());
        c = Double.parseDouble(inputReader.nextLine());
        
        sum = a + b + c;
        System.out.println("The sum is " + sum);
    }
}
