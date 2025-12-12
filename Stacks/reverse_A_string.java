package Stacks;
import java.util.*;
public class reverse_A_string 
{

    //reverse function
    public static String string_reverse(String s)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++)
        {
            stack.push(s.charAt(i));
        }
        while(!stack.isEmpty())
        {
            char c = stack.pop();
            sb.append(c);

        }
        return sb.toString();

    }

    public static void main(String args[])
    {
        System.out.println(string_reverse("devish"));

    }

    
}
