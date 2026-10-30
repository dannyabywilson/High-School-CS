/*
Name: Daniel Wilson
Date: 16/10/2026
Title: playTicTacToe2.java
Description: This class represents the main game loop for a TicTacToe game. It handles player input, game state management, and win condition checking.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class playTicTacToe2 {
    public static void main (String args[])throws Exception{
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
        GameBoard game = new GameBoard();//makes a blank gameboard
        String player1, player2;
        int turn = 0;
        int index;
        boolean errorFlag;
        boolean gameOver = false;
        System.out.print("Please Enter Player's Name: ");
        player1 = keyboard.readLine();
        System.out.println("Press ENTER to continue");
        keyboard.readLine();
        System.out.println();
        System.out.println();
        game.drawBoard();
        System.out.println();
        System.out.println();
        while (gameOver == false){
            errorFlag = false;
            if (turn % 2 == 0){//if it is player 1's turn
                do{
                    System.out.print(player1+ " enter your choice (1-9): ");
                    index = Integer.parseInt(keyboard.readLine());//Assumes a valid number is entered
                    errorFlag = game.play("X", index);
                    if (errorFlag == false)
                        System.out.println("That square is already taken or invalid.  Try again");
                }while (errorFlag == false);//makes sure player enters a square not yet used
                System.out.println();
                System.out.println();
                game.drawBoard();
                System.out.println();
                System.out.println();
                if(game.checkWin("X")){
                    System.out.println(player1 + ", YOU WIN!!");
                    gameOver = true;
                }
            }
            else{//player 2s turn
                do{
                    index = new Random().nextInt(9) + 1; // Randomly selects a number between 1 and 9
                    errorFlag = game.play("O", index);
                }
                while (errorFlag == false);//makes sure player enters a square not yet used
                System.out.println();
                System.out.println();
                game.drawBoard();
                System.out.println();
                System.out.println();
                if(game.checkWin("O")){
                    System.out.println( "BOT WINS!!");
                    gameOver = true;
                }

            }
            turn++;
            if (turn == 9 && gameOver == false){
                gameOver = true;
                System.out.println("DRAW");
            }
        }//end while
    }//end main
}//end class
