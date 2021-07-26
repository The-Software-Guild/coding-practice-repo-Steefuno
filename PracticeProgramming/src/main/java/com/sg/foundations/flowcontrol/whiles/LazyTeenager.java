/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

/**
 *
 * @author Steven
 */
public class LazyTeenager {
    public static void main(String[] args) {
        int count, num;
        boolean isGrounded;
        Random rand = new Random();
        
        count = 0;
        isGrounded = false;
        
        do {
            count += 1;
            
            if (count >= 7) {
                System.out.println("I'm taking your Xbox!");
                isGrounded = true;
                break;
            } else {
                System.out.println("Clean your room!! (x" + count + ")");
            }
            
            num = rand.nextInt(100);
        } while (num >= count * 10);
        
        if (isGrounded == false) {
            System.out.println("FINE!");
        }
    }
}
