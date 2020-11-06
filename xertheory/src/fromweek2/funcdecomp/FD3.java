package fromweek2.funcdecomp;

import static java.lang.System.out;

/*
     Exercising functional decomposition

     Checking unique rows in matrix
 */
public class FD3 {

    public static void main(String[] args) {
        new FD3().program();
    }


    void program() {
        // NOTE: Only positive elements
        // Order of elements in row matters
        int[][] m1 = {
                {7, 1, 3, 6},
                {6, 2, 7, 1},
                {8, 9, 1, 3,},
                {5, 6, 9, 1},
        };
        int[][] m2 = {
                {7, 1, 3, 9},
                {6, 9, 7, 1},
                {7, 1, 3, 9,},  // Duplicate
                {7, 1, 3, 9},   // Duplicate
        };

        // There are four unique rows in m1 (no duplicates)
        out.println(uniqueRows(m1) == 4);
        // There are 2 unique rows in m2 (three duplicates)
        out.println(uniqueRows(m2) == 2);
    }

    int uniqueRows(int[][] m) {
        // TODO
        return 0;

    }

}
