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
public enum CoinType {
    QUARTER(0.25),
    DIME(0.1),
    NICKEL(0.05),
    PENNY(0.01);
    
    final private BigDecimal value;
    
    /**
     * Constructs a new CoinType given the double value
     * @param value the double of the value
     */
    private CoinType(double value) {
        this.value = (new BigDecimal(value)).setScale(2, RoundingMode.HALF_UP);;
    }
    
    /**
     * Gets the value of the coin type
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }
}
