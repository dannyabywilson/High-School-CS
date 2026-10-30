/* Name: Daniel Wilson
 * Date: Tuesday November 25th
 * Title: Store Inventory
 * Description: Keep track and use assistive tools for inventory in a store
 */

//Import necessary items
package files;

import hsa2.GraphicsConsole;
import java.io.*;
import java.util.*;

public class ArraysProject {

    public static void main(String[] args) throws InterruptedException {
        new ArraysProject();
    }

    // create graphics console
    GraphicsConsole gc = new GraphicsConsole(800, 800, 24);

    ArraysProject() throws InterruptedException {

        File InFile = new File("/Users/danielwilson/Library/CloudStorage/GoogleDrive-701010486@gotvdsb.ca/.shortcut-targets-by-id/1JPaCAcaJRRqU8GYGu0vcEP5AFEcFOkV4/30 Daniel/ICS3U/Arrays Project/InFile.txt");

        String[] grocery_list =new String[0];
        int[] amount = new int[0];
        double[] price = new double[0];
        try {

            Scanner freader = new Scanner(InFile);
            String line1;
            int line2;
            double line3;
            int count=0;

            while (freader.hasNextLine()) {

                String[] temp_list = new String[grocery_list.length + 1];
                int[] temp_amount = new int[amount.length + 1];
                double[] temp_price = new double[price.length + 1];

                // Step 2 - Transfer from old array to new larger array
                for (int i = 0; i < grocery_list.length; i++) {
                    temp_list[i] = grocery_list[i];
                    temp_amount[i] = amount[i];
                    temp_price[i] = price[i];
                }
                // Step 3 - Re-assign to old array name
                grocery_list = temp_list;
                amount = temp_amount;
                price = temp_price;

                grocery_list[grocery_list.length - 1] = freader.nextLine();
                amount[amount.length - 1] = freader.nextInt();
                price[price.length - 1] = freader.nextDouble();

                count++;

            }
            freader.close();
        } catch (IOException e) {

            System.err.println(e);
            System.exit(1);
        }

        // Define variables
        /*String[] grocery_list = { "bananas", "bacon", "bread", "apples", "mango", "chocolate", "Sour patch kids" };
        int[] amount = { 8, 13, 700, 2, 5, 32, 7 };
        double[] price = { 5.00, 12.00, 6.00, 67.00, 20.00, 7.00, 14.00 };
        *\
         */
        int LowStock = 5;
        int choice = 0;
        char input;
        String search;
        boolean found = false;
        int totalunits = 0;
        int totalvalue = 0;
        int minIndex = 0;
        int maxindex = 0;
        int totalItems = 0;
        int totalCost = 0;

        while (true) {
            synchronized (gc) {
                gc.clear();
                gc.println("Store Inventory: "); // Title of program
                gc.println("");

                for (int i = 0; i < grocery_list.length; i++) {
                    gc.println(" ___ " + (i + 1) + ". " + grocery_list[i] + " - " + amount[i] + " - $" + price[i]); // prints
                    // each
                    // array
                    // to
                    // form
                    // a
                    // list
                }

                // Display the options available for user
                // Display options
                gc.println("");
                gc.println("Menu");
                gc.println("1. Add an item to list");
                gc.println("2. Delete an item from list");
                gc.println("3. Search an item from list");
                gc.println("4. Update an item from list");
                gc.println("5. Check Low Stock Items");
                gc.println("6. Restock Item");
                gc.println("7. Inventory Summary Report");
                gc.println("8. Exit");
                gc.println("");
                gc.println("Enter the option number: ");
            }

            // read which option the user wants to select
            input = gc.getChar();

            if (input == '8') {// exit the program code
                gc.clear();
                gc.println("Good-bye!");
                Thread.sleep(1000);
                gc.close();
            } else if (input == '1') {// add an item to the list
                // Step 1 - create temp array
                String[] temp_list = new String[grocery_list.length + 1];
                int[] temp_amount = new int[amount.length + 1];
                double[] temp_price = new double[price.length + 1];
                // Step 2 - Transfer from old array to new larger array
                for (int i = 0; i < grocery_list.length; i++) {
                    temp_list[i] = grocery_list[i];
                    temp_amount[i] = amount[i];
                    temp_price[i] = price[i];
                }
                // Step 3 - Re-assign to old array name
                grocery_list = temp_list;
                amount = temp_amount;
                price = temp_price;

                // Step 4 - prompt user and add new item, quantity, and price
                gc.println("");
                gc.println("What is the name of the new item? ");
                grocery_list[grocery_list.length - 1] = gc.readLine();

                gc.println("");
                gc.println("What is the amount of the new item? (Whole numbers only) ");
                amount[amount.length - 1] = gc.readInt();

                gc.println("");
                gc.println("What is the price of the new item? ");
                price[price.length - 1] = gc.readDouble();

            } else if (input == '2') {// delete an item from the list
                // Step 1 - create temp array
                String[] temp_list = new String[grocery_list.length - 1];
                int[] temp_amount = new int[amount.length - 1];
                double[] temp_price = new double[price.length - 1];

                // Step 2 - swap the item you want to delete, with the item last in the list
                gc.println("What item do you want to delete? Enter the item number: ");
                choice = gc.readInt();

                grocery_list[choice - 1] = grocery_list[grocery_list.length - 1];
                amount[choice - 1] = amount[amount.length - 1];
                price[choice - 1] = price[price.length - 1];

                // Step 3 - transfer data from old array to new array, leave off last value.
                for (int i = 0; i < temp_list.length; i++) {
                    temp_list[i] = grocery_list[i];
                    temp_amount[i] = amount[i];
                    temp_price[i] = price[i];
                }

                // Step 4 - set old array equal to new array
                grocery_list = temp_list;
                amount = temp_amount;
                price = temp_price;

            } else if (input == '3') {// search for an item
                // reset found to false
                found = false;

                // Ask what we're searching for
                gc.println("What item are you searching for: ");
                search = gc.readLine();
                gc.println("Searching for " + search + "...");

                // Check if the item is in the list
                for (int i = 0; i < grocery_list.length; i++) {
                    if (grocery_list[i].equals(search)) {
                        gc.println("Found it! " + grocery_list[i] + " $" + price[i] + " Press any key to go back.");
                        found = true;
                        break;
                    } else {
                        found = false;
                    }

                }

                if (found == false) {
                    gc.println("No luck! " + search + " wasn't found. Press any key to go back.");
                }
                // waits for user to press a key to go back to the beginning
                gc.getChar();

            } else if (input == '4') {// update an item
                gc.println("What item do you want t oupdate? Enter the item number: ");
                choice = gc.readInt();

                gc.println("What is the new item name? ");
                grocery_list[choice - 1] = gc.readLine();

                gc.println("What is the new item quantity? Whole numbers only! ");
                amount[choice - 1] = gc.readInt();

                gc.println("What is the new item price? ");
                price[choice - 1] = gc.readDouble();

            } else if (input == '5') {// Shows items that have low stock
                gc.clear();
                gc.println("Low Stock Items: ");

                boolean restock = false;
                for (int i = 0; i < grocery_list.length; i++) {
                    if (amount[i] < LowStock) {// low stock is defined at the top and if any item has an ammount less
                        // than 5 the warning will appear
                        gc.println(grocery_list[i] + " is low, there is " + amount[i] + " left");
                        restock = true;
                    }
                }
                if (restock == false) {
                    gc.println("All items have a good amount of stock.");
                }

                gc.println("Press any key to return.");
                gc.getChar();

            } else if (input == '6') {// quicker alternative option to restock items rather than updating the item and
                // retyping out all the details
                boolean founditem = false;

                while (founditem == false) {
                    gc.println("Enter the item number you would like to restock: ");
                    choice = gc.readInt();
                    if (choice < 0 || choice > grocery_list.length) {
                        gc.println("Invalid Choice, press any key to continue");
                        gc.getChar();
                    }else {
                        founditem = true;
                    }

                }
                gc.println("What is the new item quantity? Whole numbers only! ");
                amount[choice - 1] = gc.readInt() + amount[choice - 1];

            } else if (input == '7') {
                gc.clear();
                gc.println("Inventory summary report: ");
                totalItems = 0;
                totalCost = 0;
                boolean restock = false;

                for (int i = 0; i < grocery_list.length; i++) {
                    totalItems += amount[i];
                    totalCost += price[i];

                    if (amount[i] < LowStock) {
                        gc.println(grocery_list[i] + " is low, there is " + amount[i] + " left");
                        restock = true;
                    }
                }

                gc.println("total amount of inventory: " + totalItems);
                gc.println("total value of inventory: " + totalCost);

                if (restock == true) {
                    gc.println("Low stock warning: Yes");
                } else {
                    gc.println("low stock warning: No");
                }
                gc.println("Press any key to return.");
                gc.getChar();

            } else {
                gc.print("Not A Valid Function");

            }


        }

        //File outFile = new File("/Users/danielwilson/Library/CloudStorage/GoogleDrive-701010486@gotvdsb.ca/.shortcut-targets-by-id/1JPaCAcaJRRqU8GYGu0vcEP5AFEcFOkV4/30 Daniel/ICS3U/Arrays Project/InFile.txt");

        //try{

        //}












    }
}
