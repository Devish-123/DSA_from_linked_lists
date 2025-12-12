package queues;
import java.util.*;
public class using_stacks 
{
    public static class queue{
         Stack<Integer> s1 = new Stack<>();
         Stack<Integer> s2 = new Stack<>();
        public  boolean isEmpty(){
            return s1.isEmpty();
        }
        public void add(int n){
            s1.add(n);
           
        }
        public int remove(){
             if(s1.isEmpty()){
                return -1;
            }
             while(!s1.isEmpty()){
                s2.add(s1.pop());

            }
            return s2.pop();

        }
         public int peek(){
             while(!s1.isEmpty()){
                s2.add(s1.pop());

            }
             if(s2.isEmpty()){
                return -1;
            }
            return s2.peek();

        }
    }
    public static void main(String args[]){
        queue q = new queue();
        q.add(1);
        q.add(2);
        System.out.println(q.remove());
        System.out.println(q.peek());

    }
    
}
