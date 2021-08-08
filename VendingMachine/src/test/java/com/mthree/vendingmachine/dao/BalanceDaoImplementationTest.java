/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */
package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.CoinType;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class BalanceDaoImplementationTest {
    private BalanceDaoImplementation balanceDao;
    
    public BalanceDaoImplementationTest() {
        balanceDao = null;
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        balanceDao = new BalanceDaoImplementation();
    }
    
    @AfterEach
    public void tearDown() {
        balanceDao = null;
    }

    /**
     * Tests if the constructor constructs with 0 balance
     */
    @Test
    public void Should_Initialize_With_No_Balance() {
        assertEquals(
            balanceDao.getBalance().compareTo(BigDecimal.ZERO),
            0,
            "BalanceDao should initialize with 0 balance."
        );
    }
    
    /**
     * Tests if AddBalance adds balance
     */
    @Test
    public void Should_Raise_Balance_On_addBalance() {
        Change change;
        BigDecimal balance, assumedBalance;
        
        // Add to the balance
        change = new Change(4, 1, 1, 1);
        balance = balanceDao.addBalance(change);
        
        // Check if balance matches the assumed balance
        assumedBalance = (new BigDecimal(1.16)).setScale(2, RoundingMode.HALF_UP);;
        assertEquals(
            balance.compareTo(assumedBalance),
            0,
            "Balance should be $1.16."
        );
        
        // Add to the balance
        change = new Change(4, 1, 1, 1);
        balance = balanceDao.addBalance(change);
        
        // Check if balance matches the assumed balance
        assumedBalance = (new BigDecimal(2.32)).setScale(2, RoundingMode.HALF_UP);;
        assertEquals(
            balance.compareTo(assumedBalance),
            0,
            "Balance should be $2.32."
        );
    }
    
    /**
     * Tests if deductBalance removes money
     */
    @Test
    public void Should_Deduct_Balance_On_deductBalance() {
        Change change;
        BigDecimal balance, deduction, assumedBalance;
        
        // Add to the balance
        change = new Change(2, 0, 0, 4);
        balanceDao.addBalance(change);
        
        // Deduct balance
        deduction = (new BigDecimal(0.25)).setScale(2, RoundingMode.HALF_UP);
        try {
            balance = balanceDao.deductBalance(deduction);
        } catch(InsufficientFundsException e) {
            fail("Balance should be big enough to deduct $0.25.");
            return;
        }
        
        // Check if balance matches the assumed balance
        assumedBalance = (new BigDecimal(0.29)).setScale(2, RoundingMode.HALF_UP);;
        assertEquals(
            balance.compareTo(assumedBalance),
            0,
            "Balance should be $0.29."
        );
        
        // Deduct balance
        deduction = (new BigDecimal(0.09)).setScale(2, RoundingMode.HALF_UP);
        try {
            balance = balanceDao.deductBalance(deduction);
        } catch(InsufficientFundsException e) {
            fail("Balance should be big enough to deduct $0.09.");
            return;
        }
        
        // Check if balance matches the assumed balance
        assumedBalance = (new BigDecimal(0.20)).setScale(2, RoundingMode.HALF_UP);;
        assertEquals(
            balance.compareTo(assumedBalance),
            0,
            "Balance should be $0.20."
        );
    }
    
    /**
     * Tests if deductBalance removes money
     */
    @Test
    public void Should_Not_Deduct_Balance_With_InsufficientFunds() {
        Change change;
        BigDecimal balance, deduction, assumedBalance;
        
        // Add to the balance
        change = new Change(4, 0, 0, 0);
        balanceDao.addBalance(change);
        balance = balanceDao.getBalance();
        
        // Deduct balance
        deduction = (new BigDecimal(1.25)).setScale(2, RoundingMode.HALF_UP);
        try {
            balance = balanceDao.deductBalance(deduction);
            fail("Balance should not have been enough to deduct $1.25.");
        } catch(InsufficientFundsException e) {}
        
        // Check if balance matches the assumed balance
        assumedBalance = (new BigDecimal(1)).setScale(2);
        assertEquals(
            balance.compareTo(assumedBalance),
            0,
            "Balance should be $1.00."
        );
    }
    
    /**
     * Tests if getBalance returns the balance properly
     */
    @Test
    public void Should_Get_Balance_On_getBalance() {
        Change change;
        BigDecimal balance, assumedBalance;
        
        // Add to the balance
        change = new Change(0, 0, 0, 4);
        assumedBalance = balanceDao.addBalance(change);
        
        // Check if balance matches the assumed balance
        balance = balanceDao.getBalance();
        assertEquals(
            balance.compareTo(assumedBalance),
            0,
            "Balance should be $0.04."
        );
    }
    
    /**
     * Tests if close gives optimal change
     */
    @Test
    public void Should_Get_Optimal_Change_On_close() {
        Change change, assumedChange;
        
        // Add to the balance
        change = new Change(0, 3, 3, 2);
        balanceDao.addBalance(change);
        
        // Check if the change matches the assumed change
        change = balanceDao.close();
        assumedChange = new Change(1, 2, 0, 2);
        assertTrue(
            (
                (change.get(CoinType.QUARTER) == assumedChange.get(CoinType.QUARTER)) &&
                (change.get(CoinType.DIME) == assumedChange.get(CoinType.DIME)) &&
                (change.get(CoinType.NICKEL) == assumedChange.get(CoinType.NICKEL)) &&
                (change.get(CoinType.PENNY) == assumedChange.get(CoinType.PENNY))
            ),
            "Change should be 1 quarter, 2 dimes, and 2 pennies."
        );
    }
}
