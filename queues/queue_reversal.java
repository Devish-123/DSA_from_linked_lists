package queues;

import java.util.*;
public class queue_reversal {
    
public static void main(String args[]){
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    for(int i = 1;i<6;i++){
        q.add(i);
    }
    while(!q.isEmpty()){
        stack.push(q.poll());
    }
    System.out.println(stack);
    while(!stack.isEmpty()){
        q.add(stack.pop());
    }
    System.out.println(q);

    

}
}

