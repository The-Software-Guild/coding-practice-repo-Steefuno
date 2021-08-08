/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Item;
import com.mthree.vendingmachine.dto.NoItemInventoryException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
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
public class InventoryDaoFileImplementationTest {
    private InventoryDaoFileImplementation inventoryDao;
    private static String PATH = "./TestInventory";
    
    public InventoryDaoFileImplementationTest() {
        inventoryDao = null;
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
        
        inventoryDao = new InventoryDaoFileImplementation(PATH);
    }
    
    @AfterEach
    public void tearDown() {
        inventoryDao = null;
    }
    
    /**
     * Checks if initializing the object loads from the file properly
     */
    @Test
    public void Should_Load_Inventory_On_Initialize() {
        String[] itemNames;
        Item item;
        
        itemNames = inventoryDao.getAllItems();
        assertEquals(
            itemNames.length,
            2,
            "Should have 2 items on initialize."
        );
        
        item = inventoryDao.getItem("Item1");
        assertEquals(
            item.getStock(),
            1,
            "Item1 should have 1 stock."
        );
        item = inventoryDao.getItem("Item2");
        assertEquals(
            item.getStock(),
            2,
            "Item2 should have 2 stock."
        );
    }
    
    /**
     * Tests if removing an item works on normal conditions
     */
    @Test
    public void Should_Remove_One_Item_On_removeItem() {
        Item item;
        
        try {
            inventoryDao.removeItem("Item2");
        } catch (ItemNotFoundException e) {
            fail("Item2 should exist.");
        } catch (NoItemInventoryException e) {
            fail("Item2 should have enough stock to remove one.");
        }
        
        item = inventoryDao.getItem("Item2");
        assertEquals(
            item.getStock(),
            1,
            "Item2 should have 1 stock."
        );
    }
    
    /**
     * Tests if removing an item fails when no stock
     */
    @Test
    public void Should_Fail_To_Remove_With_No_Stock() {
        Item item;
        
        try {
            inventoryDao.removeItem("Item1");
        } catch (ItemNotFoundException e) {
            fail("Item1 should exist.");
        } catch (NoItemInventoryException e) {
            fail("Item1 should have enough stock to remove one.");
        }
        
        try {
            inventoryDao.removeItem("Item1");
            fail("Item1 should not have enough stock to remove one.");
        } catch (ItemNotFoundException e) {
            fail("Item1 should exist.");
        } catch (NoItemInventoryException e) {
            // do nothing
        }
    }
    
    /**
     * Tests if removing an item fails when it does not exist
     */
    @Test
    public void Should_Fail_To_Remove_With_No_Item() {
        Item item;
        
        try {
            inventoryDao.removeItem("Item3");
            fail("Item3 should not have been removed.");
        } catch (ItemNotFoundException e) {
            // do nothing
        } catch (NoItemInventoryException e) {
            fail("Item3 should not exist to have stock.");
        }
    }
    
    /**
     * Tests if getAllItems works properly
     */
    @Test
    public void Should_Get_All_Item_Names() {
        boolean item1Exists, item2Exists;
        String[] itemNames;
        
        itemNames = inventoryDao.getAllItems();
        
        assertEquals(
            itemNames.length,
            2,
            "Should have 2 items."
        );
        
        item1Exists = false;
        item2Exists = false;
        for (var name: itemNames) {
            switch(name) {
                case "Item1":
                    item1Exists = true;
                    break;
                case "Item2":
                    item2Exists = true;
                    break;
                default:
                    fail("Should only have Item1 and Item2");
            }
        }
        
        assertTrue(
            item1Exists && item2Exists,
            "Should have both Item1 and Item2."
        );
    }
    
    /**
     * Tests if getItem gets an item properly
     */
    @Test
    public void Should_Get_An_Item() {
        Item item;
        BigDecimal assumedCost;
        
        item = inventoryDao.getItem("Item1");
        
        assertEquals(
            item.getName(),
            "Item1",
            "Item retrieved should be Item1."
        );
        
        assumedCost = (new BigDecimal(1.00)).setScale(2, RoundingMode.HALF_UP);
        assertEquals(
            item.getCost(),
            assumedCost,
            "Item1 should be $1.00."
        );
        
        assertEquals(
            item.getStock(),
            1,
            "Item1 should have 1 stock."
        );
    }
    
    /**
     * Tests if getItem gets null instead of an item when item does not exist
     */
    @Test
    public void Should_Not_Get_An_Item() {
        Item item;
        
        item = inventoryDao.getItem("Item3");
        
        assertEquals(
            item,
            null,
            "Should have gotten null from the inventory."
        );
    }
    
    /**
     * Tests if close saves to the file properly
     */
    @Test
    public void Should_Close_Properly() throws FileNotFoundException {
        Scanner scanner;
        boolean isItem1SavedCorrectly, isItem2SavedCorrectly;
        int count;
        
        try {
            inventoryDao.removeItem("Item1");
            inventoryDao.removeItem("Item2");
        } catch (Exception e) {
            fail("Refer to test: Should_Remove_One_Item_On_removeItem.");
        }
        
        inventoryDao.close();
        
        scanner = new Scanner(
            new BufferedReader(
                new FileReader(PATH)
            )
        );
        
        isItem1SavedCorrectly = false;
        isItem2SavedCorrectly = false;
        count = 0;
        while (scanner.hasNextLine()) {
            String itemData = scanner.nextLine();
            count++;
            
            switch (itemData) {
                case "Item1::1.00::0":
                    isItem1SavedCorrectly = true;
                    break;
                case "Item2::1.01::1":
                    isItem2SavedCorrectly = true;
                    break;
                default:
                    fail(itemData + " should not be in the inventory.");
            }
        }
        
        assertEquals(
            count,
            2,
            "The file should have 2 items."
        );
        
        assertTrue(
            isItem1SavedCorrectly && isItem2SavedCorrectly,
            "The inventory did not save item1 and item2 correctly."
        );
    }
}
