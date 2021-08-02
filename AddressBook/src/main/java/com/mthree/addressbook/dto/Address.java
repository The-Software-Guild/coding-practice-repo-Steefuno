/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */

package com.mthree.addressbook.dto;

/**
 * 
 * @author Steven
 */
public class Address {
    final private String firstName, lastName, streetAddress, city, state;
    
    /**
     * Constructs a new Address given all the fields
     * @param firstName the first name of the owner
     * @param lastName the last name of the owner
     * @param streetAddress the house address
     * @param city the city name
     * @param state the state name
     */
    public Address(String firstName, String lastName, String streetAddress, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
}
