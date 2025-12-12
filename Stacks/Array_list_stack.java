package Stacks;
import java.util.*;
public class Array_list_stack 
{

    public static class Stack
    {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty()
        {
           return list.size() == 0;
        }

        public void push(int data)
        {
            list.add(data);
        }

        public int pop()
        {
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }

        public int peek()
        {
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.isEmpty());

        System.out.println(s.pop());

        System.out.println(s.peek());


 
    }
}
