/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        int target, count;
        boolean isFizz, isBuzz;
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("How many units of fizzing and buzzing do we need?");
        target = Integer.parseInt(reader.nextLine());
        count = 0;
        
        for (int i = 0; count < target; i++) {
            isFizz = (i % 3 == 0);
            isBuzz = (i % 5 == 0);
            if (isFizz && isBuzz) {
                System.out.println("fizz buzz");
                count++;
            } else if (isFizz) {
                System.out.println("fizz");
                count++;
            } else if (isBuzz) {
                System.out.println("buzz");
                count++;
            } else {
                System.out.println(i);
            }
        }
        System.out.println("TRADITION!!!!!");
    }
}
