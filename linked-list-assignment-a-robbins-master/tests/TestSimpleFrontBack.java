
public class TestSimpleFrontBack {
    public static void main(String[] args) {

        GenericList<Integer> ll = new GenericList<Integer>();

        for(int i = 0; i < 10; i++)
        {
            ll.insertBack(i);
        }
            if(ll.getLen() != 10) {
                StdOut.println("Error: insertion failed");
                System.exit(1);
            }
        ll.print();

        StdOut.println("Front = " + ll.getFront());
        StdOut.println("Back = " + ll.getBack());


        StdOut.println("Test succeeded");

    }
}
