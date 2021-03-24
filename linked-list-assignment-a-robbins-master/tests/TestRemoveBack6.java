public class TestRemoveBack6 {
    public static void main(String[] args) {
        GenericList<Integer> ll = new GenericList<Integer>();
        int start = 0, end = 1000;

        for (int i = start; i < end; i++) {
            ll.insertBack(i);
        }

        for (int i = start; i < end - 1; i++) {
            ll.deleteBack();
            if (!ll.getFront().equals(start)) {
                StdOut.printf("the front node should not change due to a remove back");
                System.exit(1);
            }
        }
        StdOut.print("Test succeeded\n");
    }
}
