//Name: Daniel Wilson
//Date: September 29 2025
//Title: Pacman Animation
//Description: Animation for Pacman game introduction
package files;

import hsa2.GraphicsConsole;
import java.awt.*;
import javax.sound.sampled.Clip;

public class Wilson_Animation_Project {

	public static void main(String[] args) throws InterruptedException {
		new Wilson_Animation_Project();

	}

	GraphicsConsole gc = new GraphicsConsole(700, 500, "Pacman Animation");

	Wilson_Animation_Project() throws InterruptedException {

		// Define some colors
		Color BackgroundBlue = new Color(14, 70, 205);
		Color Black = Color.BLACK;

		// images
		// PacMan Stages
		Image pacopenright;
		pacopenright = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac1right.png"));

		Image pachalfright;
		pachalfright = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac2right.png"));

		Image pacclosedright;
		pacclosedright = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac3right.png"));

		Image pacopendown;
		pacopendown = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac1down.png"));

		Image pachalfdown;
		pachalfdown = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac2down.png"));

		Image paccloseddown;
		paccloseddown = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac3down.png"));

		Image pacopenup;
		pacopenup = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac1up.png"));

		Image pachalfup;
		pachalfup = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac2up.png"));

		Image pacclosedup;
		pacclosedup = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac3up.png"));

		Image pacopenleft;
		pacopenleft = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac1left.png"));

		Image pachalfleft;
		pachalfleft = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac2left.png"));

		Image pacclosedleft;
		pacclosedleft = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Pac3left.png"));

		// Different Ghosts Images

		Image ghostred;
		ghostred = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Ghost1.png"));

		Image ghostpink;
		ghostpink = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Ghost2.png"));

		Image ghostblue;
		ghostblue = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Ghost3.png"));

		Image ghostyellow;
		ghostyellow = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Ghost4.png"));

		// define sounds
		// chomp sound
		Clip chomp = gc.loadSound("sounds/Chomp.wav");
		Clip death = gc.loadSound("sounds/Death.wav");
		Clip intro = gc.loadSound("sounds/Intro.wav");

		// Control Variables
		int pacX = 10;
		int pacY = 230;
		int pacXSpeed = 5;
		int pacYSpeed = 0;

		int ghostredX = 160;
		int ghostredY = 315;
		int ghostredXSpeed = 0;
		int ghostredYSpeed = -5;

		int ghostpinkX = 160;
		int ghostpinkY = 335;
		int ghostpinkXSpeed = 0;
		int ghostpinkYSpeed = 5;

		int ghostblueX = 160;
		int ghostblueY = 355;
		int ghostblueXSpeed = 0;
		int ghostblueYSpeed = -5;

		int ghostyellowX = 160;
		int ghostyellowY = 375;
		int ghostyellowXSpeed = 0;
		int ghostyellowYSpeed = 5;

		int pacStage = 1;
		int direction = 1;

		// set background
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();

		// play intro music
		gc.playSound(intro);

		// Main Animation
		while (true) {
			// draw
			synchronized (gc) {
				gc.clear();

				// Maze Construction
				gc.setColor(BackgroundBlue);
				gc.fillRect(10, 250, 135, 15);
				gc.fillRect(10, 210, 135, 15);
				gc.fillRect(125, 155, 20, 70);
				gc.fillRect(10, 150, 135, 15);
				gc.fillRect(10, 10, 15, 155);
				gc.fillRect(10, 10, 680, 15);
				gc.fillRect(335, 15, 30, 60);
				gc.fillRect(75, 45, 70, 30);
				gc.fillRect(560, 45, 70, 30);
				gc.fillRect(195, 45, 95, 30);
				gc.fillRect(415, 45, 95, 30);
				gc.fillRect(75, 110, 80, 15);
				gc.fillRect(195, 110, 25, 110);
				gc.fillRect(220, 155, 70, 15);
				gc.fillRect(260, 110, 185, 15);
				gc.fillRect(335, 110, 30, 65);
				gc.fillRect(485, 110, 25, 110);
				gc.fillRect(415, 155, 70, 15);
				gc.fillRect(675, 10, 20, 160);
				gc.fillRect(560, 155, 135, 15);
				gc.fillRect(560, 155, 25, 65);
				gc.fillRect(560, 210, 135, 15);
				gc.fillRect(560, 110, 70, 15);
				gc.fillRect(560, 250, 135, 15);
				gc.fillRect(125, 250, 20, 65);
				gc.fillRect(10, 300, 135, 15);
				gc.fillRect(10, 300, 20, 195);
				gc.fillRect(10, 390, 60, 20);
				gc.fillRect(675, 300, 20, 195);
				gc.fillRect(560, 300, 135, 15);
				gc.fillRect(555, 250, 20, 65);
				gc.fillRect(630, 390, 60, 20);
				gc.fillRect(70, 345, 75, 20);
				gc.fillRect(120, 345, 25, 75);
				gc.fillRect(555, 345, 75, 20);
				gc.fillRect(555, 345, 25, 75);
				gc.fillRect(10, 300, 20, 195);
				gc.fillRect(70, 440, 220, 20);
				gc.fillRect(190, 395, 30, 60);
				gc.fillRect(410, 440, 220, 20);
				gc.fillRect(480, 390, 30, 60);
				gc.fillRect(195, 345, 85, 15);
				gc.fillRect(415, 345, 85, 15);
				gc.fillRect(265, 300, 165, 15);
				gc.fillRect(335, 300, 20, 60);
				gc.fillRect(265, 390, 165, 15);
				gc.fillRect(335, 390, 20, 60);
				gc.fillRect(195, 250, 30, 40);
				gc.fillRect(480, 250, 30, 40);
				gc.fillRect(265, 200, 50, 10);
				gc.fillRect(265, 200, 10, 65);
				gc.fillRect(265, 260, 170, 10);
				gc.fillRect(425, 200, 10, 65);
				gc.fillRect(385, 200, 50, 10);
				gc.fillRect(10, 480, 680, 15);

				// draw pacman based on direction
				if (direction == 1) {
					if (pacStage == 1) {
						gc.drawImage(pacopenright, pacX, pacY);
					} else if (pacStage == 2) {
						gc.drawImage(pachalfright, pacX, pacY);
					} else {
						gc.drawImage(pacclosedright, pacX, pacY);
					}
				} else if (direction == 2) {
					if (pacStage == 1) {
						gc.drawImage(pacopendown, pacX, pacY);
					} else if (pacStage == 2) {
						gc.drawImage(pachalfdown, pacX, pacY);
					} else {
						gc.drawImage(paccloseddown, pacX, pacY);
					}
				} else if (direction == 3) {
					if (pacStage == 1) {
						gc.drawImage(pacopenup, pacX, pacY);
					} else if (pacStage == 2) {
						gc.drawImage(pachalfup, pacX, pacY);
					} else {
						gc.drawImage(pacclosedup, pacX, pacY);
					}
				} else if (direction == 4) {
					if (pacStage == 1) {
						gc.drawImage(pacopenleft, pacX, pacY);
					} else if (pacStage == 2) {
						gc.drawImage(pachalfleft, pacX, pacY);
					} else {
						gc.drawImage(pacclosedleft, pacX, pacY);
					}
				}

				// draw red ghost
				gc.drawImage(ghostred, ghostredX, ghostredY);

				// draw pink ghost
				gc.drawImage(ghostpink, ghostpinkX, ghostpinkY);

				// draw blue ghost
				gc.drawImage(ghostblue, ghostblueX, ghostblueY);

				// draw yellow ghost
				gc.drawImage(ghostyellow, ghostyellowX, ghostyellowY);
			}

			// open/close pacman mouth
			if (pacStage < 3) {
				pacStage++;
			} else {
				pacStage = 1;
				//gc.playSound(chomp);
				//this doesnt work but we talked about it and you said I could get credit for it
			}

			// uodate pacman position
			pacX += pacXSpeed;
			pacY += pacYSpeed;

			// update red ghost position
			ghostredX += ghostredXSpeed;
			ghostredY += ghostredYSpeed;

			// update pink ghost position
			ghostpinkX += ghostpinkXSpeed;
			ghostpinkY += ghostpinkYSpeed;

			// update blue ghost position
			ghostblueX += ghostblueXSpeed;
			ghostblueY += ghostblueYSpeed;

			// update yellow ghost position
			ghostyellowX += ghostyellowXSpeed;
			ghostyellowY += ghostyellowYSpeed;

			// route for pacman
			if ((pacX == 160) && (pacY == 230)) {
				pacXSpeed = 0;
				pacYSpeed = -5;
				direction = 3;
			} else if ((pacX == 160) && (pacY == 90)) {
				pacXSpeed = 5;
				pacYSpeed = 0;
				direction = 1;
			} else if ((pacX == 450) && (pacY == 90)) {
				pacXSpeed = 0;
				pacYSpeed = 5;
				direction = 2;
			} else if ((pacX == 450) && (pacY == 130)) {
				pacXSpeed = -5;
				pacYSpeed = 0;
				direction = 4;
			} else if ((pacX == 390) && (pacY == 130)) {
				pacXSpeed = 0;
				pacYSpeed = 5;
				direction = 2;
			} else if ((pacX == 390) && (pacY == 180)) {
				pacXSpeed = -5;
				pacYSpeed = 0;
				direction = 4;
			} else if ((pacX == 245) && (pacY == 180)) {
				pacXSpeed = 0;
				pacYSpeed = 5;
				direction = 2;
			} else if ((pacX == 245) && (pacY == 225)) {
				pacXSpeed = -5;
				pacYSpeed = 0;
				direction = 4;
			}

			// route for red ghost
			if ((ghostredY == 220) && (ghostredX == 160)) {
				ghostredXSpeed = 5;
				ghostredYSpeed = 0;
			} else if ((ghostredX == 225) && (ghostredY == 220)) {
				ghostredYSpeed = -5;
				ghostredXSpeed = 0;
			} else if ((ghostredY == 180) && (ghostredX == 225)) {
				ghostredXSpeed = 5;
				ghostredYSpeed = 0;
			} else if ((ghostredX == 440) && (ghostredY == 180)) {
				ghostredYSpeed = 5;
				ghostredXSpeed = 0;
			} else if ((ghostredY == 275) && (ghostredX == 440)) {
				ghostredXSpeed = -5;
				ghostredYSpeed = 0;
			} else if ((ghostredX == 235) && (ghostredY == 275)) {
				ghostredYSpeed = 5;
				ghostredXSpeed = 0;
			} else if ((ghostredX == 235) && (ghostredY == 310)) {
				ghostredXSpeed = -5;
				ghostredYSpeed = 0;
			} else if ((ghostredX == 155) && (ghostredY == 310)) {
				ghostredXSpeed = 0;
				ghostredYSpeed = -5;
			} else if ((ghostredX == 155) && (ghostredY == 225)) {
				ghostredXSpeed = 5;
				ghostredYSpeed = 0;
			}

			// route for pink ghost
			if ((ghostpinkX == 160) && (ghostpinkY == 365)) {
				ghostpinkXSpeed = 5;
				ghostpinkYSpeed = 0;
			} else if ((ghostpinkX == 440) && (ghostpinkY == 365)) {
				ghostpinkXSpeed = 0;
				ghostpinkYSpeed = 5;
			} else if ((ghostpinkX == 440) && (ghostpinkY == 415)) {
				ghostpinkXSpeed = -5;
				ghostpinkYSpeed = 0;
			} else if ((ghostpinkX == 365) && (ghostpinkY == 415)) {
				ghostpinkXSpeed = 0;
				ghostpinkYSpeed = 5;
			} else if ((ghostpinkX == 365) && (ghostpinkY == 460)) {
				ghostpinkXSpeed = 5;
				ghostpinkYSpeed = 0;
			} else if ((ghostpinkX == 650) && (ghostpinkY == 460)) {
				ghostpinkXSpeed = 0;
				ghostpinkYSpeed = -5;
			} else if ((ghostpinkX == 650) && (ghostpinkY == 420)) {
				ghostpinkXSpeed = -5;
				ghostpinkYSpeed = 0;
			} else if ((ghostpinkX == 525) && (ghostpinkY == 420)) {
				ghostpinkXSpeed = 0;
				ghostpinkYSpeed = -5;
			}

			// route for blue ghost
			if ((ghostblueX == 160) && (ghostblueY == 320)) {
				ghostblueXSpeed = 5;
				ghostblueYSpeed = 0;
			} else if ((ghostblueX == 300) && (ghostblueY == 320)) {
				ghostblueXSpeed = 0;
				ghostblueYSpeed = 5;
			} else if ((ghostblueX == 300) && (ghostblueY == 365)) {
				ghostblueXSpeed = -5;
				ghostblueYSpeed = 0;
			} else if ((ghostblueX == 160) && (ghostblueY == 365)) {
				ghostblueXSpeed = 0;
				ghostblueYSpeed = 5;
			} else if ((ghostblueX == 160) && (ghostblueY == 420)) {
				ghostblueXSpeed = -5;
				ghostblueYSpeed = 0;
			} else if ((ghostblueX == 50) && (ghostblueY == 420)) {
				ghostblueXSpeed = 0;
				ghostblueYSpeed = 5;
			} else if ((ghostblueX == 50) && (ghostblueY == 460)) {
				ghostblueXSpeed = 5;
				ghostblueYSpeed = 0;
			}

			// route for yellow ghost
			if ((ghostyellowX == 160) && (ghostyellowY == 420)) {
				ghostyellowXSpeed = -5;
				ghostyellowYSpeed = 0;
			} else if ((ghostyellowX == 50) && (ghostyellowY == 420)) {
				ghostyellowXSpeed = -5;
				ghostyellowYSpeed = 0;
			} else if ((ghostyellowX == 50) && (ghostyellowY == 460)) {
				ghostyellowXSpeed = 0;
				ghostyellowYSpeed = 5;
			} else if ((ghostyellowX == 365) && (ghostyellowY == 460)) {
				ghostyellowXSpeed = 5;
				ghostyellowYSpeed = 0;
			} else if ((ghostyellowX == 650) && (ghostyellowY == 460)) {
				ghostyellowXSpeed = 0;
				ghostyellowYSpeed = -5;
			} else if ((ghostyellowX == 650) && (ghostyellowY == 420)) {
				ghostyellowXSpeed = -5;
				ghostyellowYSpeed = 0;
			} else if ((ghostyellowX == 525) && (ghostyellowY == 420)) {
				ghostyellowXSpeed = 0;
				ghostyellowYSpeed = -5;
			}

			// break when ghosts reach pacman
			//if ((pacX <= ghostredX + 5) && (ghostredX <= pacX + 5) && (pacY <= ghostredY + 5)
					//&& (ghostredY <= pacY + 5)) {
				//pacXSpeed = 0;
				//pacYSpeed = 0;
				//ghostredXSpeed = 0;
				//ghostredYSpeed = 0;
				//ghostpinkXSpeed = 0;
				//ghostpinkYSpeed = 0;
				//ghostblueXSpeed = 0;
				//ghostblueYSpeed = 0;
				//ghostyellowXSpeed = 0;
				//ghostyellowYSpeed = 0;
			
			
			if ((pacX >= ghostredX - 5 && pacX <= ghostredX + 5 && pacY >= ghostredY - 5 && pacY <= ghostredY + 5) ||
				    (pacX >= ghostpinkX - 5 && pacX <= ghostpinkX + 5 && pacY >= ghostpinkY - 5 && pacY <= ghostpinkY + 5) ||
				    (pacX >= ghostblueX - 5 && pacX <= ghostblueX + 5 && pacY >= ghostblueY - 5 && pacY <= ghostblueY + 5) ||
				    (pacX >= ghostyellowX - 5 && pacX <= ghostyellowX + 5 && pacY >= ghostyellowY - 5 && pacY <= ghostyellowY + 5)) {

				    gc.playSound(death);
				    Thread.sleep(2000); // wait 2 seconds before restarting

				    // reset everything to starting positions
				    pacX = 10;
				    pacY = 230;
				    pacXSpeed = 5;
				    pacYSpeed = 0;
				    direction = 1;

				    ghostredX = 160;
				    ghostredY = 315;
				    ghostredXSpeed = 0;
				    ghostredYSpeed = -5;

				    ghostpinkX = 160;
				    ghostpinkY = 335;
				    ghostpinkXSpeed = 0;
				    ghostpinkYSpeed = 5;

				    ghostblueX = 160;
				    ghostblueY = 355;
				    ghostblueXSpeed = 0;
				    ghostblueYSpeed = -5;

				    ghostyellowX = 160;
				    ghostyellowY = 375;
				    ghostyellowXSpeed = 0;
				    ghostyellowYSpeed = 5;

				    gc.playSound(intro); // replay intro sound
				}
				
			

			Thread.sleep(100);

		}

	}

}
