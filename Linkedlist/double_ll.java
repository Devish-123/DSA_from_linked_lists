package Linkedlist;

public class double_ll 
{

    public class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    public static Node head;
    public static Node tail;
    


    //add first
    public void add_first(int data)
    {
        Node newnode = new Node(data);
        if(head == null)
        {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;

    }

    //addlast
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;


    }

    //reverse a dll
    public void reverse()
    {
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
    }
    public static void main(String args[])
    {
        double_ll dll = new double_ll();

        dll.add_first(1);
        dll.add_first(2);
        dll.add_first(3);
        dll.add_first(4);
        dll.add_first(5);
        dll.addLast(10);
         dll.addLast(20);

         dll.reverse();

        dll.print();


    }
}
