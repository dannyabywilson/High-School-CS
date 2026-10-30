/*
Name: Daniel Wilson
Date: Tuesday september 30, 2026
Title: captialChecker
Description: Checks whether a character typed into the console is a capital, lowercase, or integer
 */
package files;
import java.util.Scanner;

public class capitalChecker {
    public static void main(String[] args) {

        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        //Ask for user input
        System.out.println("Enter a single character: ");
        char character = scanner.next().charAt(0);

        //Check what kind of character it is and print the result
        if(Character.isUpperCase(character)){
            System.out.println("The character you have typed is capital.");
        }
        else if(Character.isLowerCase(character)){
            System.out.println("The character you have typed is a lowercase letter.");
        }
        else if(Character.isDigit(character)){
            System.out.println("The character you have typed is an integer");
        }
        else{
            System.out.println("The character you have typed is something else");
        }

    }
}
