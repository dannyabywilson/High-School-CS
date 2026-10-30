package files;

import java.awt.*;
import hsa2.GraphicsConsole;

public class Sprites_Examples {

    public static void main(String[] args) throws InterruptedException {
        new Sprites_Examples();
    }

    GraphicsConsole gc = new GraphicsConsole(800, 500);


    //main
    Sprites_Examples() throws InterruptedException {
        int n;
        //prompt user for number of snowflakes
        gc.print("How many snowflakes do you want?");
        n = gc.readInt();

        //invoke method to set up snow
        Sprites[] s = SetUpSnow(n);
        while (true) {

            //invoke method to draw snow
            drawSnow(gc, s);
            Thread.sleep(50);

            //invoke method to update snow position
            s=updateSnow(gc,s);

        }
    }


    //setting up initial snow position
    static Sprites[] SetUpSnow(int numSnowFlakes) {

        //Set number of snowflakes
        Sprites[] snowflakes = new Sprites[numSnowFlakes];

        //invoke method for 1 snowflake, repeat for entire array
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Sprites();
            snowflakes[i] = oneFlake ();
        }
        return snowflakes;
    }

    //receive snowflake parameters, and draw
    static void drawSnow(GraphicsConsole c, Sprites[] snow) {
        c.setBackgroundColor(Color.BLACK);
        c.setColor(Color.WHITE);
        synchronized (c) {
            c.clear();

            for (int i = 0; i < snow.length; i++) {
                if (snow[i].type == Sprites.Type.Rectangle) {
                    c.fillRect(snow[i].x, snow[i].y, snow[i].w, snow[i].h);
                } else if (snow[i].type == Sprites.Type.Leaf) {
                    c.fillMapleLeaf(snow[i].x, snow[i].y, snow[i].w, snow[i].h);
                } else if (snow[i].type == Sprites.Type.Oval) {
                    c.fillOval(snow[i].x, snow[i].y, snow[i].w, snow[i].h);
                }
            }
        }

    }


    //Move snowflake and reset
    static Sprites [] updateSnow (GraphicsConsole g, Sprites [] snow) {

        for (int i = 0; i < snow.length; i++) {

            //move snowflake
            snow[i].y += snow[i].speed;
            if (snow[i].y > g.getDrawHeight()) {

                //reset snowflake if it leaves screen
                snow[i]=oneFlake();
            }
        }
        return snow;
    }

    //randomize the parameters for 1 snowflake
    static Sprites oneFlake () {
        Sprites snowflakes = new Sprites();
        snowflakes.x = (int) (Math.random() * (800));
        snowflakes.y = (int) (Math.random() * (500)-500);
        snowflakes.w = 10;
        snowflakes.h = 10;
        snowflakes.speed = (int) (Math.random() * (5) + 5);
        int shape = (int) (Math.random() * (3) + 1);
        if (shape == 1) {
            snowflakes.type = Sprites.Type.Leaf;
        } else if (shape == 2) {
            snowflakes.type = Sprites.Type.Oval;
        } else {
            snowflakes.type = Sprites.Type.Rectangle;
        }
        return snowflakes;
    }

}