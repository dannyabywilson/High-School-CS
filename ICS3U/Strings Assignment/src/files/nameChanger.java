/*
Name: Daniel Wilson
Date: Tuesday september 29, 2026
Title: nameChanger
Description: Changes the format of a student's name based on their input
 */
package files;
import java.util.Scanner;

public class nameChanger {
    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their first name
        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();

        // Prompt the user for their last name
        System.out.println("What is your last name?");
        String lastName = scanner.nextLine();

        //Do required name Changes
        int numberLetters = firstName.length() + lastName.length();
        String nameCaps = firstName.toUpperCase();
        String nameLower = lastName.toLowerCase();
        String bothNames = firstName + " " + lastName;
        String lastBackwards = new StringBuilder(lastName).reverse().toString();

        //Display the results
        System.out.println("The total number of letters in your name is: " + numberLetters);
        System.out.println("Your first name in all caps is: " + nameCaps);
        System.out.println("Your last name in all lowercase is: " + nameLower);
        System.out.println("Your full name is: " + bothNames);
        System.out.println("Your last name backwards is: " + lastBackwards);
    }
}
