package queues;
import java.util.*;
public class queue_with_deque {
    static class queue{
        Deque<Integer> deque = new ArrayDeque<>();
        void add(int n){
            deque.addLast(n);
        }
        int remove(){
            return deque.removeFirst();
        }
        int peek(){
            return deque.getFirst();
        }
        boolean isEmpty(){
            return deque.isEmpty();
        }
    }
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println("peek "+q.peek());
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }    
    }
}
