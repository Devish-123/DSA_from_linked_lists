package queues;
import java.util.*;
public class inter_leave {
    public static void main(String args[]){
        Queue<Integer> q1 = new LinkedList<>();
         Queue<Integer> q2 = new LinkedList<>();
        for(int i = 1;i<=10;i++){
            q1.add(i);
        }
        int n = q1.size()/2;
        for(int i = 1;i<=n;i++){
            q2.add(q1.poll());

        }
        while(!q2.isEmpty()){
            q1.add(q2.poll());
            q1.add(q1.poll());
        }
        System.out.println(q1);
           
    }
    
}
