package files;

import java.awt.*;
import hsa2.GraphicsConsole;

public class KeyboardInput {

	public static void main(String[] args) throws InterruptedException{
		new KeyboardInput();

	}
	
	GraphicsConsole gc = new GraphicsConsole (600,400);
	
	KeyboardInput()throws InterruptedException {
		
		int xr=0;
		int yr=0;
		
		int xb=200;
		int yb=200;
		
		while(true) {
			synchronized(gc) {
				gc.clear();
				//Drawing goes here
				gc.setColor(Color.RED);
				gc.fillRect(xr,  yr, 50, 50);
				
				gc.setColor(Color.BLUE);
				gc.fillRect(xb, yb, 50, 50);
			}
			Thread.sleep(5);
			
			//Control goes here
			if (gc.isKeyDown('D')) {
				xr+=5;
			}else if (gc.isKeyDown('A')) {
				xr-=5;
			}
			
			if (gc.isKeyDown('S')) {
				yr+=5;
			}else if (gc.isKeyDown('W')) {
				yr-=5;
			}
			
			//Control goes here
			if (gc.isKeyDown(GraphicsConsole.VK_RIGHT)) {
				xb+=5;
			}else if (gc.isKeyDown(GraphicsConsole.VK_LEFT)) {
				xb-=5;
			}
			
			if (gc.isKeyDown(GraphicsConsole.VK_DOWN)) {
				yb+=5;
			}else if (gc.isKeyDown(GraphicsConsole.VK_UP)) {
				yb-=5;
			}
				
			//logic for movement goes here
		}
	}

}
