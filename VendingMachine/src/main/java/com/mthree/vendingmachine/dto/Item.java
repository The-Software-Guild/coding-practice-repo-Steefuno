/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author Steven
 */
public class Item {
    final private String name;
    final private BigDecimal cost;
    private int stock;
    
    /**
     * Constructs a new Item given the name, cost, and stock
     * @param name the name of the item
     * @param cost the cost of the item
     * @param stock the count of the item in stock
     */
    public Item(String name, BigDecimal cost, int stock) {
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.stock = stock;
    }
    
    /**
     * Gets the name of the item
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the cost of the item
     * @return the cost
     */
    public BigDecimal getCost() {
        return cost;
    }
    
    /**
     * Gets the stock of the item
     * @return the stock
     */
    public int getStock() {
        return stock;
    }
    
    /**
     * Removes one of this item from stock
     * @throws NoItemInventoryException 
     */
    public void takeOne() throws NoItemInventoryException {
        if (stock <= 0) {
            throw new NoItemInventoryException();
        }
        
        stock--;
    }
}
