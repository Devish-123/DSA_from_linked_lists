package queues;

import java.util.*;
public class stack_with_deque {

     static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String args[]){
        push(1);
        push(5);
        push(6);
        push(7);
        push(8);

        while(!deque.isEmpty()){
            System.out.println(pop());
        }



          
   


    }
    public static void push(int n){
            deque.add(n);
    };
      public static int pop(){
           return deque.removeLast();
    };
    public static int peek(){
        return deque.getLast();
    }
}



    
    
  
    

