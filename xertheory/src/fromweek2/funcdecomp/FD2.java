package fromweek2.funcdecomp;

import java.util.Arrays;

import static java.lang.System.out;

/*
     Exercising functional decomposition

     Find all elements common to all rows in matrix
 */
public class FD2 {

    public static void main(String[] args) {
        new FD2().program();
    }

    void program() {
        int[][] m1 = {
                {7, 1, 3, 6},
                {6, 2, 7, 1},
                {8, 9, 1, 3,},
                {5, 6, 9, 1},
        };
        int[][] m2 = {
                {7, 1, 3, 9},
                {6, 9, 7, 1},
                {7, 9, 1, 3,},
                {5, 7, 9, 1},
        };

        // There is one element common to all rows in m1
        out.println(Arrays.toString(getCommonRowElements(m1)).equals("[1]"));
        // There is three element common to all rows in m2
        out.println(Arrays.toString(getCommonRowElements(m2)).equals("[7, 1, 9]"));
    }

    // Get all elements present on all rows
    int[] getCommonRowElements(int[][] matrix) {
        // TODO
        return null;

    }


}
