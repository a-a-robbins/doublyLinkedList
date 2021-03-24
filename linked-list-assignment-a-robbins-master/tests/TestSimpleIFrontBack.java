
public class TestSimpleIFrontBack
{
    public static void main(String[] args)
    {
        GenericList<Integer> ll = new GenericList<Integer>();


        for(int i = 0; i < 5; i++)
        {
            ll.insertFront(i);

        }
            if(ll.getLen() != 5)
            {
                StdOut.println("Error: insertFront failed");
                System.exit(1);

            }
        for(int i = 5; i < 10; i++)
        {
            ll.insertBack(i);
        }
            if(ll.getLen() != 10) {
                StdOut.println("Error: insertBack failed");
                System.exit(1);

            }

        ll.print();
        StdOut.println("Test succeeded");



    }
}
