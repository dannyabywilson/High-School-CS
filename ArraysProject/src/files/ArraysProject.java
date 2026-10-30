package files;

import hsa2.GraphicsConsole;
import java.awt.*;
import java.io.*;
import java.util.*;

public class ArraysProject {

	public static void main(String[] args) throws InterruptedException {
		new ArraysProject();
	}

	GraphicsConsole gc = new GraphicsConsole(800, 800, 24);

	ArraysProject() throws InterruptedException {

		String[] itemlist = {};
		int[] amount = {};
		double[] price = {};
		int choice;
		char input;
		String search;
		boolean found = false;
		
		File inFile = new File("inventory.txt");
		
		try {
			if (inFile.exists()) {
				Scanner freader = new Scanner(inFile);
				ArrayList <String> itemList = new ArrayList<>();
				ArrayList<Integer> amountList = new ArrayList<>();
				ArrayList<Double> priceList = new ArrayList<>();
				
				while (freader.hasNextLine()) {
					String line = freader.nextLine();
					String[] parts = line.split(",");
				}
			}
		}

		while (true) {
			synchronized (gc) {
				gc.clear();
				gc.println("Inventory: ");
				for (int i = 0; i < itemlist.length; i++) {
					gc.println(" ___ " + (i + 1) + ". " + itemlist[i] + " - " + amount[i] + " - $" + price[i]);
				}

				// Display options
				gc.println("");
				gc.println("What would you like to do?");
				gc.println("1. Add an item to list");
				gc.println("2. Delete an item from list");
				gc.println("3. Search an item from list");
				gc.println("4. Update an item from list");
				gc.println("5. Exit");
				gc.println("");
				gc.println("Enter the option number: ");
			}

			Thread.sleep(50);
			input = gc.getChar();

			if (input == '5') {
				gc.clear();
				gc.println("Good-bye!");
				Thread.sleep(1000);
				gc.close();
			} else if (input == '1') {
				// Step 1 - create temp array
				String[] temp_list = new String[itemlist.length + 1];
				int[] temp_amount = new int[amount.length + 1];
				double[] temp_price = new double[price.length + 1];
				// Step 2 - Transfer from old array to new larger array
				for (int i = 0; i < itemlist.length; i++) {
					temp_list[i] = itemlist[i];
					temp_amount[i] = amount[i];
					temp_price[i] = price[i];
				}
				// Step 3 - Re-assign to old array name
				itemlist = temp_list;
				amount = temp_amount;
				price = temp_price;

				// Step 4 - prompt user and add new item, quantity, and price
				gc.println("");
				gc.println("What is the name of the new item? ");
				itemlist[itemlist.length - 1] = gc.readLine();

				gc.println("");
				gc.println("What is the amount of the new item? (Whole numbers only) ");
				amount[amount.length - 1] = gc.readInt();

				gc.println("");
				gc.println("What is the price of the new item? ");
				price[price.length - 1] = gc.readDouble();

			} else if (input == '2') {
				// Step 1 - create temp array
				String[] temp_list = new String[itemlist.length - 1];
				int[] temp_amount = new int[amount.length - 1];
				double[] temp_price = new double[price.length - 1];

				// Step 2 - swap the item you want to delete, with the item last in the list
				gc.println("What item do you want to delete? Enter the item number: ");
				choice = gc.readInt();

				itemlist[choice - 1] = itemlist[itemlist.length - 1];
				amount[choice - 1] = amount[amount.length - 1];
				price[choice - 1] = price[price.length - 1];

				// Step 3 - transfer data from old array to new array, leave off last value.
				for (int i = 0; i < temp_list.length; i++) {
					temp_list[i] = itemlist[i];
					temp_amount[i] = amount[i];
					temp_price[i] = price[i];
				}

				// Step 4 - set old array equal to new array
				itemlist = temp_list;
				amount = temp_amount;
				price = temp_price;

			} else if (input == '3') {
				// reset found to false
				found = false;

				// Ask what we're searching for
				gc.println("What item are you searching for: ");
				search = gc.readLine();
				gc.println("Searching for " + search + "...");

				// Check if the item is in the list
				for (int i = 0; i < itemlist.length; i++) {
					if (itemlist[i].equals(search)) {
						gc.println("Found it! " + itemlist[i] + " $" + price[i] + " Press any key to go back.");
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

			} else if (input == '4') {
				gc.println("What item do you want t oupdate? Enter the item number: ");
				choice = gc.readInt();

				gc.println("What is the new item name? ");
				itemlist[choice - 1] = gc.readLine();

				gc.println("What is the new item quantity? Whole numbers only! ");
				amount[choice - 1] = gc.readInt();

				gc.println("What is the new item price? ");
				price[choice - 1] = gc.readDouble();

			} else {
				gc.print("Not A Valid Function");

			}

		}

	}
}
