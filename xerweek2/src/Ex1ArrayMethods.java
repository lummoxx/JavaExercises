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
        int[] arr = {1, 2, 2, 5, 3, 2, 4, 2, 7};  // Hard coded test data

        // Uncomment one at a time and implement

        // Count occurrences of some element in arr
        out.println(count(arr, 2) == 4);      // There are four 2's
        out.println(count(arr, 7) == 1);

        // Generate array with 100 elements with 25% distribution of -1's and 1's (remaining will be 0)
        int[] arr2;
        arr2 = generateDistribution(100, 0.25, 0.25);
        out.println(count(arr2, 1) == 25);
        out.println(count(arr2, -1) == 25);
        out.println(count(arr2, 0) == 50);

        // Generate array with 14 elements with 40% 1's and 30% -1's
        int[] arr3;
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
