/**
 * Class for Tic Tac Toe gameboard
 * @author Put Name Here
 */
package files;

public class GameBoard {
    /** An array of 9 GameTiles representing the TicTacToe gameboard */
    GameTile[] board;

    /** All 8 winning lines, as indexes into the board array */
    private static final int[][] WINS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},   // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},   // columns
            {0, 4, 8}, {2, 4, 6}               // diagonals
    };

    /** Constructs an empty gameboard of 9 GameTiles and fills it with unowned tiles */
    public GameBoard() {
        board = new GameTile[9];
        for (int i = 0; i < 9; i++)
            board[i] = new GameTile();
    }

    /**
     * Allows a player to claim a GameTile on the TicTacToe board
     * @param player A String indicating which player is to own the tile ("X" or "O")
     * @param tile An integer (1-9) representing the tile the player wishes to claim
     * @return true if the player successfully played on a tile, false if it is owned or out of bounds
     */
    public boolean play(String player, int tile) {
        if (tile < 1 || tile > 9)
            return false;
        if (board[tile - 1].owned())
            return false;
        board[tile - 1].setOwner(player);
        return true;
    }

    /**
     * Checks to see if there are three tiles in a row belonging to a player
     * @param player A String indicating which player to check for a win ("X" or "O")
     * @return true if the player has three tiles in a row, false otherwise
     */
    public boolean checkWin(String player) {
        for (int[] line : WINS) {
            if (player.equals(board[line[0]].getOwner())
                    && player.equals(board[line[1]].getOwner())
                    && player.equals(board[line[2]].getOwner()))
                return true;
        }
        return false;
    }

    /** Draws the current gameboard on the screen (empty cells show their number) */
    public void drawBoard() {
        for (int row = 0; row < 3; row++) {
            System.out.print(" ");
            for (int col = 0; col < 3; col++) {
                int i = row * 3 + col;
                if (board[i].owned())
                    System.out.print(board[i].getOwner());
                else
                    System.out.print(i + 1);
                if (col < 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (row < 2)
                System.out.println("---+---+---");
        }
    }

    /**
     * Removes the owner from a tile (used by the computer to test moves)
     * @param tile An integer (1-9)
     */
    public void undo(int tile) {
        if (tile >= 1 && tile <= 9)
            board[tile - 1].setOwner(null);
    }

    /**
     * Returns the board as a 9-character string, e.g. "XO-X-O---" ('-' = empty)
     * @return the board state
     */
    public String getState() {
        StringBuilder sb = new StringBuilder();
        for (GameTile t : board)
            sb.append(t.owned() ? t.getOwner() : "-");
        return sb.toString();
    }
}