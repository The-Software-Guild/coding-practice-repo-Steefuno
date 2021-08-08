/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Change;
import java.math.BigDecimal;

/**
 * 
 * @author Steven
 */
public interface BalanceDao {
    /**
     * Adds change to the current balance
     * @param change the set of coins to add
     * @return the new balance
     */
    public BigDecimal addBalance(Change change);
    
    /**
     * Removes from the balance
     * @param deduction the BigDecimal to remove from the balance
     * @return the new balance
     * @throws InsufficientFundsException
     */
    public BigDecimal deductBalance(BigDecimal deduction) throws InsufficientFundsException;
    
    /**
     * Gets the balance
     * @return the balance
     */
    public BigDecimal getBalance();
    
    /**
     * Converts the balance to change
     * @return the change
     */
    public Change close();
}
