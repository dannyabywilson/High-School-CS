package files;

import hsa2.GraphicsConsole;
import java.awt.Color;

public class ICS3URecap {
    public static void main(String[] args) {
        // 1. Create a GraphicsConsole object named gc
        GraphicsConsole gc = new GraphicsConsole(400, 400, "Target Painter");

        gc.print("Enter target color: ");
        String colorChoice = gc.readLine();

        // 2. Draw outer red circle
        gc.setColor(Color.RED);
        gc.fillOval(50, 50, 200, 200);

        // 3. Draw inner label
        gc.setColor(Color.WHITE);
        gc.drawString("Color choice: " + colorChoice, 100, 150);
    }
}