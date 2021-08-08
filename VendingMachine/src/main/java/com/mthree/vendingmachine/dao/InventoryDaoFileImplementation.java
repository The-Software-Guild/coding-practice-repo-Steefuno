/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.NoItemInventoryException;
import com.mthree.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Steven
 */
public class InventoryDaoFileImplementation implements InventoryDao {
    final private HashMap<String, Item> inventory;
    final private String path;
    
    public InventoryDaoFileImplementation(String path) {
        this.path = path;
        inventory = new HashMap<String, Item>();
        load();
    }
    
    /**
     * Removes one of an item from the inventory
     * @param itemName the name of the item to remove
     */
    @Override
    public void removeItem(String itemName) throws ItemNotFoundException, NoItemInventoryException {
        Item item;
        
        item = inventory.get(itemName);
        if (item == null) {
            throw new ItemNotFoundException();
        }
        if (item.getStock() <= 0) {
            throw new NoItemInventoryException();
        }
        
        item.takeOne();
    }
    
    /**
     * Gets a String[] of all item names
     * @return the String[]
     */
    @Override
    public String[] getAllItems() {
        Object[] keys;
        String[] itemNames;
        
        keys = inventory.keySet().toArray();
        itemNames = new String[keys.length];
        
        for (int i = 0; i < keys.length; i++) {
            itemNames[i] = (String) keys[i];
        }
        return itemNames;
    }
    
    /**
     * Gets an item given the name
     * @param itemName the item name
     * @return the item
     */
    @Override
    public Item getItem(String itemName) {
        return inventory.get(itemName);
    }
    
    /**
     * Closes the inventory saving any changes if necessary
     */
    public void close() {
        Collection<Item> items;
        PrintWriter writer;
        
        // Attempt to open the file
        try {
            writer = new PrintWriter(
                new FileWriter(path)
            );
        } catch (Exception ex) {
            System.out.println("Failed to write to inventory file");
            System.exit(-1);
            return;
        }
        
        // Adds Items line by line into the file after marshaling
        items = inventory.values();
        for (Item item: items) {
            String data;
                
            data = marshal(item);
            
            writer.println(data);
        }
        writer.close();
    }
    
    /**
     * Loads the inventory from the path
     */
    private void load() {
        Scanner scanner;
        inventory.clear();
        
        // Attempt to open the file
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(path)
                )
            );
        } catch (Exception ex) {
            System.out.println("Failed to open inventory file");
            System.exit(-1);
            return;
        }
        
        // Iterates line by line in the file to unmarshal and map the Item
        while (scanner.hasNextLine()) {
            String data;
            Item item;
            
            data = scanner.nextLine();
            if (data.equals("")) {
                break;
            }
            
            item = unmarshal(data);
            
            inventory.put(item.getName(), item);
        }
    }
    
    /**
     * Marshalls the item into a String
     * @param item the item
     * @return the String of the item
     */
    private String marshal(Item item) {
        String itemData;
        
        itemData = String.format("%s::%s::%d",
            item.getName(),
            item.getCost(),
            item.getStock()
        );
        return itemData;
    }
    
    /**
     * Unmarshalls the string into an item
     * @param itemData the String of the item
     * @return the item
     */
    private Item unmarshal(String itemData) {
        Item item;
        String[] data;
        BigDecimal cost;
        int stock;
        
        data = itemData.split("::");
        cost = new BigDecimal(data[1]);
        stock = Integer.parseInt(data[2]);
        item = new Item(data[0], cost, stock);
        return item;
    }
}
