/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 04 Aug 2021
 */

package com.mthree.vendingmachine.controller;

import com.mthree.vendingmachine.dao.InsufficientFundsException;
import com.mthree.vendingmachine.dao.ItemNotFoundException;
import com.mthree.vendingmachine.dao.ManagerService;
import com.mthree.vendingmachine.dto.NoItemInventoryException;
import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.CoinType;
import com.mthree.vendingmachine.dto.Item;
import com.mthree.vendingmachine.ui.View;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Steven
 */
public class Controller {
    final private View view;
    final private ManagerService manager;
    
    /**
     * Create a new Controller given the view and manager
     * @param view the user interface
     * @param manager the dao service
     */
    public Controller(View view, ManagerService manager) {
        this.view = view;
        this.manager = manager;
    }
    
    /**
     * Run the controller
     */
    public void run() {
        MainMenuOption menuSelection;
        
        // Iteratively prompts for a menu selection and handles the selection
        MainMenu: do {
            menuSelection = promptMainMenu();
            switch(menuSelection) {
                case BUY_ITEM:
                    purchaseItem();
                    break;
                case ADD_MONEY:
                    addBalance();
                    break;
                case EXIT:
                    break MainMenu;
            }
        } while (true);
        
        close();
    }
    
    /**
     * Prompt the main menu
     * @return the user's selection on the main menu
     */
    private MainMenuOption promptMainMenu() {
        MainMenuOption menuSelection;
        String input;
        String[] items;
        
        // Prompts for a menu selection
        menuSelection = null;
        do {
            displayAllItems();
            input = view.promptString("\nWhat would you like to do?" +
                "\nBUY - select an item to purchase" +
                "\nADD - add money into your balance" +
                "\nEXIT - exit the app"
            );
            
            switch(input.toLowerCase()) {
                case "buy":
                    menuSelection = MainMenuOption.BUY_ITEM;
                    break;
                case "add":
                    menuSelection = MainMenuOption.ADD_MONEY;
                    break;
                case "exit":
                    menuSelection = MainMenuOption.EXIT;
                    break;
            }
        } while (menuSelection == null);
        
        return menuSelection;
    }
    
    /**
     * Prompt the user to add money
     */
    private void addBalance() {
        Change insertedChange;
        BigDecimal newBalance;
        CoinType[] coinTypes = { CoinType.QUARTER, CoinType.DIME, CoinType.NICKEL, CoinType.PENNY };
        int[] coinsInserted = new int[coinTypes.length];
        
        // Prompts the user for each coin type
        for (int i = 0; i < coinTypes.length; i++) {
            coinsInserted[i] = view.promptNaturalNumber("How many " + coinTypes[i].name() + " will you insert?");
        }
        
        // Adds the change
        insertedChange = new Change(coinsInserted[0], coinsInserted[1], coinsInserted[2], coinsInserted[3]);
        newBalance = manager.addBalance(insertedChange);
        
        view.say("\nYour new balance is $" + newBalance + ".");
    }
    
    /**
     * Prompt the user to select an item to purchase if the user has enough money
     */
    private void purchaseItem() {
        BigDecimal balance;
        String selectedItemName;
        Item selectedItem;
        
        // Checks if the user has balance
        balance = manager.getBalance();
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            view.say("\nPlease insert money first.");
            return;
        }
        
        // Prompts the user for an item
        selectedItemName = view.promptString("Please select an item (case sensitive).");
        
        // Purchases the item
        try {
            balance = manager.purchaseItem(selectedItemName);
        } catch (NoItemInventoryException e) {
            view.say("\nThis item is not available for purchase.");
            return;
        } catch (InsufficientFundsException e) {
            view.say("\nYou do not have enough balance for this item. You have $" + balance + ".");
            return;
        } catch (ItemNotFoundException e) {
            view.say("\nThis item does not exist.");
            return;
        }
        
        view.say("\nPurchased. Your new balance is $" + balance + ".");
    }
    
    /**
     * Displays all items in the inventory
     */
    private void displayAllItems() {
        List<String> itemNames;

        itemNames = Arrays.asList(manager.getAllItems());
        
        // Generate the table of items
        view.say("========================================");
        itemNames.stream()
            .forEach((name) -> {
                Item item;
                
                item = manager.getItem(name);
                view.say(item.getStock() + "pc\t$" + item.getCost() + "\t" + item.getName());
            })
        ;
    }
    
    /**
     * Closes the controller and manager
     */
    private void close() {
        Change change;
        
        change = manager.close();
        view.say("Thank you for using our vending machine. Your change is " +
            "\n\t" + change.get(CoinType.QUARTER) + " Quarters" +
            "\n\t" + change.get(CoinType.DIME) + " Dimes" +
            "\n\t" + change.get(CoinType.NICKEL) + " Nickels" +
            "\n\t" + change.get(CoinType.PENNY) + " Pennies."
        );
    }
}
