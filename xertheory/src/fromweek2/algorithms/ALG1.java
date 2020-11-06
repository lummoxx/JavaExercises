package fromweek2.algorithms;

import static java.lang.Integer.min;
import static java.lang.System.out;

/*
    Tricky problem. Which is the min sum if going
    from top to bottom and add all number (going down,
    left or right)?

    Easier challenge: If just going down, right.

    HINT: Try functional decomposition
 */
public class ALG1 {
    public static void main(String[] args) {
        new ALG1().program();
    }

    private void program() {
        int[][] m1 = {   // NOTE: ragged matrix
                {4},
                {3, 2},
                {1, 2, 1},
                {2, 4, 1, 3}

        };

        int[][] m4 = {
                {4},
                {3, 2},
                {1, 2, 1},
                {2, 1, 2, 3}
        };
        int[][] m5 = {
                {2},
                {3, 9},
                {1, 6, 7}};

        out.println(minSum(m1) == 8);
        out.println(minSum(m4) == 8);
        out.println(minSum(m5) == 6);

        // NOTE : Can't run in seq, if matrix changed
        out.println(minSumRightOnly(m1) == 8);
        out.println(minSumRightOnly(m4) == 9);
        out.println(minSumRightOnly(m5) == 6);

    }

    // ----------- Methods -------------------

    int minSum(int[][] triangle) {
       // TODO
        return 0;
    }



    // -------------  Works only down/right. -----------------

    int minSumRightOnly(int[][] m) {
       // TODO
        return 0;
    }


}

