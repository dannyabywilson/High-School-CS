package files;

import java.awt.*;
import hsa2.GraphicsConsole;

public class Day05Break {

	public static void main(String[] args) throws InterruptedException {
		new Day05Break();

	}

	GraphicsConsole gc = new GraphicsConsole(600, 400, "Day05Break");

	Day05Break() throws InterruptedException {
		int x = 0;
		int y = 175;
		
		int count = 0;

		while (true) {
			synchronized (gc) {
			gc.clear();
			gc.fillRect(x, y, 50, 50);
			
			}

			Thread.sleep(50);
			x+=5;

			if (x > 600) {
				x = -50;
				count++;
			}
			
			System.out.println(count);
			
			if (count==5) {
				System.out.println("Done");
				break;
				
			}

		}
	}

}