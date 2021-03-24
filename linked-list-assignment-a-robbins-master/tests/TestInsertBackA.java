public class TestInsertBackA {
    public static void main(String[] args) {
        GenericList<Integer> ll = new GenericList<Integer>();

        for (int i = 0; i < 1000; i++) {
            ll.insertAt(i, 999999);
            if (i != ll.getBack()) {
                StdOut.printf("Test failed, expected to get %d from the list but got %d", i,
                              ll.getBack());
                System.exit(1);
            }
        }

        StdOut.print("Test succeeded\n");
    }
}
