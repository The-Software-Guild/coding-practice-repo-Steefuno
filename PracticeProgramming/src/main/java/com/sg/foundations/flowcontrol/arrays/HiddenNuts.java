/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 26 Jul 2021
 */
package com.sg.foundations.flowcontrol.arrays;

import java.util.Random;

/**
 *
 * @author Steven
 */
public class HiddenNuts {
    public static void main(String[] args) {
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");

        for (int i = 0; i < hidingSpots.length; i++) {
            if ((hidingSpots[i] != null) && (hidingSpots[i].equals("Nut"))) {
                System.out.println("Found it! It's in spot#" + i + "!");
                return;
            }
        }
        System.out.println("Something went wrong. There isn't a nut.");
    }
}
