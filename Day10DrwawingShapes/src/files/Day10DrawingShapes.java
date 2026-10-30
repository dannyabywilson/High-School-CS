package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class Day10DrawingShapes {

	public static void main(String[] args) {
		
		new Day10DrawingShapes ();
	
	}
		GraphicsConsole gc = new GraphicsConsole (600,500,20,"Colour Examples");
		
		Day10DrawingShapes(){
			
			gc.setBackgroundColor(new Color(45, 166, 247));
			gc.clear();
			
			gc.setColor(Color.YELLOW);
			gc.println("HELLO");
			
			gc.fillRect(200, 200, 200, 300);
			
			gc.setColor(new Color(247, 159, 45));
			int[] tri_x = {200, 300, 400};
			int[] tri_y = {200, 100, 200};
			gc.fillPolygon( tri_x, tri_y,tri_x.length);
			
			}
		

	}

