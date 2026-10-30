/* Name: Daniel Wilson
 * Date: Tuesday November 25th
 * Title: Shape Calculator
 * Description: Calculate different things in a shape
 */

//import necessary items
package files;

import java.awt.*;
import hsa2.GraphicsConsole;
import java.lang.Math;

public class Shape_Calculator {
    public static void main(String args[]) {
        new Shape_Calculator();
    }
    //Make graphics console
    GraphicsConsole gc = new GraphicsConsole(800, 800, 24);

    //main loops
    Shape_Calculator (){
        //define variables
        char input;
        double w;
        double l;
        double h;
        double b;
        double d;

        while(true) {

            //menu options
            gc.clear();
           gc.println("Welcome to Shape Calculator");
           gc.println("Please enter your choice:");
           gc.println("1. Area of Rectangle");
           gc.println("2. Perimeter of Rectangle");
           gc.println("3. Area of triangle");
           gc.println("4. Hypotenuse of triangle");
           gc.println("5. Volume of box");
           gc.println("6. Exit");

           //Recieve user option
            input = gc.getChar();

            //Calculate area of rectangle
            if (input == '1'){
                gc.println("What is the width of the rectangle?");
                w = gc.readDouble();
                gc.println("What is the length of the rectangle?");
                l = gc.readDouble();;
                gc.println("Area of rectangle: " + calculateAreaRect(w,l));
                gc.println("Press any key to continue");
                gc.getChar();

                //Perimeter of a rectangle
            } else if (input == '2'){
                gc.println("What is the width of the rectangle?");
                w = gc.readDouble();
                gc.println("What is the length of the rectangle?");
                l = gc.readDouble();;
                gc.println("Perimeter of rectangle: " + calculateAreaRect(w,l));
                gc.println("Press any key to continue");
                gc.getChar();

                //Calculate Area of a triangle
            } else if (input == '3'){
                gc.println("What is the base of the triangle?");
                b = gc.readDouble();
                gc.println("What is the height of the triangle?");
                h = gc.readDouble();
                gc.println("Area of triangle: " + calculateAreaTri(b,h));
                gc.println("Press any key to continue");
                gc.getChar();

                //Calculate Hypotenuse of triangle
            }else if (input == '4'){
                gc.println("What is the base of the triangle?");
                b = gc.readDouble();
                gc.println("What is the height of the triangle?");
                h = gc.readDouble();
                gc.println("Hypotenuse of triangle: ");
                calculateHypotenuseTri(b,h,gc);
                //gc.println("Press any key to continue");
                gc.getChar();


                //Calculate volume of a box
            }else if (input == '5'){
                gc.println("What is the base of the box? ");
                b = gc.readDouble();
                gc.println("What is the length of the box?");
                l = gc.readDouble();
                gc.println("What is the depth of box? ");
                d = gc.readDouble();
                gc.println("Volume of the box: ");
                calculateVolumeBox(b,l,d,gc);
                gc.getChar();

            } else if (input == '6') {
                gc.close();
            }
        }


    }

    //Calculation for area of a rectangle
    static double calculateAreaRect(double width, double length){
        double RectA = width * length;
        return RectA;
    }

    //Calculation for perimeter of a rectangle
    static double calculatePerimeterRect(double width, double length){
        double PerimA = 2*(width+length);
        return PerimA;
    }

    //Calculation for area of a triangle
    static double calculateAreaTri(double base, double height){
        double TriA = 0.5*(base*height);
        return TriA;
    }

    //Calculation for hypotenuse of a triangle
    static void calculateHypotenuseTri(double base, double height, GraphicsConsole gc){
        double TriHyp =Math.sqrt((base*base)+(height*height));;
        gc.println(TriHyp);
        gc.println("Press any key to continue");
    }

    //Calculation for volume of a box
    static void calculateVolumeBox(double base, double length, double depth, GraphicsConsole gc){
        double VolumeBox = base*length*depth;
        gc.println(VolumeBox);
        gc.println("Press any key to continue");
    }
}
