/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.mthree.classmodeling.gpsmapping;

/**
 *
 * @author Steven
 */
public abstract class House {
    final private String address;
    final private String city;
    final private String state;
    final private String country;
    
    /**
     * Constructs a new House with the specified address, city, state, and country
     * @param address
     * @param city
     * @param state
     * @param country 
     */
    public House(String address, String city, String state, String country) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    
    /**
     * Gets the address, city, state, and country of this house
     * @return the full address of this house
     */
    public abstract String getLocation();
    
    /**
     * Gets the address of this house
     * @return the house address and the street name
     */
    public abstract String getAddress();
    
    /**
     * Gets the city that this house is in
     * @return the city of this house
     */
    public abstract String getCity();
    
    /**
     * Gets the state that this house is in 
     * @return the state of this house
     */
    public abstract String getState();
    
    /**
     * Gets the country that this house is in
     * @return the country of this house
     */
    public abstract String getCountry();
}
