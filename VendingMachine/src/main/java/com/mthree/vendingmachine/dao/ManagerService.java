/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.NoItemInventoryException;
import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 
 * @author Steven
 */
public class ManagerService {
    final private BalanceDao balanceDao;
    final private InventoryDao inventoryDao;
    final private AuditDao auditDao;
    
    /**
     * Constructs a new ManagerService given the DAOs to use
     * @param balanceDao the DAO to handle the user's balance
     * @param inventoryDao the DAO to handle the inventory
     * @param auditDao the DAO to handle logging actions
     */
    public ManagerService(BalanceDao balanceDao, InventoryDao inventoryDao, AuditDao auditDao) {
        this.balanceDao = balanceDao;
        this.inventoryDao = inventoryDao;
        this.auditDao = auditDao;
        
        auditDao.log("START SESSION");
    }
    
    /**
     * Adds to the current balance
     * @param change the change to add to the balance
     * @return the new balance
     */
    public BigDecimal addBalance(Change change) {
        BigDecimal newBalance;
        
        newBalance = balanceDao.addBalance(change);
        auditDao.log("RECEIVED $" + change.total());
        
        return newBalance;
    }
    
    public BigDecimal getBalance() {
        return balanceDao.getBalance();
    }
    
    /**
     * Purchase an item by deducting balance and removing one from stock
     * @param itemName the name of the item to purchase
     * @return the new balance
     */
    public BigDecimal purchaseItem(String itemName) throws ItemNotFoundException, NoItemInventoryException, InsufficientFundsException {
        BigDecimal cost, newBalance;
        Item item;
        
        item = inventoryDao.getItem(itemName);
        inventoryDao.removeItem(itemName);
        
        cost = item.getCost();
        newBalance = balanceDao.deductBalance(cost);
        
        auditDao.log("SOLD " + item.getName());
        
        return newBalance;
    }
    
    /**
     * Get the sorted array of item names
     * @return the sorted array of item names
     */
    public String[] getAllItems() {
        String[] itemNames;
        
        itemNames = inventoryDao.getAllItems();
        Arrays.sort(itemNames);
        return itemNames;
    }
    
    /**
     * Gets an item from the item name
     * @param itemName the name of the item
     * @return the item
     */
    public Item getItem(String itemName) {
        return inventoryDao.getItem(itemName);
    }
    
    /**
     * Closes the manager and all associated DAOs
     * @return the change from the balanceDao
     */
    public Change close() {
        BigDecimal balance;
        Change change;
        
        change = balanceDao.close();
        balance = change.total();
        auditDao.log("RETURNED $" + balance + " AND ENDED SESSION");
        
        inventoryDao.close();
        auditDao.close();
        
        return change;
    }
}
