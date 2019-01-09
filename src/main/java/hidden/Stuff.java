package hidden;

import reflect.RunMe;

//@RunMe
public class Stuff {
//    @RunMe
    private int count = 99;
    public static void staticMethod() {
        System.out.println("in the staticMethod...");
    }

    public String getAString() {
        return "Hello";
    }

    public void doSomeAction(int x) {
        System.out.println("Wham!!! This is an action, x is " + x);
    }

    @RunMe
    private void doAnotherAction() {
        System.out.println("This is another action");
    }

    @RunMe
    public void doMoreStuff() {
        System.out.println("In the doMoreStuff method; count value is " + count);
    }
}

