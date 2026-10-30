/*
Name: Daniel Wilson
Date: Tuesday september 29, 2026
Title: letterCounter
Description: counts how many of a specific character there are in a string
 */
package files;
import java.util.Scanner;

public class letterCounter {
    public static void main(String[] args) {

        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string: ");

        // Read the input string from the user
        String string = scanner.nextLine();

        // Prompt the user to enter a character to count
        System.out.println("Enter a character to count: ");
        Character character = scanner.next().charAt(0);

        //check whether character inputted is lower or upper case
        boolean countCaps = false;
        if (Character.isUpperCase(character)) {
            countCaps = true;
        }

        //covert string into lower/upper case as needed
        if (!countCaps){
            string = string.toLowerCase();
        }
        else {
            string = string.toUpperCase();
        }

        // Initialize a counter for the specified character
        int count = 0;

        // Count occurrences of the specified character in the string
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }

        // Display the count of the specified character
        System.out.println("The character '" + character + "' appears " + count + " time (s) in the string.");

    }
}