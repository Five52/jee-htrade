package test;

import trades.*;

public class TestOwnershipDBStub {

    public static void main (String[] args) {
        System.out.println("Testing class OwnershipDBStub... ");
        try {
            TestOwnershipDB.test(new OwnershipDBStub());
        } catch (Throwable e) {
            System.out.println("\nTests failed: " + e);
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("OK");
    }

}


