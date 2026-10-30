/**
 * Tic-Tac-Toe: two players, or a human (X) vs the computer (O).
 * Computer levels:
 *   2 = random moves
 *   3 = smart moves (win if possible, block if needed, else random), no learning
 *   4 = random moves that avoid known losing boards; learns whenever the human wins
 * @author Put Name Here
 */
package files;

import java.io.*;
import java.util.*;

public class playTicTacToe {
    static final String LOSING_FILE = "losing.txt";
    static final Random rand = new Random();
    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Choose a mode:");
        System.out.println("  1 - Two players");
        System.out.println("  2 - Vs computer: Random");
        System.out.println("  3 - Vs computer: Smart (no learning)");
        System.out.println("  4 - Vs computer: Learning");
        int mode;
        do {
            System.out.print("Mode: ");
            mode = readInt();
        } while (mode < 1 || mode > 4);

        Set<String> losing = loadLosing();
        if (mode == 4)
            System.out.println("Known losing boards: " + losing.size());

        System.out.print("Please Enter Player 1's Name: ");
        String player1 = keyboard.readLine();
        System.out.println(player1 + " you are X's");
        String player2 = "Computer";
        if (mode == 1) {
            System.out.print("Please Enter Player 2's Name: ");
            player2 = keyboard.readLine();
        }
        System.out.println(player2 + " you are O's");

        boolean again = true;
        while (again) {
            playGame(mode, player1, player2, losing);
            System.out.print("Play again? (y/n): ");
            String ans = keyboard.readLine();
            again = ans != null && ans.trim().equalsIgnoreCase("y");
        }
    }

    static void playGame(int mode, String player1, String player2, Set<String> losing) throws IOException {
        GameBoard game = new GameBoard();
        String lastComputerState = null;   // board right after the computer's latest move
        System.out.println("\n");
        game.drawBoard();
        System.out.println();

        for (int turn = 0; turn < 9; turn++) {
            boolean p1Turn = (turn % 2 == 0);
            String mark = p1Turn ? "X" : "O";
            String name = p1Turn ? player1 : player2;
            boolean computerTurn = (mode != 1 && !p1Turn);

            if (computerTurn) {
                int move = chooseMove(game, mode, losing);
                if (move == -1) {
                    System.out.println("Computer forfeits! " + player1 + " wins!");
                    return;
                }
                game.play(mark, move);
                lastComputerState = game.getState();
                System.out.println("Computer plays " + move + ":");
            } else {
                boolean ok;
                do {
                    System.out.print(name + " enter your choice (1-9): ");
                    ok = game.play(mark, readInt());
                    if (!ok)
                        System.out.println("That square is already taken or invalid.  Try again");
                } while (!ok);
            }

            System.out.println("\n");
            game.drawBoard();
            System.out.println();

            if (game.checkWin(mark)) {
                System.out.println(name + ", YOU WIN!!");
                if (mode == 4 && p1Turn && lastComputerState != null)
                    learn(lastComputerState, losing);
                return;
            }
        }
        System.out.println("DRAW");
    }

    /** Returns the computer's tile (1-9), or -1 if it forfeits */
    static int chooseMove(GameBoard game, int level, Set<String> losing) {
        List<Integer> empty = new ArrayList<>();
        for (int t = 1; t <= 9; t++)
            if (!game.board[t - 1].owned())
                empty.add(t);

        if (level == 2)
            return empty.get(rand.nextInt(empty.size()));

        if (level == 3) {
            int win = findWinningMove(game, "O", empty);
            if (win != -1) return win;
            int block = findWinningMove(game, "X", empty);
            if (block != -1) return block;
            return empty.get(rand.nextInt(empty.size()));
        }

        // Level 4: random among moves whose resulting board is not a known losing board
        List<Integer> safe = new ArrayList<>();
        for (int t : empty) {
            game.play("O", t);
            if (!losing.contains(game.getState()))
                safe.add(t);
            game.undo(t);
        }
        if (safe.isEmpty())
            return -1;   // every option is a known loss: forfeit
        return safe.get(rand.nextInt(safe.size()));
    }

    /** Finds a tile that gives 'player' an immediate win, or -1 if none */
    static int findWinningMove(GameBoard game, String player, List<Integer> empty) {
        for (int t : empty) {
            game.play(player, t);
            boolean wins = game.checkWin(player);
            game.undo(t);
            if (wins) return t;
        }
        return -1;
    }

    /** Remembers a losing board in memory and in the text file */
    static void learn(String state, Set<String> losing) {
        if (losing.add(state)) {
            try (PrintWriter out = new PrintWriter(new FileWriter(LOSING_FILE, true))) {
                out.println(state);
                System.out.println("(Computer learned a new losing board: " + state + ")");
            } catch (IOException e) {
                System.out.println("Could not save to " + LOSING_FILE);
            }
        }
    }

    static Set<String> loadLosing() {
        Set<String> set = new HashSet<>();
        File f = new File(LOSING_FILE);
        if (!f.exists()) return set;
        try (BufferedReader in = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = in.readLine()) != null)
                if (line.trim().length() == 9)
                    set.add(line.trim());
        } catch (IOException e) {
            System.out.println("Could not read " + LOSING_FILE);
        }
        return set;
    }

    /** Reads an integer; returns -1 if the input isn't a valid number */
    static int readInt() throws IOException {
        String line = keyboard.readLine();
        if (line == null) System.exit(0);
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}