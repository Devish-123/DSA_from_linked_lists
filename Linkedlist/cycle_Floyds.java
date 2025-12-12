package Linkedlist;

public class cycle_Floyds 
{
    public static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    // Detect cycle using Floyd's Algorithm
    public static boolean floyds_cycle()
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                return true; // cycle found
            }
        }
        return false; // no cycle
    }

    // Break the cycle if exists
    public static void cycle_break()
    {
        Node slow = head;
        Node fast = head;

        boolean value = false;

        // Step 1: Detect cycle (Floyd’s cycle detection)
        while(fast != null && fast.next != null)
        {
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast) // meeting point
           {
            value = true;
            break;
           } 
        }

        // If no cycle → just return
        if(!value)
        {
            return;
        }

        // Step 2: Move slow to head, keep fast at meeting point
        slow = head;
        Node prev = null; // This will track node before 'fast'

        // Step 3: Move both one step at a time until they meet
        // Problem: When slow==fast immediately (cycle starts at head),
        // 'prev' remains null → later prev.next = null throws NullPointerException
        while(slow != fast)
        {
            prev = fast; // store previous fast
            slow = slow.next;
            fast = fast.next;
        }

        // Step 4: Break the cycle
        // ❌ If cycle starts at head, prev is still null here → NPE occurs
        prev.next = null; 
    }

    // Print linked list
    public static void print()
    {
        Node temp = head;
        while(temp!=null)
        {   
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
         System.out.print("null");
    }

    public static void main(String[] args)
    {
        head = new Node(1);
        head.next = new Node(2);
        Node temp = new Node(2);   // This new node (temp) is created
        head.next = temp;          // but this line overwrites head.next, so Node(2) above is LOST
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);

        // creating cycle: last node (5) points back to 'temp'
        head.next.next.next.next = temp;

        // detect cycle
        boolean cycle = floyds_cycle();
        if(cycle)
        {
            cycle_break(); // Here NullPointerException occurs if cycle starts at head
        }
      
        print();  
    }
}
