package queues;
public class arrays {
    public static class queue{
        static int arr[];
        static int size;
        static int rear;
        queue(int n){
            size = n;
            arr = new int[size];
            rear = -1;
        }
        public boolean isEmpty(){
            return (rear == -1);
        }
        public void add(int n){
            if(rear == size-1){
                System.out.println("queue is full");
                return;
            }
            arr[++rear] = n;
        }
        public int remove(){
            if(rear == -1){
                System.out.println("queue is empty");
                return -1;
            }
            int number = arr[0];
            for(int i = 0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return number;
        }
        public int peek(){
            if(rear == -1){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }
        public void print(){
             if(rear == -1){
                System.out.println("queue is empty");
                return;
            }
            while(!isEmpty()){
                System.out.println(peek());
                remove();
            }
        }
    }
    public static void main(String args[]){
        queue queue = new queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();
        
        
    }
    
}
