/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 02 Aug 2021
 */
package com.mthree.addressbook.dao;

import com.mthree.addressbook.dto.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Steven
 */
public class DaoHashMapImplementationTest {
    final private Address address1, address2;
    
    public DaoHashMapImplementationTest() {
        address1 = new Address(
            "Steve",
            "Nguyen",
            "845 1st Street",
            "Atlantis",
            "Florida"
        );
        address2 = new Address(
            "Bob",
            "Tran",
            "97485 8th Street",
            "Boston",
            "Hawaii"
        );
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of add method, of class DaoHashMapImplementation.
     */
    @org.junit.jupiter.api.Test
    public void testAdd() {
        // Initialize the DAO
        DaoHashMapImplementation dao = new DaoHashMapImplementation();
        
        // Add an address
        dao.add(address1);
            
        // DAO should have 1 address
        assertTrue(
            (dao.getCount() == 1),
            "DAO should have 1 address"
        );
    }

    /**
     * Test of remove method, of class DaoHashMapImplementation.
     */
    @org.junit.jupiter.api.Test
    public void testRemove() {
        Address address;
        
        // Initialize the DAO
        DaoHashMapImplementation dao = new DaoHashMapImplementation();
        
        // Add an address
        dao.add(address1);
        
        // Remove address1
        address = dao.remove(address1.getLastName());
        
        // Removed address should be address1
        assertTrue(
            (address1.equals(address)),
            "Removed address should be address1"
        );
        
        // DAO should be empty
        assertTrue(
            (dao.getCount() == 0),
            "DAO should be empty"
        );
    }

    /**
     * Test of find method, of class DaoHashMapImplementation.
     */
    @org.junit.jupiter.api.Test
    public void testFind() {
        Address address;
        
        // Initialize the DAO
        DaoHashMapImplementation dao = new DaoHashMapImplementation();
        
        // Add an address
        dao.add(address1);
        
        // Remove address1
        address = dao.find(address1.getLastName());
        
        // Found address should be address1
        assertTrue(
            (address1.equals(address)),
            "Removed address should be address1"
        );
    }

    /**
     * Test of getCount method, of class DaoHashMapImplementation.
     */
    @org.junit.jupiter.api.Test
    public void testGetCount() {
        // Initialize the DAO
        DaoHashMapImplementation dao = new DaoHashMapImplementation();
        
        // DAO should be empty
        assertTrue(
            (dao.getCount() == 0),
            "DAO should be empty"
        );
        
        // Add an address
        dao.add(address1);
            
        // DAO should have 1 address
        assertTrue(
            (dao.getCount() == 1),
            "DAO should have 1 address"
        );
        
        // Remove an address
        dao.remove(address1.getLastName());
        
        // DAO should be empty
        assertTrue(
            (dao.getCount() == 0),
            "DAO should be empty"
        );
    }

    /**
     * Test of getAll method, of class DaoHashMapImplementation.
     */
    @org.junit.jupiter.api.Test
    public void testGetAll() {
        Address[] addresses;
        int count1, count2;
        
        // Initialize the DAO
        DaoHashMapImplementation dao = new DaoHashMapImplementation();
        
        // Add both addresses
        dao.add(address1);
        dao.add(address2);
        
        // Get all addresses
        addresses = dao.getAll();
        
        // Check array for both addresses
        count1 = 0;
        count2 = 0;
        for (var address : addresses) {
            if (address1 == address) {
                count1++;
            } else if (address2 == address) {
                count2++;
            }
        }
        
        // Address1 must exist only once in the DAO
        assertTrue(
            (count1 == 1),
            "address1 must exist only once in the DAO"
        );
        
        // Address2 must exist only once in the DAO
        assertTrue(
            (count2 == 1),
            "address2 must exist only once in the DAO"
        );
    }
    
}
