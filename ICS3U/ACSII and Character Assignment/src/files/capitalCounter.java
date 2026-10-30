/*
Name: Daniel Wilson
Date: Tuesday september 30, 2026
Title: capitalCounter
Description: Counts how many capital/lowercase characters are in a string
 */
package files;
import java.util.Scanner;

public class capitalCounter {
    public static void main(String[] args) {

        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string: ");

        // Read the input string from the user
        String input = scanner.nextLine();

        // Initialize counters for capital and lowercase letters
        int capitalCount = 0;
        // Count capital letters
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (Character.isUpperCase(character)) {
                capitalCount++;
            }
        }

        int lowercaseCount = 0;
        // Count lowercase letters
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (Character.isLowerCase(character)) {
                lowercaseCount++;
            }
        }

        // Display the counts of capital and lowercase letters
        System.out.println("Number of capital letters: " + capitalCount);
        System.out.println("Number of lowercase letters: " + lowercaseCount);
    }
}