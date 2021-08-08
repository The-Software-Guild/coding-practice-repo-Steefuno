/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.NoItemInventoryException;
import com.mthree.vendingmachine.dto.Item;

/**
 * 
 * @author Steven
 */
public interface InventoryDao {
    /**
     * Removes one of an item from the inventory
     * @param itemName the name of the item to remove
     */
    public void removeItem(String itemName) throws ItemNotFoundException, NoItemInventoryException;
    
    /**
     * Gets a String[] of all item names
     * @return the String[]
     */
    public String[] getAllItems();
    
    /**
     * Gets an item given the name
     * @param itemName the item name
     * @return the item
     */
    public Item getItem(String itemName);
    
    /**
     * Closes the inventory saving any changes if necessary
     */
    public void close();
}
