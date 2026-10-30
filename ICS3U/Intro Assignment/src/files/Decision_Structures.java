/*
Name: Daniel Wilson
Date: September 17, 2026
Title: Decision Structure problems
Description: This program generates 15 random numbers between 10 and 50, calculates the sum, mean, largest, smallest, and mode of the numbers, and displays the results.
 */
package files;
import java.util.Random;

public class Decision_Structures {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] numbers = new int[15];

        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int sum = 0;
        int largestNumber = 0;
        int smallest = 50;
        for (int i = 0; i < 15; i++) {

            numbers[i] = rand.nextInt(41) + 10; // Random number between 10 and 50

            //list the numbers with commas without commas on the last one
            if (i == 14) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }


            //find the sum of the numbers
            sum += numbers[i];

            //find largest number
            if (numbers[i] > largestNumber) {
                largestNumber = numbers[i];
            }

            //find smallest number
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }

        //find the mode of the numbers
        int[] counts = new int[numbers.length];
        int maxCount = 0;

        for (int i = 0; i<numbers.length; i++) {
            int count = 0;
            for (int j = 0; j<numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            counts[i] = count;
            if (count > maxCount) {
                maxCount = count;
            }
        }


        //seperate the array from the largest value. Before they used to combine to one line
        System.out.println(" ");
        //find the mean of the numbers
        double mean = (double) sum / numbers.length;

        System.out.println("The largest value is " + largestNumber);
        System.out.println("The smallest value is " + smallest);
        System.out.println("The sum is " + sum);
        System.out.println("The mean is " + mean);

        //Incase theres no mode, print that there is no mode
        if (maxCount == 1) {
            System.out.println("There is no mode.");
        }else {
            //Print the mode(s) seperately... idk how to do it the way you did it in the example, but this works
            System.out.print("The mode(s) is/are: ");
            boolean first = true;
            for (int i = 0; i < numbers.length; i++) {
                if (counts[i] == maxCount) {
                    boolean alreadyPrinted = false;
                    for (int j = 0; j < i; j++) {
                        if (numbers[j] == numbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (alreadyPrinted == false) {
                        if (first == false) {
                            System.out.print(", ");
                        }
                        System.out.print(numbers[i]);
                        first = false;
                    }
                }
            }
        }
    }
}
