package src;

import static java.util.Arrays.copyOfRange;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 *  See:
 *  ex2references
 *  ex5matrix
 */
public class Ex2MatrixMethods {

    public static void main(String[] args) {
        new Ex2MatrixMethods().program();
    }

    void program() {

        int[][] m = { // Hard coded test data
                { -1, 0, -5, 3 }, // twodimensional array, array of 4 elements, each elements
                { 6, 7, -2, 0 }, { 9, -2, -6, 8 }, { 0, 0, 5, -6 } };
                



        // Uncomment one at a time and implement

        // Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]")); //
        // Possibly other ordering!

        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        int[][] marked = markNegatives(new int[][] { { 1, -2, 3, }, { -4, 5, -6, }, { 7, -8, 9, }, });

        /*
         * marked should be { {0, 1, 0}, {1, 0, 1}, {0, 1, 0} }
         */

        out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr2 = { 1, 2 , 3 , 4 , 5 , 6 , 7 , 8 };

        // Create matrix from array
        int[][] matrix = toMatrix(arr);
        int[][] matrix2 = toMatrix(arr2);
        
        //test(matrix2);
        /*
         * matrix should be { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }
         */
        //plot(matrix); 
        //plot(matrix2);  1(3) 2(5), 3(3), 4(5), 5(8), 6(5), 7(3), 8(5), 9(3)
        out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]")); // 0,0  0,1  0,2     
        out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]")); // 1,0  1,1  1,2       
        out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]")); // 2,0  2,1  2,2       
        
        // 0 = första elem i denna array  2 = cap för denna array de kommer att ha 3 grannar
        // samma elem i mitten-array kommer ha 5 grannar 
        
        // 8 och 2 är sista och första arrayens mitten delar, de kommer att ha 5 grannar
        // alla andra kommer ha 8 grannar ( 5 i det här fallet )
        // samma elem i slutarray kommer ha 3 grannar
        // Sum of all directly surrounding elements to some element in matrix           
        // (not counting the element itself)
       

        // matrix[i][i-1]
           // NOTE: Should be possible to expand method to include more distant neighbours
      
        
        /*
         * out.println(sumNeighbours(matrix, 0, 0) == 11);
         * out.println(sumNeighbours(matrix, 1, 1) == 40);
         * out.println(sumNeighbours(matrix, 1, 0) == 23);
         * 
         */
    }

    // -------- Write methods below this -----------------------

    boolean isValidLocation(int size, int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }

    int[] getNegatives(int[][] m) {
        int[] neg = new int[m.length * m[0].length]; // [];
        int neglength = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < ((m[0].length)); j++) {
                if (m[i][j] < 0) {
                    neg[neglength] = m[i][j];
                    neglength++;
                }
            }
        }
        int[] neg2 = new int[neglength];
        for (int i = 0; i < neglength; i++) {
            neg2[i] = neg[i];
        }
        return neg2;
    }

    int[][] markNegatives(int[][] m) {
        int[][] marked = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > 0) {
                    marked[i][j] = 0;                    
                } else {
                    marked[i][j] = 1;
                }
            }
        }
        return marked;
    }
    int[][] toMatrix(int [] arr) {
        int cap = arr.length;
        int gcd = 0;
        for (int i = 1; i < cap; i++) {
            if (cap % i == 0) {
                gcd = i;
            }
        }

        int[][] matrix = new int [gcd][cap/gcd];
        // int[] arr = new int[elements];

        for (int j = 0; j < gcd; j++) {   
            matrix[j] = copyOfRange(arr, (j*(cap/gcd)), (j*(cap/gcd)) + (cap/gcd));  // [0] = 0->2 [1] = 3->5 [2] = 6->8
        }
        return matrix;
    } 
    void plot(int[][] matrix) { 
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row])); 
        }
    }

    int sumNeighbours(int[][] matrix, int r, int c) {
        int sum = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (r > 0) {
            sum += matrix[r-1][c];
        }
        if (c > 0) {
            sum += matrix[r][c-1];
            sum += matrix[r-1][c-1];
        }
        if (r < rows) {
            sum += matrix[r+1][c];
        }
        //if (c < columns) {
        //    sum += matrix[r+1][c];
        //}
            return sum;
        
     }
        /*
[1, 2, 3]")); // 0,0  0,1  0,2     
[4, 5, 6]")); // 1,0  1,1  1,2       
[7, 8, 9]")); // 2,0  2,1  2,2 

        if matrix [0][0] = matrix [r] [c];
        matrix[r-1][c]
        matrix[r+1][c]
        matrix[r-1][c-1]
        matrix[r-1][c+2]
        
        
        //[3, 5 , 5, 3]  arr1  (i + 1) + (i) + (i - 1)    matrix[0][1] + matrix[1][1]
        //[5, 8 , 8, 5]  arr2   samma index som i i arr2 (i2) i2 +1 och i2-1
        //[5, 8 , 8, 5]  arr3  
        //[3, 5 , 5, 3]  if( i+1 <= gcd) matrix [i][j] for i<length sum i + 1
        
        
        
        */
   


    void test(int[][] matrix) {
        out.println("utanför: " + matrix.length);
        
        out.println("inuti: " + matrix[0].length);
        //out.println(Arrays.toString(getNegatives(m)));
        exit(0);
    }

    private void exit(int i) {
    }
}

/*



* out.println(sumNeighbours(matrix, 0, 0) == 11);
* out.println(sumNeighbours(matrix, 1, 1) == 40);
* out.println(sumNeighbours(matrix, 1, 0) == 23);




 * 2. See Ex2MatrixMethods. Implement methods so that program prints true for
 * everything. Use functional decomposition if things getting too complex.
 * 
 * [[I@7cc355be, [I@6e8cf4c6, [I@12edcd21, [I@34c45dca]
 * 
 * 
 * 
 * // Use if you like (during development)

 */