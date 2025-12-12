package queues;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class first_non_repeating {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c = 'a';c<='z';c++){
            map.put(c,0);
        }
        Queue<Character> queue = new LinkedList<>();
        String s = "abcd";
        //a-1bbbbx
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            map.put(ch,map.get(ch)+1);
            queue.add(s.charAt(i));
           while(!queue.isEmpty() && map.get(queue.peek()) > 1){
               queue.poll();
           }
           if(queue.isEmpty()){
               sb.append("-1");
           }
           else{
               sb.append(queue.peek());
           }
          
        }
        System.out.println(sb);
        
        
    }
}