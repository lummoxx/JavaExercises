import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        Player current;
        Player winner = null;
        char[] board = createBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        if (rand.nextBoolean()) {
            current = p1;
        } else {
            current = p2;
        }

        while (winner == null){
            int selected = getPlayerSelection(current);
            while (board[selected] == p1.mark || board[selected] == p2.mark ) {
                out.println("Position is occupied, try again.");
                selected = getPlayerSelection(current);
            }
            board[selected] = current.mark;
            if (isWon(board)) {
                winner = current;
            }else if (isDraw(board)) {
                winner.name = "draw";
            }else if (current == p1) {
                current = p2;
            } else {
                current = p1;
            }
            plotBoard(board);

        }
        out.println("Game over!");
        plotBoard(board);

        if (winner.name == "draw") {
            out.println("Draw");

        } else {
            out.println("Winner is " + current.name);
        }
    }


    // ---------- Methods  ----------------

    char[] createBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
        return board;
    }

    boolean isOccupied(char[] board, int place) {
        if (board[place] == 'O' || board[place] == 'X') {
            return true;
        } else {
            return false;
        }
    }

    //checks if anyone has three in a row
    boolean isWon(char[] board) {
        //diagonally
        if ((isOccupied(board, 2)) && ((board[2] == board[4]) && (board[2] == board[6]))) {
            return true;
        }
        if ((isOccupied(board, 0)) && ((board[0] == board[4]) && (board[2] == board[8]))) {
            return true;
        }

        //horizontally
        for (int i = 0; i < 9; i++) {
            if ((isOccupied(board, i)) && (i + 1) % 3 == 0) {
                if (board[i] == board[i - 1] && board[i] == board[i - 2]) {
                    return true;
                }
            }
        }

        //vertically
        for (int i = 0; i<4; i++) {
            if ((isOccupied(board, i)) && ( (board[i] == board[i + 3]) && (board[i] == board[i + 6]))) {
                return true;
            }
        }
        return false;
    }
    //checks if the game is done but no one won
    boolean isDraw(char[] board) {
        for (int i = 0; i < 9; i++){
            if (!isOccupied(board, i)) {
                return false;
            }
        }
        if (!isWon(board))
        {
            return true;
        }
        return false;
    }


    // TODO More methods

    // --------- IO methods ------------------------
    int getPlayerSelection(Player player) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (0-8) > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark; // - X O

        Player(String name, char mark) { 
            this.name = name;
            this.mark = mark;
        }
    }

    /*
  
     */

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);

        // "Hard coded" test boards
        char[] fullBoard = {'X', 'X', 'X', '0', 'O', 'X', 'O', '0', 'O'};
        char[] nonFullBoard = {'-', 'X', 'X', '-', 'O', '-', 'O', '-', 'O'};
        char[] fullColumn = {'-', 'X', '0', '-', 'X', '-', 'O', 'X', 'O'};
        char[] fullRow = {'X', 'X', 'X', '-', 'O', '-', 'O', '-', 'O'};
        char[] winner = {'X', '0', '-', '-', 'X', '0', 'O', '-', 'X'};


        exit(0);
    }
}

/*
9. See Ex9TicTacToe. Implement the Tic Tac Toe game.
   Here you should use functional decomposition and testing.

   If new to programming: Make a plan and discuss with assistant before staring to implement!

   Program should run like:

   Welcome to Tic Tac Toe, board is ...
   - - -             (<-- empty board)
   - - -
   - - -
   Player is olle(X)
   Select position to put mark (0-8) > 0
   X - -
   - - -
   - - -
   Player is fia(O)
   Select position to put mark (0-8) > 1
   X O -
   - - -
   - - -
   Player is olle(X)
   Select position to put mark (0-8) > 2
   X O X
   - - -
   - - -
   Player is fia(O)
   Select position to put mark (0-8) > 3
   X O X
   O - -
   - - -
   Player is olle(X)
   Select position to put mark (0-8) > 4
   X O X
   O X -
   - - -
   Player is fia(O)
   Select position to put mark (0-8) > 5
   X O X
   O X O
   - - -
   Player is olle(X)
   Select position to put mark (0-8) > 6
   Game over!
   X O X
   O X O
   O X 0
   Winner is olle


*/