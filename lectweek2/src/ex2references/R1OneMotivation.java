package ex2references;


/*

   A lot of copying in programs. Assignments and method calls/returns
   all copy data!

   If much data to copy possibly a problem ... efficiency!

 */
public class R1OneMotivation {

    public static void main(String[] arg) {
        new R1OneMotivation().program();
    }

    void program() {
        int i = 5;
        int j;

        // -------- Reasonable copying ----------------------

        j = i;                  // Copy 32 bits
        int result = add(i, j); // Copy 3 * 32 bits

        // ------ Very inefficient (if copying) -------------------------

        int[] a1 = new int[1_000_000_000];   // 32 000 000 000 bits ( 32Gb)!!
        int a2[];

        a2 = a1;           // Much to copy!!
        a1 = add(a1, a2);  // Even more to copy!

        // The above is not feasible ... so Java (and many other languages)
        // uses references ... more to come ...
        // This is *one* motivation for references, there are others ...
    }

    // -------------- Methods -----------------------

    // Argument (values) copied to a and b
    int add(int a, int b) {
        return a + b;   // Return data copied
    }

    // Argument copied to a and b !!!
    int[] add(int[] a, int b[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + b[i];
        }
        return a; // Return data copied
    }

}
