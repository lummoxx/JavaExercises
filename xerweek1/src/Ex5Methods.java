import static java.lang.System.out;

/*
 *  Implement methods to make program produce correct output (normally print true)
 *
 * See:
 * - ex4methods
 */
public class Ex5Methods {

    public static void main(String[] args) {
        new Ex5Methods().program();
    }

    void program() {
        // All, except last,  should print true

        // Uncomment one at the time
        out.println(sumTo(5) == 15);     // 1 + 2 + ... + 5 = 15
        out.println(sumTo(23) == 276);
        out.println(factorial(3) == 6);    // 3 * 2 * 1 = 6
        out.println(factorial(5) == 120);
        out.println(digitSum(1111) == 4);   // 1 + 1 + 1 + 1 = 4
        out.println(digitSum(12345) == 15);
        String winner = "Olle";
        winnerMsg(winner);
        // A special case, should print: "Winner is Olle" (or whatever name)
        //winnerMsg(winner);
    }

    int sumTo(int cap) {
        int sum = 0;
        for (int i = 1; i <= cap; i++) {
            sum += i;
        }
        return sum;
    }

    int factorial(int cap) {
        if (cap > 0) {
            int sum = 1;
            for (int i = 1; i < cap; i++)
            {
                sum = sum * (i + 1);
            }
            return sum;
        } else return 0;

    }
        
    int digitSum(int num) {
        int n, sum = 0;
        while (num > 0){
            n = num % 10;
            sum += n;
            num = num/10;
        }
        return sum;
    }    

    void winnerMsg(String winner) {
    out.println("Winner is " + winner);
    }
   /*
   5.  See Ex5Methods. Implement the methods (uncomment on row at the time). Program run should
    run like:

    true       (NOTE: this is the normal output when testing)
    true
    true
    true
    true
    true
    true
    Winner is Olle         (this is an exception to the normal output)
   */

}
