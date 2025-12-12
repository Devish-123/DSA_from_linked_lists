package Stacks;
import java.util.*;
public class duplicate_parenthesis 
{

    public static boolean valid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == ')')
            {
                int count = 0;
               while(stack.peek()!='(')
               {
                count++;
                stack.pop();
                
               }
               if(count<1){
                return true;
               }
            }
            else {
                stack.push(ch);
            }
        }
        return false;
       
    }
    public static void main(String[] args) {
        System.out.println(valid("(a+b)"));
        System.out.println(valid("((a+b))"));
        
    }
    
}
