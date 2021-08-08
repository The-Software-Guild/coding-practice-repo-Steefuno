/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */
package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ManagerServiceTest {
    private ManagerService manager;
    private static String PATH = "./TestInventory";
    
    public ManagerServiceTest() {
        manager = null;
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() throws FileNotFoundException, IOException {
        PrintWriter out = new PrintWriter(
            new FileWriter(PATH)
        );
    }
    
    @BeforeEach
    public void setUp() throws FileNotFoundException, IOException {
        PrintWriter out = new PrintWriter(
            new FileWriter(PATH)
        );
        
        out.println("Item1::1.00::1");
        out.println("Item2::1.01::2");
        out.close();
        
        manager = new ManagerService(
            new BalanceDaoImplementation(),
            new InventoryDaoFileImplementation(PATH),
            new AuditDaoStubImplementation()
        );
    }
    
    @AfterEach
    public void tearDown() {
        manager = null;
    }
    
    /**
     * Tests addBalance to add balance properly
     * Note: UI generally ensures input is a natural number
     */
    @Test
    public void Should_Add_Balance_And_Get_Balance() {
        Change change;
        BigDecimal assumedBalance;
        
        change = new Change(4, 0, 1, 0); // 1.05
        manager.addBalance(change);
        
        assumedBalance = (new BigDecimal(1.05)).setScale(2, RoundingMode.HALF_UP);
        assertEquals(
            manager.getBalance(),
            assumedBalance,
            "Balance should be $1.05."
        );
        
        change = new Change(4, 0, 1, 0); // 1.05
        manager.addBalance(change);
        
        assumedBalance = (new BigDecimal(2.10)).setScale(2, RoundingMode.HALF_UP);
        assertEquals(
            manager.getBalance(),
            assumedBalance,
            "Balance should be $2.10."
        );
    }
    
    /**
     * Tests purchaseItem to purchase in normal conditions
     */
    @Test
    public void Should_Purchase() {
        Change change;
        BigDecimal newBalance, assumedBalance;
        Item item;
        
        change = new Change(4, 0, 1, 0); // 1.05
        newBalance = BigDecimal.ZERO;
        manager.addBalance(change);
        try {
            newBalance = manager.purchaseItem("Item1");
        } catch (Exception e) {
            fail("Should not throw exception.");
        }
        
        assumedBalance = (new BigDecimal(0.05)).setScale(2, RoundingMode.HALF_UP);
        assertEquals(
            newBalance,
            assumedBalance,
            "Balance should be $0.05."
        );
        
        item = manager.getItem("Item1");
        assertEquals(
            item.getStock(),
            0,
            "Item1 stock should be 0."
        );
    }
    
    /**
     * Tests purchaseItem to purchase in normal conditions
     */
    @Test
    public void Should_Fail_Purchase() {
        Change change;
        Item item;
        
        change = new Change(0, 0, 1, 0); // 0.05
        manager.addBalance(change);
        try {
            manager.purchaseItem("Item1");
            fail("Should not be able to purchase item.");
        } catch (Exception e) {
            // do nothing
        }
        
        assertEquals(
            manager.getBalance(),
            change.total(),
            "Balance should be unchanged."
        );
        
        item = manager.getItem("Item1");
        assertEquals(
            item.getStock(),
            0,
            "Item1 stock should be 1."
        );
    }
}
