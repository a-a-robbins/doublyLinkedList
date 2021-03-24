

public class TestRemoveTooFar {
    public static void main(String[] args) {

        GenericList<Integer> ll = new GenericList<Integer>();

        for(int i = 0; i < 10; i++)
        {
            ll.insertBack(i);
        }
        for(int i = 10; i >0; i--)
        {
            ll.deleteBack();
        }
            if(ll.getLen() != 0)
            {
               StdOut.println("Error: deletion did not complete");
            }
        for(int i = 0; i < 10; i++)
        {
            ll.insertBack(i);
        }
            if(ll.getLen() != 10)
            {
                StdOut.println("Error: insertion did not work");
            }
        ll.print();

    }
}
