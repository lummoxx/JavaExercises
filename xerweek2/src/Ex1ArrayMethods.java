import java.util.Arrays;
import java.util.Random;

import static java.lang.StrictMath.round;
import static java.lang.System.*;

/*
 *  Methods with array params and/or return value. Implement methods.
 *
 *  See:
 *  ex2references
 *  ex3methods
 *  ex4algorithms
 *  - in particular A1BasicAlgs
 * -  and Fisher-Yates
 */
public class Ex1ArrayMethods {

    public static void main(String[] args) {
        new Ex1ArrayMethods().program();
    }

    final static Random rand = new Random();

    void program() {
        // test();
        int[] arr = { 1, 2, 2, 5, 3, 2, 4, 2, 7 }; // Hard coded test data
        int[] arr2 = new int[0];
        int[] arr3 = new int[0];
        // Uncomment one at a time and implement

        // Count occurrences of some element in arr
        out.println(count(arr, 2) == 4);      // There are four 2's
        out.println(count(arr, 7) == 1);


        // Generate array with 100 elements with 25% distribution of -1's and 1's
        // (remaining will be 0)
        arr2 = generateDistribution(100, 0.25, 0.25);
        out.println(count(arr2, 1) == 25);
        out.println(count(arr2, -1) == 25);
        out.println(count(arr2, 0) == 50);

        // Generate array with 14 elements with 40% 1's and 30% -1's
        arr3 = generateDistribution(14, 0.4, 0.3);
        out.println(count(arr3, 1) == 6);
        out.println(count(arr3, -1) == 4);


        for (int j = 0; j < 10; j++) {
            // Random reordering of arr, have to check by inspecting output
            shuffle(arr);
            out.println(Arrays.toString(arr));  // Does it look random?
        }
    }

    // ---- Write methods below this ------------
    int count(int[] arr, int num) {
        int occurences = 0;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] == num) {
                occurences++;
            }
        }
        return occurences;
    }

    // (-1,1)
    int[] generateDistribution(int elements, double percentPos, double percentNeg) {
        int[] arr = new int[elements];
        double numPos = percentPos * elements;
        double numNeg = percentNeg * elements;
        int ettor = (int) Math.round(numPos);
        int minusettor = (int) Math.round(numNeg);

        for (int i = 0; i < ettor; i++) {
            arr[i] = 1;
        }
        for (int i = ettor; i < (ettor + minusettor); i++) {
            arr[i] = -1;
        }
        return arr;
    }

    int[] shuffle(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
/*
 * See Ex2ArrayMethod. Implement methods. In general program should just print
 * "true". The only exception is the shuffle method. Method uses Random, so hard
 * to test. Print out for shuffle should look something like:
 *
 * [0, 0, 1, 0, -1, -1, 1, 0, 1, 1, 1, 1, -1, -1] (randomly ordered elements)
 * [-1, 1, 1, 0, 0, 1, -1, 1, 1, 0, 1, -1, 0, -1] [-1, 1, 1, 0, 1, 0, -1, 0, 1,
 * 1, -1, 1, 0, -1] [-1, -1, 0, 0, -1, -1, 1, 1, 0, 1, 1, 1, 1, 0] [0, 0, 1, -1,
 * -1, 0, -1, -1, 1, 1, 1, 1, 1, 0] [1, -1, 0, 0, 1, -1, 1, 1, 0, 1, -1, 0, 1,
 * -1] [1, 1, 1, -1, 0, 1, 0, 0, 1, -1, -1, 0, 1, -1] [-1, 1, 1, 0, -1, 0, -1,
 * 1, 1, 1, 0, 1, 0, -1] [1, 1, -1, -1, -1, 1, 0, 1, -1, 0, 1, 0, 0, 1] [0, 1,
 * 0, 1, 0, 0, 1, 1, -1, -1, 1, 1, -1, -1] ...
 *
 * See code for comments.
 * 
 * 
 * [0, 1, 0, 1, 1, 1, 1, -1, -1, -1, 0, -1, 1, 0] [0, 1, 1, 1, 1, 0, 0, -1, 1,
 * 1, -1, 0, -1, -1] [1, 1, 0, -1, 1, -1, -1, 1, 1, 0, -1, 0, 1, 0] [1, 0, -1,
 * 1, -1, 0, 0, 1, -1, -1, 1, 0, 1, 1] [1, -1, -1, 0, -1, 1, 0, 1, 0, -1, 1, 0,
 * 1, 1] [0, 1, -1, 0, 1, -1, 0, 0, -1, 1, 1, -1, 1, 1] [1, -1, 0, 1, 1, 1, -1,
 * 1, 1, -1, 0, 0, 0, -1] [-1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 1, 1, 0] [-1,
 * -1, 1, 1, 1, 1, 0, 1, -1, 0, 0, 0, 1, -1] [-1, 1, 0, 1, -1, 1, 0, 1, 1, 0, 1,
 * -1, -1, 0]
 * 
 * Process finished with exit code 0
 * 
 * 
 * 
 */