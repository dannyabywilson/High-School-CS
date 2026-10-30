/**
 * Class for Tic-Tac-Toe tile
 * @author Put name here
 */
package files;

public class GameTile {
    /** Stores a String representing the owner "X" or "O" of a GameTile, null if unowned */
    protected String owner;

    /** Constructs a GameTile, sets owner to null by default */
    public GameTile() {
        owner = null;
    }

    /**
     * Returns who owns this particular GameTile
     * @return String "X" if player 1 owns tile, "O" if player 2 owns tile, null if unowned
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Assigns a new owner to the game tile
     * @param player A String indicating which player will own the tile ("X" or "O")
     */
    public void setOwner(String player) {
        owner = player;
    }

    /**
     * Determines whether any player owns a particular tile
     * @return boolean true if a player owns the tile, false otherwise
     */
    public boolean owned() {
        return owner != null;
    }
}