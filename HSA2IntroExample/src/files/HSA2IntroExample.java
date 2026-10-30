package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class HSA2IntroExample {

	public static void main(String[] args) {
		
		new HSA2IntroExample();

	}
	
	GraphicsConsole gc = new GraphicsConsole(800,600,120,"Daniel Wilson's Example");
	GraphicsConsole gc2 = new GraphicsConsole(900,600,90,"Daniel Wilson's Example 2");
	
	HSA2IntroExample(){
		gc.print(67);
		gc2.print("Hello Class");
		
	}
}
