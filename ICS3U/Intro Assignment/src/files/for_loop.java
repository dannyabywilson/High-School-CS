/*
Name: Daniel Wilson
Date: September 17, 2026
Title: For Loop problems
Description: This program demonstrates the use of for loops, while loops, and do-while loops to solve various problems. It includes nested loops and conditional statements to print specific sequences of numbers and characters.
 */

package files;

public class for_loop {
    public static void main(String[] args) {
    /*
        for (int i = 1; i<3; i++) {
            for (int j =2; j<21; j++) {
                System.out.println(j);
            }
        }
        */
        /*
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);

            for (int j = 97; j <= 101; j += 2) {
                System.out.print((char) j);
            }

            System.out.println();
        }
        */

        // Using a while loop

        int num = 25;

        while (num >= 15) {

            if (num % 2 == 1) {

                System.out.println(num);

            }

            num--;

        }

        System.out.println();

        // Using a do-while loop

        num = 25;

        do {

            if (num % 2 != 0) {

                System.out.println(num);

            }

            num--;

        } while (num >= 15);


    }
}

