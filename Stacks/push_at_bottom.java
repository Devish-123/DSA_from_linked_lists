package Stacks;
import java.util.*;
public class push_at_bottom 
{
    public static void main(String args[])
    {
       Stack<Integer> s = new Stack<>();
       s.push(1);
       s.push(2);
       s.push(3);
       push_bottom(s,4);
       while(!s.isEmpty())
       {
        System.out.println(s.pop());
       }
    }

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
    
}
