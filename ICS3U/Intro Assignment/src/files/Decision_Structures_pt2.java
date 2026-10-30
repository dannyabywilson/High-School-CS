/*
Name: Daniel Wilson
Date: September 17, 2026
Title: Decision Structure problems
Description: This program generates 15 random numbers between 10 and 50, displays them in the order they were generated, and then displays them in ascending order.
 */
package files;
import java.util.Random;
import java.util.Arrays;

public class Decision_Structures_pt2 {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] numbers = new int[15];


        for (int i = 0; i < 15; i++) {
            numbers[i] = rand.nextInt(41) + 10; // Random number between 10 and 50

            //list the numbers with commas without commas on the last one
            if (i == 14) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
            //Sort the Array
            Arrays.sort(numbers);

            //Seperate the ordered and unordered numbers with a line break
            System.out.println();

            //Displace the ordered numbers
            for (int i = 0; i < 15; i++) {
                if (i == 14) {
                    System.out.print(numbers[i]);
                } else {
                    System.out.print(numbers[i] + ", ");
                }
            }
    }
}
