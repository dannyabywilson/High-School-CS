package files;

import hsa2.GraphicsConsole;
import java.awt.*;

public class TextAndImages {

	public static void main(String[] args) {
		new TextAndImages();

	}
	
	GraphicsConsole gc = new GraphicsConsole (600,500,20,"Text And Images");
	
	TextAndImages() {
		
		//Create Font
		Font MyTitle = new Font("Arial",Font.BOLD,30);
		
		//Create background color
		Color PumpkinOrange = new Color (252, 164, 10);
		
		//Image
		Image Rocket;
		
		Rocket = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource("images/Rocket.png"));
		
		
		
		//Set color and font
		gc.setBackgroundColor(PumpkinOrange);
		gc.clear();
		gc.setFont(MyTitle);
		
		//Draw Text
		gc.drawString("Hello Class", 200, 300);
		gc.drawImage(Rocket, 100,50);
		
	}

}
