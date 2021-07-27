/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.mthree.simplecalculator;

import java.util.Scanner;

/**
 * Operation IDs:
 * 0    add
 * 1    subtract
 * 2    multiply
 * 3    divide
 * 4    exit
 * @author Steven
 */
public class App {
    public static void main(String[] args) {
        int operationID;
        
        // Prompts and runs operations until exit
        operationID = promptOperation();
        while (operationID != 4) {
            runOperation(operationID);
            operationID = promptOperation();
        }
        
        System.out.println("\nThank you.");
    }
    
    /**
     * Prompts the user to select an operation or exit
     * @return the user's selection
     */
    private static int promptOperation() {
        String input;
        int selection;
        
        Scanner inputReader = new Scanner(System.in);
        
        do {
            System.out.println("\nSelect an operation:\nAdd, Subtract, Multiply, Divide, or Exit");

            input = inputReader.nextLine();
            
            switch (input.toLowerCase()) {
                case "add":
                    selection = 0;
                    break;
                case "subtract":
                    selection = 1;
                    break;
                case "multiply":
                    selection = 2;
                    break;
                case "divide":
                    selection = 3;
                    break;
                case "exit":
                    selection = 4;
                    break;
                default:
                    selection = -1;
            }
        } while (selection < 0);
        
        return selection;
    }
    
    /**
     * Prompts the user for 2 operands and then runs the calculator operation
     * @param operationID
     * @return the result from the operation
     */
    private static double runOperation(int operationID) {
        double number1, number2, result;
        
        Scanner inputReader = new Scanner(System.in);
        
        // Prompt for the first operand
        do {
            try {
                System.out.println("\nInput first operand:");
                number1 = inputReader.nextDouble();
            } catch (Exception e) {
                continue;
            }
            break;
        } while (true);
        
        // Prompt for the second operand
        do {
            try {
                System.out.println("\nInput second operand:");
                number2 = inputReader.nextDouble();
            } catch (Exception e) {
                continue;
            }
            break;
        } while (true);
        
        // Run the operation
        switch (operationID) {
            case 0:
                result = SimpleCalculator.add(number1, number2);
                break;
            case 1:
                result = SimpleCalculator.subtract(number1, number2);
                break;
            case 2:
                result = SimpleCalculator.multiply(number1, number2);
                break;
            case 3:
                result = SimpleCalculator.divide(number1, number2);
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        
        System.out.println("\nResult:\n" + result);
        return result;
    }
}
