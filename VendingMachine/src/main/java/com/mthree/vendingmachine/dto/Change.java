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
public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    
    /**
     * Constructs a new Change given the coins
     * @param quarters the number of quarters
     * @param dimes the number of dimes
     * @param nickels the number of nickels
     * @param pennies the number of pennies
     */
    public Change(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }
    
    /**
     * Adds a coin to the change given the CoinType
     * @param type the type of coin
     */
    public void add(CoinType type) {
        switch (type) {
            case QUARTER:
                quarters++;
                break;
            case DIME:
                dimes++;
                break;
            case NICKEL:
                nickels++;
                break;
            case PENNY:
                pennies++;
                break;
        }
    }
    
    /**
     * Gets the number of a type of coin
     * @param type the type of the coin
     * @return the number of the select CoinType in the change
     */
    public int get(CoinType type) {
        switch (type) {
            case QUARTER:
                return quarters;
            case DIME:
                return dimes;
            case NICKEL:
                return nickels;
            case PENNY:
                return pennies;
            default:
                throw new java.lang.Error("Invalid CoinType");
        }
    }
    
    /**
     * Constructs a new Change with as many quarters, as many nickels, as many dimes, and then as many pennies as possible
     * @param balance
     * @return 
     */
    public static Change getOptimalChange(BigDecimal balance) {
        CoinType[] coinTypes = { CoinType.QUARTER, CoinType.DIME, CoinType.NICKEL, CoinType.PENNY };
        int[] coins;
        Change change;
        
        coins = new int[coinTypes.length];
        for(int i = 0; i < coinTypes.length; i++) {
            BigDecimal coinTypeValue;
            BigDecimal[] quotientAndRemainder;
                
            coinTypeValue = coinTypes[i].getValue();
            quotientAndRemainder = balance.divideAndRemainder(coinTypeValue);
            
            coins[i] = quotientAndRemainder[0].intValue();
            balance = quotientAndRemainder[1];
        }
        
        change = new Change(coins[0], coins[1], coins[2], coins[3]);
        return change;
    }
    
    /**
     * Gets the total balance from this change
     * @return the balance
     */
    public BigDecimal total() {
        BigDecimal total, totalQuarters, totalDimes, totalNickels, totalPennies;
        
        totalQuarters = (new BigDecimal(quarters)).multiply(CoinType.QUARTER.getValue());
        totalDimes = (new BigDecimal(dimes)).multiply(CoinType.DIME.getValue());
        totalNickels = (new BigDecimal(nickels)).multiply(CoinType.NICKEL.getValue());
        totalPennies = (new BigDecimal(pennies)).multiply(CoinType.PENNY.getValue());
        
        total = totalQuarters.add(totalDimes).add(totalNickels).add(totalPennies).setScale(2, RoundingMode.HALF_UP);
        
        return total;
    }
}
