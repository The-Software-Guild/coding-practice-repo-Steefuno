/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 03 Aug 2021
 */

package com.mthree.birthdaycalendar.controller;

import com.mthree.birthdaycalendar.ui.View;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Steven
 */
public class Controller {
    View view;
    
    final static int THIS_YEAR = 2021;
    final static String DATE_PATTERN = "yyyy-MM-dd";
    final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    
    /**
     * Constructs a new Controller
     * @param view the object that handles UI
     */
    public Controller(View view) {
        this.view = view;
    }
    
    /**
     * Runs the program to:
     * ask for a birthday,
     * determine the day of the week of the birthday,
     * say the current date,
     * say the days until the next birthday,
     * say how many years old they will be
     */
    public void run() {
        LocalDate birthdate, today, birthdateThisYear;
        Period difference;
        String dayOfTheWeek;
        
        // Request the user's birthday
        birthdate = requestBirthday();
        dayOfTheWeek = birthdate.getDayOfWeek().toString();
        view.say("\nThat means that you were born on a " + dayOfTheWeek + "!");
        
        // Get the LocalDate of the birthday this year
        birthdateThisYear = birthdate.withYear(THIS_YEAR);
        dayOfTheWeek = birthdateThisYear.getDayOfWeek().toString();
        view.say("This year, your birthday will be on a " + dayOfTheWeek + "!");
        
        // Get the Period until the birthday this year
        today = LocalDate.now();
        view.say("Today is " + today + ".");
        difference = today.until(birthdateThisYear);
        displayDaysUntilBirthday(difference);
        
        // Get the user's age
        difference = birthdate.until(today);
        displayAge(difference);
    }
    
    /**
     * Request the user's birthday
     * @return the LocalDate of the birthday
     */
    private LocalDate requestBirthday() {
        String birthdayString;
        LocalDate birthdayLocalDate;
        
        birthdayLocalDate = null;
        do {
            birthdayString = view.promptString("\nWhat is your birthday? (" + DATE_PATTERN + ")");
            try {
                birthdayLocalDate = LocalDate.parse(birthdayString, FORMATTER);
            } catch (Exception e) {
                continue;
            }
        } while (birthdayLocalDate == null);
        
        return birthdayLocalDate;
    }
    
    /**
     * Displays to the user the number of days until or since their birthday this year
     * @param difference 
     */
    private void displayDaysUntilBirthday(Period difference) {
        String message;
        long days;
        long months;
        
        days = difference.get(ChronoUnit.DAYS);
        months = difference.get(ChronoUnit.MONTHS);
        if (difference.isNegative()) {
            message = "It has been %d days and %d months since your birthday!";
            days *= -1;
            months *= -1;
        } else {
            message = "It will be %d days and %d months until your birthday!";
        }
        
        view.say(String.format(message, days, months));
    }
    
    /**
     * Displays the age the user will be if the birthday was before the current date
     * @param difference the Period between the birthdate and today
     */
    private void displayAge(Period difference) {
        String message;
        int years;
        
        years = difference.getYears();
        if (difference.isNegative()) {
            message = "Hello, fellow time traveller.";
            view.say(message);
        } else {
            message = "You're going to be %d! Congrats!";
            view.say(String.format(message, years));
        }
    }
    
    /**
     * Get the LocalDate of the birthday this year
     * @param day the LocalDate to get the month and day
     * @return the LocalDate of the month and day this year
     */
    private static LocalDate getDateOfThisYear(LocalDate otherDay) {
        LocalDate date;
        
        date = otherDay.withYear(THIS_YEAR);
        return date;
    }
}
