package test;

import persons.*;

public class TestPersonDBStub {

    public static void main (String[] args) {
        System.out.println("Testing class PersonDBStub... ");
        try {
            TestPersonDB.test(new PersonDBStub());
        } catch (Throwable e) {
            System.out.println("\nTests failed: " + e);
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("OK");
    }

}


