// comments are sprinkled below. Other thing to keep in mind for the future, you should leave in 
// the porotype comments that I inserted into the template. They provide valuable details on what 
// the function behavior is, what the meaning of each parameter is, and what the expected return 
// values are
public class GenericList<Type> {


    private class Node {
        Type val;
        Node next;
        Node prev;


        public Node(Type v) {
            val = v;
            next = null;
            prev = null;
        }
    }


    private Node head;
    private Node tail;
    private int len;


    public GenericList() {
        head = null;
        tail = null;
        len = 0;
    }


    public void print() {
        Node walker = head;

        StdOut.print("front --> ");
        print(head);
        StdOut.print("back\n");


    }


    private void print(Node n) {
        if (n == null) {
            return;
        }
        StdOut.print(n.val);
        StdOut.print(" --> ");
        print(n.next);


    }

    private void printRev() {
        Node w = tail;

        StdOut.print("back --> ");
        if (isEmpty()) {
            StdOut.println("list is empty");
            return;
        }
        else {

            while (w != null) {
                StdOut.print(w.val);
                StdOut.print(" --> ");
                w = w.prev;
            }

            StdOut.println("front");

        }
    }


    public void insertFront(Type val) {
        Node n = new Node(val);

        if (!isEmpty()) {

            n.next = head;
            n.prev = null;
            head.prev = n;
            head = n;
        }
        else {
            head = n;
            tail = head;
        }

    }


    public void insertBack(Type val) {
        Node n = new Node(val);

       if(!isEmpty()) {
            n.prev = tail;
            n.next = null;
            tail.next = n;
            tail = n;
        }
        else {
            tail =n;
            head = tail;
        }

    }


