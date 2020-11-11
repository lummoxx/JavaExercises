package ex3supersub;

/*
        Super/sub for class types (reference types/variables)
 */
public class SS3Class {

    public static void main(String[] arg) {
        new SS3Class().program();
    }

    void program() {

        // Expression compiles. Is it possible to replace any side with a Dog type?
        Player p = new Player();  // Value in p is reference to Player

        // Replace player type value with dog type value (right side).
        //p = new Dog();           // No, compile error

        // Replace player type variable with dog type variable (left side).
        //Dog d = new Player();     // No, compile error

        // Try to cast Dog value to Player value
        //p = (Player) new Dog();  // No, compile error


        /*
            THE SUPER/SUB RELATION FOR CLASS TYPES
            ---------------------------------
            Can't replace anything on any side, can't cast.
            Summary: There is no super sub relation for class types
            (neither variables nor values)

        */
        /*
            VARIABLE TYPE DEFINES OPERATIONS
            --------------------
            Allowing super/sub between class types would lead to
            illegal operations
         */
        //Player p = new Cat();   // If allowed ... (it's not)
        p.age++;                  // Cat objects has no age, illegal!

    }

    // -------------- Types ------------------------
    // Java uses nominal typing i.e. only type name counts for types
    // to be the same (prevent accidental type equivalence)
    class Player {
        String name;
        int age;
    }

    class Dog {
        String name;   // Same content as Player but not same type
        int age;
    }

    class Cat {
        String name;
        boolean isChampion;
    }



}
