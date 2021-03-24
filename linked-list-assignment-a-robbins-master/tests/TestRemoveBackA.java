public class TestRemoveBackA {
    public static void main(String[] args) {
        GenericList<Integer> ll = new GenericList<Integer>();
        int start = 0, end = 1000;

        for (int i = start; i < end; i++) {
            ll.insertBack(i);
        }

        for (int i = end-1; i > start; i--) {
            if (!ll.getBack().equals((i))) {
                StdOut.printf("getBack() returned unexpected value. Got %d, expected %d\n",
                              ll.getBack(), i);
                System.exit(1);
            }
            ll.deleteBack();
        }

        StdOut.print("Test succeeded\n");
    }
}
