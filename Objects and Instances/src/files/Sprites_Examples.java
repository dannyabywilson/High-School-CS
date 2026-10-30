package files;

import java.awt.*;
import hsa2.GraphicsConsole;

public class Sprites_Examples {

   public static void main(String[] args) throws InterruptedException {
       new Sprites_Examples();
   }

   GraphicsConsole gc = new GraphicsConsole(800, 500);

   Sprites_Examples() throws InterruptedException {

       Sprites[] s = new Sprites[500];

       for (int i = 0; i < s.length; i++) {
           s[i] = new Sprites();
           s[i].x = (int) (Math.random() * (800));
           s[i].y = (int) (Math.random() * (500));
           s[i].w = 10;
           s[i].h = 10;
           s[i].speed = (int) (Math.random() * (5) + 5);
       }

       gc.setBackgroundColor(Color.BLACK);
       gc.setColor(Color.WHITE);
       while (true) {
           synchronized (gc) {
               gc.clear();

               for (int i = 0; i < s.length; i++) {
                   gc.fillOval(s[i].x, s[i].y, s[i].w, s[i].h);
               }
           }
           Thread.sleep(50);

           for (int i = 0; i < s.length; i++) {
               s[i].y += s[i].speed;
               if (s[i].y>500) {
                   s[i].x = (int) (Math.random() * (800));
                   s[i].w = 10;
                   s[i].h = 10;
                   s[i].y = 0-s[i].h;
                   s[i].speed = (int) (Math.random() * (5) + 10);
               }
           }

       }
   }
}