package files;

import java.awt.*;
import hsa2.GraphicsConsole;

public class Day04FlowControl {

	public static void main(String[] args) throws InterruptedException {
		new Day04FlowControl();

	}

	GraphicsConsole gc = new GraphicsConsole(500, 600, "Day04FlowControl");

	Day04FlowControl() throws InterruptedException {
		int x = 1;
		
		
		
		
		
		while (true) {
			gc.clear();
			
			if (x % 2 == 0) {
				gc.setColor(Color.BLUE);
			} else {
				gc.setColor(Color.RED);

			}
			
			gc.fillRect(x, 200, 100, 100);
			Thread.sleep(20);
			

			x++;

			if (x > gc.getDrawWidth()) {
				x = -100;
			}

			
		}
	}

}
