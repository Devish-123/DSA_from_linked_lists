package queues;
public class circular_queue {
    public static class queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        queue(int n){
            size = n;
            arr = new int[size];
            rear = -1;
            front = -1;
        }
        public boolean isEmpty(){
            return (rear == -1);
        }
        public boolean isFull(){
            return ((rear+1)%size == front);
        }
        public void add(int n){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = n;
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int number = arr[front];
            
           
            if(front == rear){
                front = rear = -1;
            }else{
                 front = (front +1)%size;
            }
            return number;
        }
        public int peek(){
            if(rear == -1){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
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
