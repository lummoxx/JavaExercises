import static java.lang.System.*;

import java.util.Scanner;

/*
 *  Program to calculate easter Sunday for some year (1900-2099)
 *  https://en.wikipedia.org/wiki/Computus (we use a variation of
 *  Gauss algorithm, scroll down article, don't need to understand in detail)
 *
 *  To check your result: http://www.wheniseastersunday.com/
 *
 *  See:
 *  - ex2ifwhile
 */
public class Ex2EasterSunday {

    public static void main(String[] args) {
        new Ex2EasterSunday().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {

        int a, b, c, d, e, s, t; // Avoid variables on same line (but acceptable here)
        int date;
        int year;
        int month = 0;

        // ---- Input --------------
        out.print("Input a year (1900-2099) > ");
        year = sc.nextInt();

        // ----- Process -----------
        a = year % 19; // Don't need to understand, Gauss did understand
        b = year % 4;
        c = year % 7;
        s = 19 * a + 24;
        d = s % 30;
        t = 2 * b + 4 * c + 6 * d + 5;
        e = t % 7;
        date = 22 + d + e;

        if (date < 32) {
            if (date == 26) {
                date = 19;
                month = 4;
            } else if ((date == 25) & (a == 16) & (d == 28)) {
                date = 18;
                month = 4;
            } else {
                month = 3;
            }
        } else {
            date = (d + e - 9);
            month = 4;
        }

        /*

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
        */

        // --------- Output -----------
        out.println("Easter Sunday for  " + year + " is : " + date + "/" + month);

    }
}
