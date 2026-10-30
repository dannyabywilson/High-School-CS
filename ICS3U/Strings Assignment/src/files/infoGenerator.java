/*
Name: Daniel Wilson
Date: Tuesday september 29, 2026
Title: infoGenerator
Description: Generates a username and email for a student based on their input
 */
package files;
import java.util.Scanner;

public class infoGenerator {
    public static void main(String[] args) {

        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their first name
        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();

        // Prompt the user for their last name
        System.out.println("What is your last name?");
        String lastName = scanner.nextLine();

        //Prompt the user for their student number
        System.out.println("What is your student number?");
        String studentNumber = scanner.nextLine();

        //Make the username of the student
        String username = firstName.substring(0,3).toLowerCase() + lastName.substring(0,3).toLowerCase() + studentNumber.substring(studentNumber.length() - 3, studentNumber.length());

        //Make the email of the student
        String email = username + "@medway.com";

        //Greeting Screen
        System.out.println("Hello "+firstName+" "+lastName+"! Your new username is "+username+" and your email is "+email+".");
    }
}
