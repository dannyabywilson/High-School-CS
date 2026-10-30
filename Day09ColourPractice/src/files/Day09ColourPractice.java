package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class Day09ColourPractice {

	public static void main(String[] args) {
		new Day09ColourPractice();
		

	}
	
	GraphicsConsole gc = new GraphicsConsole (600,500,20,"Colour Examples");
			
	Day09ColourPractice(){
		gc.setColor(Color.WHITE);
		gc.setBackgroundColor(new Color(7,76,80));
		gc.clear();
		
		gc.setCursor(gc.getNumRows()/2,(gc.getNumColumns()/2)-6);
		gc.setColor(Color.RED);
		gc.print("R");
		gc.setColor(Color.ORANGE);
		gc.print("A");
		gc.setColor(Color.YELLOW);
		gc.print("I");
		gc.setColor(Color.GREEN);
		gc.print("N");
		gc.setColor(Color.CYAN);
		gc.print("B");
		gc.setColor(Color.BLUE);
		gc.print("O");
		gc.setColor(Color.MAGENTA);
		gc.print("W");
		
	}

}
