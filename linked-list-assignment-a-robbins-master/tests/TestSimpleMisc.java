
public class TestSimpleMisc {
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

        for(int i = 0; i < ll.getLen(); i++)
        {
            if(ll.inList(i) != true)
            {
                StdOut.println("Error: inList failed");
                System.exit(1);
            }
        }
        StdOut.println("Test inList succeeded");


        for(int i = 10; i > 1; i--)
        {
            ll.deleteFront();
                if(ll.getLen() != i-1)
                {
                    StdOut.println("Error: getLen failed");
                    System.exit(1);
                }

        }
        StdOut.println("Test getLen succeeded");

    }
}
