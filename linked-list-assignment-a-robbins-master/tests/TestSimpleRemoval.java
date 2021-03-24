
public class TestSimpleRemoval {
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

         int data = ll.getFront();

         ll.deleteFront();
            if(ll.getFront() == data)
            {
              StdOut.println("Error: delete front failed");
              System.exit(1);
            }

         ll.print();

         data = ll.getBack();

         ll.deleteBack();
            if(ll.getBack() == data)
            {
                StdOut.println("Error: delete back failed");
                System.exit(1);
            }

         ll.print();

         StdOut.println("Test succeeded");

    }
}
