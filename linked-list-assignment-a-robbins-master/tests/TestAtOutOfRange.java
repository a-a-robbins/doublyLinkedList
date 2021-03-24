
public class TestAtOutOfRange {
    public static void main(String[] args) {

        GenericList<Integer> ll = new GenericList<Integer>();

        for(int i = 0; i < 10; i++)
        {
            ll.insertBack(i);
        }

        int data = ll.getValueAt(0);
        ll.insertAt(11, -1);
            if(ll.getValueAt(0) != data)
            {
                StdOut.println("Error: insertion did not catch out of range");
            }
        StdOut.println("Test succeeded");
    }
}
