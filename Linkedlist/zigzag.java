package Linkedlist;

public class zigzag {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if(tail == null) tail = newNode;
    }

    public Node mid(){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void zig(){
        // Find middle
        Node mid = mid();

        // Reverse second half
        Node prev = null;
        Node cur = mid.next;
        mid.next = null; // split list into two halves
        Node next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // Merge alternately
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){
        zigzag list = new zigzag();
        list.addFirst(1);
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(7); // list: 7->5->3->1

        System.out.println("Original List:");
        list.printList();

        list.zig();
        System.out.println("Zigzag List:");
        list.printList();
    }
}
