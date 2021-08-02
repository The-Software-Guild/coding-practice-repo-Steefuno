/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 02 Aug 2021
 */

package com.mthree.addressbook.dao;

import com.mthree.addressbook.dto.Address;

/**
 * 
 * @author Steven
 */
public interface Dao {
    /**
     * Adds an address to book
     * @param address the Address object to add
     */
    public void add(Address address);
    
    /**
     * Removes an address from the book by last name
     * @param lastName the last name of the owner
     * @return the address that was popped
     */
    public Address remove(String lastName);
    
    /**
     * Finds an address by the last name of the owner
     * @param lastName the last name of the owner
     * @return the address
     */
    public Address find(String lastName);
    
    /**
     * Gets the number of addresses in the book
     * @return the number of addresses
     */
    public int getCount();
    
    /**
     * Gets an array of all the addresses
     * @return an unordered array of the addresses
     */
    public Address[] getAll();
}
