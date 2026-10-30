//Name: Daniel Wilson
//Date: September 15 2025
//Title: Pacman start screen
//Description: This Project is a Pacman start screen with intro music
package files;

import hsa2.GraphicsConsole;
import java.awt.*;
import javax.sound.sampled.Clip;

public class Wilson_Console_Output_Project {

	public static void main(String[] args) throws InterruptedException {
		new Wilson_Console_Output_Project();

	}

	GraphicsConsole gc = new GraphicsConsole(700, 500, 12, "Wilson_Console_Output_Project");

	Wilson_Console_Output_Project() {

		// Fonts
		Font MyTitle = new Font("Calibri", Font.BOLD, 30);
		Font Company = new Font("Monospaced", Font.BOLD, 12);

		// Define Some Colors
		Color BackgroundBlue = new Color(14, 70, 205);
		Color TextBoxRed = new Color(195, 48, 64);
		Color TextBoxOrange = new Color(250, 132, 45);
		Color TextYellow = new Color(241, 200, 64);
		Color Transparent = new Color(255, 255, 1, 0);
		Color CompanyTitleBox = new Color(245, 47, 47);

		// load images
		Image pacman;
		pacman = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/pacmancharacter.png"));
		Image ghost;
		ghost = Toolkit.getDefaultToolkit()
				.getImage(gc.getClass().getClassLoader().getResource("images/ghostcharacters.png"));

		// load music
		Clip backgroundmusic = gc.loadSound("sounds/pacman_beginning.wav");

		// Set Background Color
		gc.setBackgroundColor(Color.BLACK);
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

		// Pacman and Ghost
		gc.drawImage(pacman, 280, 185);
		gc.drawImage(ghost, 285, 365);

		// Text box
		gc.setColor(TextBoxRed);
		gc.fillRect(215, 110, 275, 70);
		gc.setColor(TextBoxOrange);
		gc.fillRect(220, 115, 265, 60);

		// Title
		gc.setFont(MyTitle);
		gc.setColor(Color.WHITE);
		gc.drawString("PAC-MAN", 273, 158);
		gc.setColor(TextYellow);
		gc.drawString("PAC-MAN", 275, 160);

		// Copyright Message
		gc.setBackgroundColor(Transparent);
		gc.setColor(Color.WHITE);
		gc.setCursor(2, 5);
		gc.println("1980 NAMCO LTD. All Rights Reserved");

		// Company Name background box
		gc.setColor(CompanyTitleBox);
		gc.fillOval(250, 75, 30, 30);
		gc.fillOval(425, 75, 30, 30);
		gc.fillRect(265, 75, 175, 30);
		// Company Name
		gc.setFont(Company);
		gc.setColor(Color.WHITE);
		gc.drawString("ARCADE GAME SERIES", 285, 95);

		// Play Sound
		gc.playSound(backgroundmusic);

	}

}
