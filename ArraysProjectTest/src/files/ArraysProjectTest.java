package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class ArraysProjectTest {

    public static void main(String[] args) throws InterruptedException {
        new ArraysProjectTest();
    }

    // Create graphics console
    GraphicsConsole gc = new GraphicsConsole(800, 800, 24);

    // Low stock threshold
    final int LOW_STOCK_THRESHOLD = 5;

    ArraysProjectTest() throws InterruptedException {

        // Initial inventory data
        String[] grocery_list = { "bananas", "bacon", "bread", "apples", "mango", "chocolate", "Sour patch kids" };
        int[] amount = { 8, 13, 700, 2, 5, 32, 7 };
        double[] price = { 5.00, 12.00, 6.00, 67.00, 20.00, 7.00, 14.00 };

        char input;
        int choice;
        boolean found;
        String search;

        while (true) {
            synchronized (gc) {
                gc.clear();
                gc.println("==== STORE INVENTORY ====");
                gc.println("");

                // Display inventory list
                for (int i = 0; i < grocery_list.length; i++) {
                    gc.println((i + 1) + ". " + grocery_list[i] + " - " + amount[i] + " units - $" + price[i]);
                }

                // Automatic low-stock warning
                boolean anyLow = false;
                for (int i = 0; i < grocery_list.length; i++) {
                    if (amount[i] < LOW_STOCK_THRESHOLD) {
                        gc.setColor(Color.RED);
                        gc.println("⚠ LOW STOCK: " + grocery_list[i] + " (" + amount[i] + " left)");
                        gc.setColor(Color.BLACK);
                        anyLow = true;
                    }
                }
                if (!anyLow) {
                    gc.println("All stock levels are healthy.");
                }

                // Display menu
                gc.println("");
                gc.println("=== MENU ===");
                gc.println("1. Add Item");
                gc.println("2. Delete Item");
                gc.println("3. Update Item");
                gc.println("4. Search Item");
                gc.println("5. Check Low Stock Items");
                gc.println("6. Restock Item");
                gc.println("7. Inventory Summary Report");
                gc.println("8. Exit");
                gc.println("");
                gc.println("Enter option number: ");
            }

            Thread.sleep(50);
            input = gc.getChar();

            // Add new item
            if (input == '1') {
                // Expand arrays
                String[] temp_list = new String[grocery_list.length + 1];
                int[] temp_amount = new int[amount.length + 1];
                double[] temp_price = new double[price.length + 1];

                for (int i = 0; i < grocery_list.length; i++) {
                    temp_list[i] = grocery_list[i];
                    temp_amount[i] = amount[i];
                    temp_price[i] = price[i];
                }

                grocery_list = temp_list;
                amount = temp_amount;
                price = temp_price;

                // Get new item data
                gc.println("Enter the name of the new item:");
                grocery_list[grocery_list.length - 1] = gc.readLine();

                gc.println("Enter the quantity (whole numbers only):");
                amount[amount.length - 1] = gc.readInt();

                gc.println("Enter the price:");
                price[price.length - 1] = gc.readDouble();
            }

            // Delete item
            else if (input == '2') {
                if (grocery_list.length == 0) {
                    gc.println("Inventory is empty! Press any key to continue.");
                    gc.getChar();
                    continue;
                }

                gc.println("Enter the item number to delete:");
                choice = gc.readInt();

                if (choice < 1 || choice > grocery_list.length) {
                    gc.println("Invalid choice. Press any key to continue.");
                    gc.getChar();
                    continue;
                }

                // Swap with last item
                grocery_list[choice - 1] = grocery_list[grocery_list.length - 1];
                amount[choice - 1] = amount[amount.length - 1];
                price[choice - 1] = price[price.length - 1];

                // Shrink arrays
                String[] temp_list = new String[grocery_list.length - 1];
                int[] temp_amount = new int[amount.length - 1];
                double[] temp_price = new double[price.length - 1];

                for (int i = 0; i < temp_list.length; i++) {
                    temp_list[i] = grocery_list[i];
                    temp_amount[i] = amount[i];
                    temp_price[i] = price[i];
                }

                grocery_list = temp_list;
                amount = temp_amount;
                price = temp_price;
            }

            // Update item
            else if (input == '3') {
                gc.println("Enter the item number to update:");
                choice = gc.readInt();

                if (choice < 1 || choice > grocery_list.length) {
                    gc.println("Invalid choice. Press any key to continue.");
                    gc.getChar();
                    continue;
                }

                gc.println("Enter new item name:");
                grocery_list[choice - 1] = gc.readLine();

                gc.println("Enter new quantity:");
                amount[choice - 1] = gc.readInt();

                gc.println("Enter new price:");
                price[choice - 1] = gc.readDouble();
            }

            // Search item
            else if (input == '4') {
                found = false;
                gc.println("Enter the item name to search:");
                search = gc.readLine();

                for (int i = 0; i < grocery_list.length; i++) {
                    if (grocery_list[i].equalsIgnoreCase(search)) {
                        gc.println("Found: " + grocery_list[i] + " - " + amount[i] + " units - $" + price[i]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    gc.println("Item not found.");
                }

                gc.println("Press any key to continue...");
                gc.getChar();
            }

            // Check low stock items
            else if (input == '5') {
                gc.clear();
                gc.println("=== Low Stock Items ===");

                boolean any = false;
                for (int i = 0; i < grocery_list.length; i++) {
                    if (amount[i] < LOW_STOCK_THRESHOLD) {
                        gc.println(grocery_list[i] + " is low (" + amount[i] + " left)");
                        any = true;
                    }
                }

                if (!any) {
                    gc.println("All items have healthy stock levels.");
                }

                gc.println("Press any key to return...");
                gc.getChar();
            }

            // Restock item
            else if (input == '6') {
                gc.println("Enter the item number to restock:");
                choice = gc.readInt() - 1;

                if (choice < 0 || choice >= grocery_list.length) {
                    gc.println("Invalid choice. Press any key to continue.");
                    gc.getChar();
                    continue;
                }

                gc.println("Enter the quantity to add:");
                int add = gc.readInt();

                amount[choice] += add;

                gc.println("Restocked successfully! New quantity: " + amount[choice]);
                gc.getChar();
            }

            // Inventory summary report
            else if (input == '7') {
                gc.clear();
                gc.println("=== Inventory Summary Report ===");

                int totalUnits = 0;
                double totalValue = 0;
                int minIndex = 0, maxIndex = 0;

                for (int i = 0; i < amount.length; i++) {
                    totalUnits += amount[i];
                    totalValue += amount[i] * price[i];

                    if (amount[i] < amount[minIndex]) minIndex = i;
                    if (amount[i] > amount[maxIndex]) maxIndex = i;
                }

                gc.println("Different items: " + grocery_list.length);
                gc.println("Total units in stock: " + totalUnits);
                gc.println("Total inventory value: $" + totalValue);
                gc.println("Lowest stock item: " + grocery_list[minIndex] + " (" + amount[minIndex] + ")");
                gc.println("Highest stock item: " + grocery_list[maxIndex] + " (" + amount[maxIndex] + ")");

                gc.println("Press any key to return...");
                gc.getChar();
            }

            // Exit
            else if (input == '8') {
                gc.clear();
                gc.println("Goodbye!");
                Thread.sleep(1000);
                gc.close();
            }

            // Invalid option
            else {
                gc.println("Invalid option. Press any key to continue...");
                gc.getChar();
            }
        }
    }
}
