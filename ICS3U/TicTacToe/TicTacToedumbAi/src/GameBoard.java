/*
Name: Daniel Wilson
Date: 16/10/2026
Title: GameBoard.java
Description: This class represents the TicTacToe gameboard. It contains an array of 9 GameTiles and provides methods to play moves and check for wins.
 */
public class GameBoard {
    /**An array of 9 GameTiles representing the TicTacToe gameboard
     */
    GameTile[] board;
    /**Constructs an empty gameboard of 9 GameTiles and fills it with unowned tiles
     */
    public GameBoard(){
        board = new GameTile[9];
        for (int i = 0; i < 9; i++)
            board[i] = new GameTile();
    }
    /**This will allow a player to claim a GameTile on the TicTacToe board
     *@return A boolean true if the player successfully played on a tile, false if that tile is already owned or the index is out of bounds
     *@param player A String indicating which player is to own the tile ("X" or "O")
     *@param tile An integer representing the tile the player wishes to claim
     */
    public boolean play(String player, int tile){
        //Enter code for this method here
        if (tile < 1 || tile > 9) {
            return false;
        } else if (board[tile - 1].owned()) {
            return false;
        } else{
            board[tile - 1].setOwner(player);
            return true;
        }

    }
    /**This will check to see if there are three tiles in a row belonging to a player
     *@return A boolean true if the player has three tiles in a row, false otherwise
     *@param player A String indicating which player to check for a win ("X" or "O")
     */
    public boolean checkWin(String player) {
        if (board[0].getOwner().equals(player) && board[1].getOwner().equals(player) && board[2].getOwner().equals(player)) {
            return true;
        } else if (board[3].getOwner().equals(player) && board[4].getOwner().equals(player) && board[5].getOwner().equals(player)) {
            return true;
        } else if (board[6].getOwner().equals(player) && board[7].getOwner().equals(player) && board[8].getOwner().equals(player)) {
            return true;
            // columns
        } else if (board[0].getOwner().equals(player) && board[3].getOwner().equals(player) && board[6].getOwner().equals(player)) {
            return true;
        } else if (board[1].getOwner().equals(player) && board[4].getOwner().equals(player) && board[7].getOwner().equals(player)) {
            return true;
        } else if (board[2].getOwner().equals(player) && board[5].getOwner().equals(player) && board[8].getOwner().equals(player)) {
            return true;
            // diagonals
        } else if (board[0].getOwner().equals(player) && board[4].getOwner().equals(player) && board[8].getOwner().equals(player)) {
            return true;
        } else if (board[2].getOwner().equals(player) && board[4].getOwner().equals(player) && board[6].getOwner().equals(player)) {
            return true;
        } else {
            return false;
        }


    }
    /**This will draw the current gameboard on the screen
     */
    public void drawBoard(){
        //Enter code for this method here
    System.out.println(board[0].getOwner()+" | "+board[1].getOwner()+ " | "+board[2].getOwner());
    System.out.println("----------");
    System.out.println(board[3].getOwner()+" | "+board[4].getOwner()+ " | "+board[5].getOwner());
    System.out.println("----------");
    System.out.println(board[6].getOwner()+" | "+board[7].getOwner()+ " | "+board[8].getOwner());
    }
}//end class