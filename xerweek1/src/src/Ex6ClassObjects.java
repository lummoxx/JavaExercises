import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using class objects to represent heroes
 *  https://en.wikipedia.org/wiki/Gladiators_(1992_UK_TV_series)
 *
 * See:
 * - ex5classes
 */
public class Ex6ClassObjects {

    public static void main(String[] args) {
        new Ex6ClassObjects().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        Hero hero1 = new Hero();
        out.print ("What's the name of the hero 1? ");
        hero1.name = sc.nextLine();
        out.print ("How strong is " + hero1.name + "? ");
        hero1.strength = sc.nextInt();
        sc.nextLine();

        Hero hero2 = new Hero();
        out.print ("What's the name of the hero 2? ");
        hero2.name = sc.nextLine();
        out.print ("How strong is " + hero2.name + "? ");
        hero2.strength = sc.nextInt();

        if (hero1.strength > hero2.strength) {
            out.print (hero1.name + " is stronger");
        } else if (hero2.strength > hero1.strength) {
            out.print (hero2.name + " is stronger");
        } else out.print ("They are equally strong");

    }

    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}

/*
 See Ex6ClassObjects. Use the class Hero to create 2 heroes (hero objects) to be used like:

    What's the name of the hero 1? > Hercules      (input data)
    How strong is Hercules > 34
    What's the name of the hero 2? > Atlas
    How strong is Atlas > 45
    Atlas is stronger

    If they are equally strong the program prints: They are equally strong

    NOTE: When reading a number the scanner will leave the last char (the enter char, '\n') because
    it can not be part of any number. To get rid of the enter char use an extra sc.readLine().
    Else strange behaviour for program (seems like it skips an input).

 */