    public boolean inList(Type val) {
        Node w = head;

        while (w != null) {
            if (w.val == val) {
                return true;
            }
            else {
                w = w.next;

            }
        }
        return false;
    }


    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        else {
            // same issue as deleteBack described below
            head = head.next;
            head.prev = null;
            return true;
        }
    }


    public boolean deleteBack() {
        if (isEmpty()) {
            return false;
        }
        else {
            // this code will also potentiall crash in a few edge cases. The main one is 
            // what if you just removed the last node from the list?
            tail = tail.prev; // if so then tail will be null
            tail.next = null; // if tail is null then this line will crash
            // you also would need to reset head to null as well in the case where you 
            // just removed the last node, otherwise future insertions will also fail
            return true;
        }
    }


    public void insertAt(Type val, int position) {
       Node n = new Node(val);
       Node w = head;

       if(isEmpty()) {
           insertFront(val);
       }
       else {
           if(position < 0)
           {
               StdOut.println("no such position exists");
               return;
           }

           if(position == 0) {
               insertFront(val);
           }
           else if(position == (getLen()-1)) {
               insertBack(val);
           }
           else {

               for (int i = 0; i <= position - 1; i++) {
                   if (i == position - 1) {
                       n.prev = w.prev;
                       n.next = w.next;
                       w.next = n;
                   }
                   // you have a null pointer exception hiding on this line. This is because of
                   // how the loop iteration is set up. You make a few checks on the size of 
                   // the position argument but you don't check if position > length of the list. 
                   // if this is true then this loop will walk off the end of the list and crash.
                   // 
                   // instead you would have wanted a check to see if position > the length of the list 
                   // and if so just call the insertBack function. If not then you could use a loop like
                   //     for(i = 0; i < position; i++){ w = w.next; }
                   w = w.next;
               }
           }
       }
    }


    public boolean deleteAt(int position) {
        Node w = head;

        if(isEmpty()) {
            StdOut.println("list is empty");
            return false;
        }
        else {
            for(int i = -1; w != null && i <= position-1; i++, w = w.next)
        {
                if(i == position-1) {
                    if(w.prev == null)
                    {
                        deleteFront();
                    }
                    else if(w.next == null) {
                        deleteBack();
                    }
                    else {
                        w.prev = w.prev.prev;
                        w.next = w.next.next;
                    }
                }
            }
            return true;
        }
    }

    public Type getFront() {
        if (head == null) {
            StdOut.println("list is empty");
            return null;
        }
        else {
            return head.val;
        }
    }


    public Type getBack() {
        if (tail == null) {
            StdOut.println("list is empty");
            return null;
        }
        else {
            return tail.val;
        }
    }

    public Type getValueAt(int position) {
        Node w = head;
        int count = 0;
        
        // you are safe from a nullptr exception here because of your use 
        // of w != null, but the safer thing to do is explicitly check if 
        // position > length of the list and return appropriatly right away
        while (w != null) {
            if (count == position) {
                return w.val;
            }
            count++;
            w = w.next;
        }

        return null;
    }



    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }


    public int getLen() {
        // this method would not require any traversals. Instead you could keep a counter 
        // which is incrimented and decrimented every time a node is added or removed. Then 
        // in this method just return the value of that counter 
        Node w = head;
        len = 0;

        while(w != null) {
            len++;
            w = w.next;
        }
        return len;
    }

    public static void main(String[] args)
    {
        GenericList<Integer> ll = new GenericList<Integer>();


        StdOut.println("Accepting input");
        while (!StdIn.isEmpty())
        {
            String cmd = StdIn.readString();
            StdOut.println("Running command: " + cmd);
            if (cmd.equals("front")) {
                if (!ll.isEmpty()) {
                    int data = ll.getFront();
                    StdOut.printf("front: %d\n", data);
                }
                else {
                    StdOut.println("Warning: list is empty");
                }
            }
            else if (cmd.equals("back")) {
                if (!ll.isEmpty()) {
                    int data = ll.getBack();
                    StdOut.printf("back: %d\n", data);
                }
                else {
                    StdOut.println("Warning: list is empty");
                }
            }
            else if (cmd.equals("at")) {
                if (!ll.isEmpty()) {
                    int pos = StdIn.readInt();
                    Integer data = ll.getValueAt(pos);
                    if (data == null) {
                        StdOut.println("warning: couldn't get position " + pos);
                    }
                    else {
                        StdOut.printf("list[%d]: %d\n", pos, data);
                    }

                }
                else {
                    StdOut.println("Warning: list is empty");
                }
            }
            else if (cmd.equals("ifront")) {
                int val = StdIn.readInt();
                ll.insertFront(val);
                StdOut.printf("inserted %d\n", val);
            }
            else if (cmd.equals("iback")) {
                int val = StdIn.readInt();
                ll.insertBack(val);
                StdOut.printf("inserted %d\n", val);
            }
            else if (cmd.equals("iat")) {
                int val = StdIn.readInt();
                int pos = StdIn.readInt();
                ll.insertAt(val, pos);
                StdOut.printf("inserted %d at position %d\n", val, pos);
            }
            else if (cmd.equals("rfront")) {
                if (!ll.isEmpty()) {
                    if (!ll.deleteFront()) {
                        StdOut.println(
                                "error: deleteFront reported failure when it should have succeeded");
                    }
                }
                else {
                    StdOut.println("warning: list appears to be empty");
                }
            }
            else if (cmd.equals("rback")) {
                if (!ll.isEmpty()) {
                    if (!ll.deleteBack()) {
                        StdOut.println(
                                "error: deleteBack reported failure when it should have succeeded");
                    }
                }
                else {
                    StdOut.println("warning: list appears to be empty");
                }
            }
            else if (cmd.equals("rat")) {
                if (!ll.isEmpty()) {
                    int pos = StdIn.readInt();
                    boolean success = ll.deleteAt(pos);
                    if (!success) {
                        if (pos < ll.getLen()) {
                            StdOut.println(
                                    "error: deleteAt reported failure when it should have succeeded");
                        }
                    }
                }
                else {
                    StdOut.println("warning: list appears to be empty");
                }
            }
            else if (cmd.equals("print")) {
                ll.print();

            }
            else if (cmd.equals("printr")) {
                ll.printRev();

            }
            else if (cmd.equals("contains")) {
                int val = StdIn.readInt();
                if (ll.inList(val)) {
                    StdOut.printf("Found %d\n", val);
                }
                else {
                    StdOut.printf("Did not find %d\n", val);
                }
            }
            else if (cmd.equals("size")) {
                StdOut.printf("List length: %d\n", ll.getLen());

            }
            else if (cmd.equals("empty")) {
                if (ll.isEmpty()) {
                    StdOut.println("list is empty");
                }
                else {
                    StdOut.println("list is not empty");
                }
            }
            else if (cmd.equals("quit")) {
                break;
            }
            else {
                StdOut.println("Unknown cmd: " + cmd);
            }
        }


    }


}
