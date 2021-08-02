/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 02 Aug 2021
 */

package com.mthree.addressbook.dao;

import com.mthree.addressbook.dto.Address;
import java.util.HashMap;

/**
 * 
 * @author Steven
 */
public class DaoHashMapImplementation implements Dao {
    HashMap<String, Address> addressBook;
    
    public DaoHashMapImplementation() {
        this.addressBook = new HashMap<String, Address>();
    }
    
    /**
     * Adds an address to book
     * @param address the Address object to add
     */
    public void add(Address address) {
        addressBook.put(address.getLastName(), address);
    }
    
    /**
     * Removes an address from the book by last name
     * @param lastName the last name of the owner
     * @return the address that was popped
     */
    public Address remove(String lastName) {
        return addressBook.remove(lastName);
    }
    
    /**
     * Finds an address by the last name of the owner
     * @param lastName the last name of the owner
     * @return the address
     */
    public Address find(String lastName) {
        return addressBook.get(lastName);
    }
    
    /**
     * Gets the number of addresses in the book
     * @return the number of addresses
     */
    public int getCount() {
        return addressBook.size();
    }
    
    /**
     * Gets an array of all the addresses
     * @return an unordered array of the addresses
     */
    public Address[] getAll() {
        Object[] values;
        Address[] addresses;
        
        values = addressBook.values().toArray();
        addresses = new Address[values.length];
        
        for (int i = 0; i < values.length; i++) {
            Address address = (Address) values[i];
            addresses[i] = address;
        }
        return addresses;
    }
}
