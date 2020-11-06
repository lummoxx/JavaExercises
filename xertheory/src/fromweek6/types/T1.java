package fromweek6.types;

import static java.lang.System.out;


/*
         What compiles (and not), any runtime errors?
         If ok what will be printed? Try to predict then uncomment.
 */
public class T1 {

    public static void main(String[] args) {
        new T1().program();
    }

    void program() {
        /*
        //a
        A a = new B();
        a.doA();

        //b
        IA a1 = new X();
        a1.doA();

        //c
        C c = new B();
        c.doC();

        //d
        B b1 = new C();
        b1.doX();

        //e
        IX x = new C();
        X x1 = (X) x;
        x1.doA();

        //f
        */
        IX x2 = new C();
        B b2 = (B) x2;
    }

    public interface IA {
        void doA();
    }


    public interface IX {
        void doX();
    }


    public abstract class A implements IA {

        public void doA() {
            out.println("A.doA()");
        }

        public abstract void doC();
    }


    public class B extends A {

        public void doC() {
            out.println("B.doC()");
        }
    }


    public class C extends B implements IX {

        public void doA() {
            out.println("C.doA()");
        }

        public void doX() {
            out.println("C.doX()");
        }

        public void doC() {
            out.println("C.doC()");
        }
    }

    public class X implements IX {

        public void doX() {
            out.println("X.doX()");
        }

        public void doA() {
            out.println("X.doA()");
        }
    }


}
