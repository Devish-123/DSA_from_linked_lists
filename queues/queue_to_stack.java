package queues;
import java.util.*;
public class queue_to_stack 
{
    public static class stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty();
        }
        public void push(int n){
            q1.add(n);
        }
        public int pop(){
            if(q1.isEmpty() && q2.isEmpty()){
                return -1;
            }
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            int n = q1.remove();
           Queue<Integer> temp = q1;
           q1 = q2;
           q2 = temp;
            return n;
        }
        public int peek(){
            if(q1.isEmpty() && q2.isEmpty()){
                return -1;
            }
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            int n = q1.peek();
            q2.add(q1.remove());
           Queue<Integer> temp = q1;
           q1 = q2;
           q2 = temp;
            return n;
        }
    }
    public static void main(String args[]){
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek());

        
    }
    
}
