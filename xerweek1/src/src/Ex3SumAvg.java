import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - ex2ifwhile
 * - IW5LoopAndAHalf in particular.
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
            // Write your code here
            out.println("Please input a number greater than 0:");
            double inputNum = sc.nextDouble();
            double summed = 0;
            double count = 0;

            while (inputNum > 0) {
                count++;
                summed += inputNum;

                inputNum = sc.nextDouble();
            }
            double average = summed / count;

            // -- Input (and bookkeeping)

            // -- Process---

            // -- Output ----
            out.println("Sum = " + summed);
            out.println("Average = " + average);
        }
    }
