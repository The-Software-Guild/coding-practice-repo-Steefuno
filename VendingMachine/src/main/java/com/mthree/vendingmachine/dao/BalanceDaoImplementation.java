/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Change;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author Steven
 */
public class BalanceDaoImplementation implements BalanceDao {
    private BigDecimal balance;
    
    public BalanceDaoImplementation() {
        balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    }
    
    /**
     * Adds change to the current balance
     * @param change the set of coins to add
     * @return the new balance
     */
    @Override
    public BigDecimal addBalance(Change change) {
        BigDecimal balanceToAdd, newBalance;
        
        balanceToAdd = change.total();
        newBalance = balance.add(balanceToAdd);
        
        balance = newBalance;
        return newBalance;
    }
    
    /**
     * Removes from the balance
     * @param deduction the BigDecimal to remove from the balance
     * @return the new balance
     * @throws InsifficientFundsException
     */
    @Override
    public BigDecimal deductBalance(BigDecimal deduction) throws InsufficientFundsException {
        BigDecimal newBalance;
        
        newBalance = balance.subtract(deduction);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException();
        }
        
        balance = newBalance;
        return newBalance;
    }
    
    /**
     * Gets the balance
     * @return the balance
     */
    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    
    /**
     * Converts the balance to change
     * @return the change
     */
    @Override
    public Change close() {
        Change change;
        
        change = Change.getOptimalChange(balance);
        balance = BigDecimal.ZERO;
        return change;
    }
}
