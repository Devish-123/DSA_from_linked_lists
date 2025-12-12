package Stacks;

public class stack_linked_list 
{
    public static class Node
    {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class stack
    {
        Node head = null;

       public boolean isEmpty()
       {
            return  head == null;
       }

       public void push(int data)
       {
        Node new_node = new Node(data);
        if(head == null)
        {
            head = new_node;
        }
        new_node.next = head;
        head = new_node;
        

       }

       public int pop()
       {
        if(head == null)
        {
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
       }

       public int peek()
       {
        return head.data;
       }
    }
    public static void main(String args[])
    {
        stack s = new stack();
        System.out.println(s.isEmpty());
        s.push(2);
          s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.isEmpty());

        System.out.println(s.pop());

        System.out.println(s.peek());

    }
    
}
