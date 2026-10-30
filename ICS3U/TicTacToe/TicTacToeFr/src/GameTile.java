/*
Name: Daniel Wilson
Date: 16/10/2026
Title: GameTile.java
Description: This class represents a single tile in a TicTacToe game. It stores the owner of the tile, which can be either "X", "O", or an empty string if unowned. The class provides methods to get and set the owner, as well as to check if the tile is owned by any player.
 */


public class GameTile{
    /**Stores a String representing the owner "X" or "O" of a GameTile
     */
    protected String owner;
    /**Constructs a GameTile, sets owner to null by default
     */
    public GameTile (){
        owner = " ";
    }
    /**This will return who owns this particular GameTile
     *@return String "X" if player 1 owns tile, "Y" if player 2 owns tile, empty string if unowned
     */
    public String getOwner(){
        return owner;
    }
    /**This will assign a new owner to the game tile
     *@param player A String indicating which player will own the tile ("X" or "O")
     */
    public void setOwner(String player){
        owner = player;
    }
    /**This will determine whether any player owns a particular tile
     *@return boolean true if a player owns the tile, false otherwise
     */
    public boolean owned(){
        //Enter code for this method here
        boolean owned;
        if (owner.equals("X") || owner.equals("O")) {
            return true;
        }else {
            return false;
        }
    }
}