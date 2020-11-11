import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ex3arraysfor
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int[] arr = {0, 0, 0, 0, 0};  // or new int[5]

        out.print("Input 5 integers (space between, then enter) > ");

        // Write your code here
        out.print("Input 5 integers (space between, then enter) > ");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        out.print("Input a value to find > ");
        int search = sc.nextInt();
        boolean found = false;
        int foundindex = 0;

        for (int i = 0; i < 5; i++) {
            if (arr[i] == search) {
                found = true;
                foundindex = i;
            }
        }

        if (found == true) {
            out.print("Value " + search + "is at index " + foundindex);
        } else {
            out.print("Value not found");
        }


        /*
        Input 5 integers (space between, then enter) > 4 2 6 1 9
        Array is [4, 2, 6, 1, 9]
        Input a value to find > 1
        Value 1 is at index 3         (if not found prints: Value not found)

        */


    }
}
