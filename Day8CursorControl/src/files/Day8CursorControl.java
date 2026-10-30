package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class Day8CursorControl {

	public static void main(String[] args) {
		new Day8CursorControl ();

	}
	
	GraphicsConsole gc = new GraphicsConsole (500,500,"Examples");
	
	Day8CursorControl(){
		//Picture
		gc.println("* * * * *");
		gc.println("*");
		gc.setCursor(1,8);
		gc.println("*");
		gc.println("*");
		//gc.
		
	}

}
