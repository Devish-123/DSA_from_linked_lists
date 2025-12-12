package Stacks;
import java.util.*;
public class reverse_a_stack 
{

    //push_bottom function
    public static void push_bottom(Stack<Integer> s,int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        int value = s.pop();
        push_bottom(s,data);
        s.push(value);

    }
     
    //reverse a stack
    public static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            return;
        }
        int value = s.pop();
        reverse(s);
        push_bottom(s,value);
    }
        public static void main(String args[])
    {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverse(s);
        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }
    
}
