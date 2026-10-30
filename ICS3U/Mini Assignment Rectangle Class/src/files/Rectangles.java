/*
 Name: Daniel Wilson
 Date: Friday, Septemeber 25, 2026
 Title: Rectangles
 Description: Assignment creating rectangles and checking for empty rectangles and squares
 */
package files;
import java.awt.Rectangle;

public class Rectangles {
    public static void main(String[] args) {

        Rectangle[] rectangles = new Rectangle[5];
        //Ask schryvers if he cares wheteher  the rectangle w/h order matters cuz technically width and height are switched in the doc compared to actual code
        rectangles[0] = new Rectangle(2, 5, 10, 10);
        rectangles[1] = new Rectangle(3, 3, 2, 7);
        rectangles[2] = new Rectangle();
        rectangles[3] = new Rectangle(0, 0, 3, 8);
        rectangles[4] = new Rectangle(8, 3, 4, 4);

        System.out.println("Rectangles:");
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + (i + 1) + ":" + rectangles[i].toString());
        }

        System.out.println(" ");
        System.out.println("Empty Rectangles:");
        boolean foundEmpty = false;
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].isEmpty()) {
                System.out.println("Rectangle " + (i + 1) + " is empty.");
                foundEmpty = true;
            }
        }

        if (foundEmpty == false) {
            System.out.println("No empty rectangles found.");
        }

        System.out.println("");
        int squareCount = 0;
        for (int i = 0; i < rectangles.length; i++) {
            if(rectangles[i].isEmpty()) {
                squareCount--;
            }
            if (rectangles[i].getWidth() == rectangles[i].getHeight()) {
                squareCount++;
            }
        }
        System.out.println("Number of squares: " + squareCount);
    }
}
