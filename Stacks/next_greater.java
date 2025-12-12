package Stacks;
import java.util.*;
public class next_greater 
{
    public static void main(String args[])
    {
        int arr[] = {6,5,0,1,3};
        int next_greater[] = new int[arr.length];
        Stack<Integer>stack = new Stack<>();
        for(int i = arr.length-1;i>=0;i--)
        {

            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
            {
               stack.pop();
            }
            if(stack.isEmpty())
            {
                next_greater[i] = -1;
            }
            else{
                next_greater[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(next_greater));

    }
    
}
