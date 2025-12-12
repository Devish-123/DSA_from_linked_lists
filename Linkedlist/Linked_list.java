package Linkedlist;
public class Linked_list
{
    public static class Node
    {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    //add first
    public void addFirst(int n)
    {

        //step1 craete a new node
        Node newNode = new Node(n);
        size++;
        if(head == null)
        {
            head = tail = newNode;
        }

        //step2 initialize next node to head
        newNode.next = head;

        //step 3 head is new node now
        head = newNode;

    }

    //addLast
    public void addLast(int n)
    {
        //craete new Node
        Node newNode = new Node(n);
        size++;
        if(head == null)
        {
            head = tail = newNode;
        }
        //after the tail element we are adding the element
        tail.next = newNode;
        //tail is the last element now
        tail = newNode;
    }

    //print the linked list
    public void print()
    {
       if(head == null)
       {
        System.out.println("Linked list is empty");
        return;
       }
       Node temp = head;
       while(temp != null)
       {
        System.out.print(temp.data +"->");
        temp = temp.next;
       }
         System.out.print("null");
    }


    //to add in the middle
    public void add(int idx,int n)
    {
        if(idx == 0 )
        {
            addFirst(n);
            return;
        }
        Node newNode = new Node(n);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1)
        {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //to remove first
    public int removeFirst()
    {
        if(size == 0)
        {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1)
        {
            head = tail = null;
            size = 0;
            return head.data;
        }
        size--;
        int value = head.data;
        head = head.next;
        return value;
    }

    //remove last
    public int removeLast()
    {
        if(size == 0)
        {
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1)
        {
            int value = tail.data;
            head = tail = null;
            size = 0 ;
            return value;
        }
        Node temp = head;
        int i = 0;
        int data = tail.data;
        while(i < size-2)
        {
            i++;
            temp = temp.next;
            
        }
        
        temp.next = null;
        tail = temp;
        size--;
        return data;

    }

    //iterative search
    public int itrsearch(int key)
    {
        Node temp = head;
        int i = 0;
        while(temp != null)
        {
            if(temp.data == key)
            {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recSearch(int key)
    {
         return helper(head,key);
    }
    public int helper(Node head,int key)
    {
        if(head == null)
        {
            return -1;
        }
        if(head.data == key)
        {
            return 0;
        }
        int idx =  helper(head.next,key);
        if(idx == -1)
        {
             return -1;
        }
        return idx+1;
    }
    

    //reverse
    public void reverse()
    {
        Node pre = null;
        Node curr = tail = head;
        Node next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        head = pre;
    }
   //to delete nth element from the end of list
    public void delete_nth_node_from_end(int n)
    {
        if (head == null) 
        {
            System.out.println("List is empty");
            return;
        }
        int sz = 0;
        Node temp = head;
        while(temp!=null)
        {
            temp = temp.next;
            sz++;
        }
        Node prev = null;
        Node temp1 = head;
        int i = 0;
        while(i < sz-n)
        {
           prev = temp1;
           temp1 = temp1.next;
           i++;
        }
        prev.next = temp1.next;

    }

    //to find mid
    public Node mid(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //is palindrome or not
    public boolean isplaindrome()
    {
        if(head == null || head.next == null)
        {
            return true;
        }
          
        Node mid = mid(head);
        Node prev = null;
        Node cur = mid;
        Node next;
         while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        Node right = prev;
        Node temp = head;
        while(right!=null)
        {
            if(temp.data!=right.data)
            {
                return false;

            }
            temp = temp.next;
            right = right.next;
        }
        return true;


    }
    public static void main(String args[])
    {
        Linked_list list = new Linked_list();
        list.addFirst(1);
        list.addFirst(1);
        list.addLast(1);
         list.addLast(2);
         list.add(2,2);

         //to remove the first element
        //  list.removeFirst();
        //  list.removeLast();
        //  list.reverse();
        
         list.print();
         System.out.println(list.isplaindrome());
        //  System.out.println(list.recSearch(3));
        //  System.out.println(list.recSearch(1));
      

    }
}