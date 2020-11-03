import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * The Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * This is exercising smallest step programming (no methods needed)
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 */
public class Ex8RPS {

    public static void main(String[] args) {
        new Ex8RPS().program();
    }


    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds
        int rmin = 1;
        int rmax = 3;

        // All code here ... (no method calls)
        // BRB, 10 min******************

        out.println("Welcome to Rock, Paper and Scissors");
        //Rock (1) <-- Paper (2) <-- Scissors (3)
        result = 0;
        while (round < maxRounds) {   // Game loop
            out.println("Select 1, 2 or 3 (for R, P or S) >");
            int choice = sc.nextInt();
            int comp = rand.nextInt((rmax - rmin) + 1) + rmin;
            switch (choice) {
                case 1:
                    if (comp == 2) {
                        result -= 1;
                        out.println("Computer won");
                    } else if (comp == 3) {
                        result += 1;
                        out.println("You won");
                    } else out.println("A draw");
                    break;
                case 2:
                    if (comp == 3) {
                        result -= 1;
                        out.println("Computer won");
                    } else if (comp == 1) {
                        result += 1;
                        out.println("You won");
                    } else out.println("A draw");
                    break;
                case 3:
                    if (comp == 1) {
                        result -= 1;
                        out.println("Computer won");
                    } else if (comp == 2) {
                        result += 1;
                        out.println("You won");
                    } else out.println("A draw");
                    break;
            }
            out.println("Result: " + result);

            round++;
        }

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}

/*
8.  See Ex8RPS. Implement a program for the game Rock, Paper and Scissor.
    NOTE: The main task here is to use smallest step programming.
    You don't need any methods for this, put all code in program().

    The game should run as (just 5 rounds):

    Welcome to Rock, Paper and Scissors
    Select 1, 2 or 3 (for R, P or S) > 1
    Computer choose: 2
    You won
    Result 1                                (use an int for over all result, +1 for human, total = 1)

    Select 1, 2 or 3 (for R, P or S) > 2
    Computer choose: 2
    A draw
    Result 1

    Select 1, 2 or 3 (for R, P or S) > 3
    Computer choose: 1
    You won
    Result 2                                (result, +1 for human, total = 2)

    Select 1, 2 or 3 (for R, P or S) > 1
    Computer choose: 1
    A draw
    Result 2

    Select 1, 2 or 3 (for R, P or S) > 2
    Computer choose: 1
    Computer won
    Result 1                        (total = 1 -> i.e. total positive -> human won)

    Game over!
    Human won.

*/
