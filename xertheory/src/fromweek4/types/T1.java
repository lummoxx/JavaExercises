package fromweek4.types;


/*
         Which rows compile and which doesn't? Why?
         Try to predict then uncomment.
 */
public class T1 {

    public static void main(String[] args) {
        new T1().program();
    }

    void program() {
        /*
        A a = new A();
        B b = new B();
        IX ix  = new IX();
        IY iy = null;

        a = b;
        b = (A) a;

        ix = iy;
        iy = ix;

        ix = a;
        a = (A) ix;
        ix = b;
        iy = b;

        ix = (IX) iy;   // More to come ...
        */
    }


    interface IX {
    }

    interface IY {
    }

    class A implements IX {
    }

    class B implements IY {
    }
}
