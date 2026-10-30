//Name: Daniel Wilson
//Date: Friday Oct 27
//Title: Pacman game
//Description: 1v1 pacman game against a friend
package files;

import java.awt.*;
import java.util.ArrayList;
import hsa2.GraphicsConsole;
import javax.sound.sampled.Clip;

public class MiniGame2 {

	public static void main(String[] args) throws InterruptedException {
		new MiniGame2();

	}
	
	GraphicsConsole gc = new GraphicsConsole(700, 500);
	
	MiniGame2() throws InterruptedException{
		//Load Images
		//Pacman
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
		
		//Ghost
		Image ghostred;
		ghostred = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/Ghost1.png"));
		
		//Load Sounds
		Clip chomp = gc.loadSound("sounds/Chomp.wav");
		Clip death = gc.loadSound("sounds/Death.wav");
		Clip intro = gc.loadSound("sounds/Intro.wav");
		
		// Play intro sound at start
		gc.playSound(intro);
		
		//Define Colors
		Color BackgroundBlue = new Color(14, 70, 205);
		Color Black = Color.BLACK;
		
		//Define Variables
		
		//pacman
		int pacX = 10;
		int pacY = 230;
		int pacXSpeed = 5;
		int pacYSpeed = 0;
		int oldpacX = 0;
		int oldpacY = 0;
		int pacStage = 1;
		int direction = 1;
		boolean dead = false;
		
		//Ghost
		int ghostredX = 160;
		int ghostredY = 315;
		int ghostredXSpeed = 0;
		int ghostredYSpeed = -5;
		int oldghostredX = 0;
		int oldghostredY = 0;
		
		//Timer setup
		long startTime = System.currentTimeMillis();
	    int timeLimit = 60; // 60 seconds

	    boolean gameOver = false;
	    
	    //collision detection with walls
	    ArrayList<Rectangle> walls = new ArrayList<>();
	    walls.add(new Rectangle(10, 250, 135, 15));
	    walls.add(new Rectangle(10, 210, 135, 15));
	    walls.add(new Rectangle(125, 155, 20, 70));
	    walls.add(new Rectangle(10, 150, 135, 15));
	    walls.add(new Rectangle(10, 10, 15, 155));
	    walls.add(new Rectangle(10, 10, 680, 15));
	    walls.add(new Rectangle(335, 15, 30, 60));
	    walls.add(new Rectangle(75, 45, 70, 30));
	    walls.add(new Rectangle(560, 45, 70, 30));
	    walls.add(new Rectangle(195, 45, 95, 30));
	    walls.add(new Rectangle(415, 45, 95, 30));
	    walls.add(new Rectangle(75, 110, 80, 15));
	    walls.add(new Rectangle(195, 110, 25, 110));
	    walls.add(new Rectangle(220, 155, 70, 15));
	    walls.add(new Rectangle(260, 110, 185, 15));
	    walls.add(new Rectangle(335, 110, 30, 65));
	    walls.add(new Rectangle(485, 110, 25, 110));
	    walls.add(new Rectangle(415, 155, 70, 15));
	    walls.add(new Rectangle(675, 10, 20, 160));
	    walls.add(new Rectangle(560, 155, 135, 15));
	    walls.add(new Rectangle(560, 155, 25, 65));
	    walls.add(new Rectangle(560, 210, 135, 15));
	    walls.add(new Rectangle(560, 110, 70, 15));
	    walls.add(new Rectangle(560, 250, 135, 15));
	    walls.add(new Rectangle(125, 250, 20, 65));
	    walls.add(new Rectangle(10, 300, 135, 15));
	    walls.add(new Rectangle(10, 300, 20, 195));
	    walls.add(new Rectangle(10, 390, 60, 20));
	    walls.add(new Rectangle(675, 300, 20, 195));
	    walls.add(new Rectangle(560, 300, 135, 15));
	    walls.add(new Rectangle(555, 250, 20, 65));
	    walls.add(new Rectangle(630, 390, 60, 20));
	    walls.add(new Rectangle(70, 345, 75, 20));
	    walls.add(new Rectangle(120, 345, 25, 75));
	    walls.add(new Rectangle(555, 345, 75, 20));
	    walls.add(new Rectangle(555, 345, 25, 75));
	    walls.add(new Rectangle(10, 300, 20, 195));
	    walls.add(new Rectangle(70, 440, 220, 20));
	    walls.add(new Rectangle(190, 395, 30, 60));
	    walls.add(new Rectangle(410, 440, 220, 20));
	    walls.add(new Rectangle(480, 390, 30, 60));
	    walls.add(new Rectangle(195, 345, 85, 15));
	    walls.add(new Rectangle(415, 345, 85, 15));
	    walls.add(new Rectangle(265, 300, 165, 15));
	    walls.add(new Rectangle(335, 300, 20, 60));
	    walls.add(new Rectangle(265, 390, 165, 15));
	    walls.add(new Rectangle(335, 390, 20, 60));
	    walls.add(new Rectangle(190, 250, 30, 40));
	    walls.add(new Rectangle(480, 250, 30, 40));
	    walls.add(new Rectangle(265, 200, 50, 10));
	    walls.add(new Rectangle(265, 200, 10, 65));
		walls.add(new Rectangle(265, 260, 170, 10));
		walls.add(new Rectangle(425, 200, 10, 65));
		walls.add(new Rectangle(385, 200, 50, 10));
		walls.add(new Rectangle(10, 480, 680, 15));
		
		//main game loop
		while (true) {
			synchronized (gc) {
				//set background color to black
				gc.clear();
				gc.setColor(Black);
				gc.fillRect(0, 0, 700, 500);
					
				// Maze Construction + Walls Collision
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
				gc.drawImage(ghostred, ghostredX, ghostredY, 20, 20);
				
				// open/close pacman mouth
				if (pacStage < 3) {
					pacStage++;
				} else {
					pacStage = 1;
					//gc.playSound(chomp);
					//this doesnt work but we talked about it and you said I could get credit for it
				}
				
				//Store old pacman position
				oldpacX = pacX;
				oldpacY = pacY;
				
				//Store old ghost position
				oldghostredX = ghostredX;
				oldghostredY = ghostredY;
				
				//storing the old character positions is so that we can put their positions back if they hit a wall
				//this creates the illusion of not being able to go into the walls
				
				// uodate pacman position
				pacX += pacXSpeed;
				pacY += pacYSpeed;

				// update red ghost position
				ghostredX += ghostredXSpeed;
				ghostredY += ghostredYSpeed;
				
				//make a rectangles for collision
				Rectangle pacRect = new Rectangle(pacX, pacY, 20, 20);
				Rectangle ghostredRect = new Rectangle(ghostredX, ghostredY, 20, 20);
				
				//check collisions
				for (Rectangle w : walls) {
					if (pacRect.intersects(w)) {
						pacX = oldpacX; //this makes the move undo if colldied with walls
						pacY = oldpacY;
						break;
					}
				}
				for (Rectangle w : walls) {
					if (ghostredRect.intersects(w)) {
						ghostredX = oldghostredX;
						ghostredY = oldghostredY;
						break;
					}
				}
				//check collision between two characters
				if ((pacX >= ghostredX - 5 && pacX <= ghostredX + 5 && pacY >= ghostredY - 5 && pacY <= ghostredY + 5)) {
					gc.playSound(death);
				    dead = true;
				}
				
				// Timer calculation
                long elapsed = (System.currentTimeMillis() - startTime) / 1000;
                int timeLeft = Math.max(0, timeLimit - (int) elapsed);
                
                // Draw timer
                gc.setColor(Color.WHITE);
                gc.setFont(new Font("Arial", Font.BOLD, 20));
                gc.drawString("Time Left: " + timeLeft, 550, 30);

                // When the time runs out
                if (timeLeft <= 0 && !dead) {
                    gameOver = true;
                }
				
                //pacman Control
				if (gc.isKeyDown('W')) {
				    pacXSpeed = 0;
				    pacYSpeed = -5;
				    direction = 3;
				} else if (gc.isKeyDown('S')) {
				    pacXSpeed = 0;
				    pacYSpeed = 5;
				    direction = 2;
				} else if (gc.isKeyDown('A')) {
				    pacXSpeed = -5;
				    pacYSpeed = 0;
				    direction = 4;
				} else if (gc.isKeyDown('D')) {
				    pacXSpeed = 5;
				    pacYSpeed = 0;
				    direction = 1;
				}
				
				//Ghost Control
				if (gc.isKeyDown(GraphicsConsole.VK_UP)) {
				    ghostredXSpeed = 0;
				    ghostredYSpeed = -5;
				} else if (gc.isKeyDown(GraphicsConsole.VK_DOWN)) {
					ghostredXSpeed = 0;
					ghostredYSpeed = 5;
				} else if (gc.isKeyDown(GraphicsConsole.VK_LEFT)) {
					ghostredXSpeed = -5;
					ghostredYSpeed = 0;
				} else if (gc.isKeyDown(GraphicsConsole.VK_RIGHT)) {
					ghostredXSpeed = 5;
					ghostredYSpeed = 0;
				}

			}
			//Reset the game when timer runs out OR pacman dies
			if (gameOver || dead) {
				Thread.sleep(2000);
				dead = false;
				gameOver = false;
				startTime = System.currentTimeMillis();
				
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
			    
			    gc.playSound(intro); // replay intro sound
			}
			Thread.sleep(33); // game speed
		}
	}
}
