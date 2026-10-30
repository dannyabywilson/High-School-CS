//Name: Daniel
//Date: Friday Oct 17
//Title: Math Trivia
//Description: Quick Math quiz to refresh your math skills
package files;

import java.awt.*;
import hsa2.GraphicsConsole;

public class Day05MiniGame {

	public static void main(String[] args) throws InterruptedException {
		new Day05MiniGame();

	}

	GraphicsConsole gc = new GraphicsConsole(600, 400);

	Day05MiniGame() throws InterruptedException {
		// Load Images
		Image Q1;
		Q1 = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource("images/Math1.png"));

		Image Q2;
		Q2 = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource("images/Math2.png"));

		Image Q3;
		Q3 = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource("images/Math3.png"));

		Image Q4;
		Q4 = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource("images/Math4.png"));

		Image Q5;
		Q5 = Toolkit.getDefaultToolkit().getImage(gc.getClass().getClassLoader().getResource("images/Math5.png"));

		// define colors
		Color backgroundblue = new Color(3, 227, 252);
		// define variables
		int Imagex = 135;
		int Imagey = 75;
		int ImageWidth = 300;
		int ImageHeight = 200;
		int q = 0;
		int score = 0;
		boolean win = false;
		char input;

		while (true) {
			synchronized (gc) {
				//Set the Background Color and Score Counter
				gc.setBackgroundColor(backgroundblue);
				gc.clear();
				gc.drawString("Score: "+score, 500, 20);
				// Start Screen
				if (q == 0) {
					gc.drawString("Welcome to Math Trivia, press space to start", 150, 200);
				//Question 1 Screen
				} else if (q == 1) {
					gc.drawString("Solve This Problem", 225, 50);
					gc.drawImage(Q1, Imagex, Imagey, ImageWidth, ImageHeight);
					gc.drawString("Options:", 250, 295);
					gc.drawString("A) 9.7", 50, 325);
					gc.drawString("B) 1", 200, 325);
					gc.drawString("C) 19", 350, 325);
					gc.drawString("D) 5", 500, 325);
				//Question 2 Screen
				} else if (q == 2) {
					gc.drawString("Solve This Problem", 225, 50);
					gc.drawImage(Q2, Imagex, Imagey, ImageWidth, ImageHeight);
					gc.drawString("Options:", 250, 295);
					gc.drawString("A) 10", 50, 325);
					gc.drawString("B) 1", 200, 325);
					gc.drawString("C) 9", 350, 325);
					gc.drawString("D) 15", 500, 325);
				//Question 3 Screen
				} else if (q == 3) {
					gc.drawString("Solve This Problem", 225, 50);
					gc.drawImage(Q3, Imagex, Imagey, ImageWidth, ImageHeight);
					gc.drawString("Options:", 250, 295);
					gc.drawString("A) 10", 50, 325);
					gc.drawString("B) 1", 200, 325);
					gc.drawString("C) 19", 350, 325);
					gc.drawString("D) 25", 500, 325);
				//Question 4 Screen
				} else if (q == 4) {
					gc.drawString("Solve This Problem", 225, 50);
					gc.drawImage(Q4, Imagex, Imagey, ImageWidth, ImageHeight);
					gc.drawString("Options:", 250, 295);
					gc.drawString("A) 14", 50, 325);
					gc.drawString("B) 11", 200, 325);
					gc.drawString("C) 23", 350, 325);
					gc.drawString("D) 6", 500, 325);
				//Question 5 Screen
				} else if (q == 5) {
					gc.drawString("Solve This Problem", 225, 50);
					gc.drawImage(Q5, Imagex, Imagey, ImageWidth, ImageHeight);
					gc.drawString("Options:", 250, 295);
					gc.drawString("A) -17", 50, 325);
					gc.drawString("B) -13", 200, 325);
					gc.drawString("C) -41", 350, 325);
					gc.drawString("D) -67", 500, 325);
				//End screen
				} else if (q == 6) {
					if (win) {
						gc.drawString("You Won! Great Job!! press space to play again", 165, 200); //Win Message
					} else {
						gc.drawString("*Womp Womp*... press space to try again", 175, 200); // Loss Message
					}
				}

			}
			Thread.sleep(1);
			//Answer Key: BCDBB
			input = gc.getChar();
			if (q == 0) {
				if (input == ' ') { //Press space to move to first question
					q++;
				}
			} else if (q == 1) {
				if (input == 'b') {
					score++; //Puts up the score if you correctly answer
				}
				q++; //moves to next question after any input is received
			} else if (q == 2) {
				if (input == 'c') {
					score++;
				}
				q++;
			} else if (q == 3) {
				if (input == 'd') {
					score++;
				}
				q++;
			} else if (q == 4) {
				if (input == 'b') {
					score++;
				}
				q++;
			} else if (q == 5) {
				if (input == 'b') {
					score++;
				}
				q++;
				
				//Checks if user won or lost. Decided if score is greater than 3
				if (score >= 3) {
					win = true;
				} else {
					win = false;
				}
			//End Screen
			} else if (q == 6) {
				//If you press space then it will restart the game and reset score + win status
				if (input == ' ') {
					q = 0;
					score = 0;
					win = false;
				}
			}

		}

	}

}
