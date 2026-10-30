package Files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class Day7PrintPractice {

	public static void main(String[] args) {
		new Day7PrintPractice ();

	}
	
	GraphicsConsole gc = new GraphicsConsole (500,500,"Examples");
	
	Day7PrintPractice (){
		//Typles of data
		gc.println("Hello\t");
		gc.println(4566);
		gc.println(45.32);
		
		//Setting cursor location
		gc.println(10,20);
		gc.println("Test");
	}

}
