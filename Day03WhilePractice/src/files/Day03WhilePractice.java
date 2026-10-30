package files;

import java.awt.*;

public class Day03WhilePractice {

	public static void main(String[] args) throws InterruptedException {
		new Day03WhilePractice ();

		int line = 1;
		
		while (line <= 100){
			
			System.out.println(line);
			Thread.sleep(100);
			line += 1;
		}
		
	}

}
