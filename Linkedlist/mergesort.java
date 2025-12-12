package Linkedlist;

public class mergesort {
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

    // Function to find the middle of the linked list
    public static Node mid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted linked lists
    public static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Dummy node
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;

        return mergedLL.next;
    }

    // Merge sort function for linked list
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = mid(head);
        Node right = middle.next;
        middle.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(right);

        return merge(newLeft, newRight);
    }

    // Function to add a new node at the end
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Add elements to the linked list
        addLast(5);
        addLast(2);
        addLast(9);
        addLast(1);
        addLast(6);

        System.out.println("Original Linked List:");
        printList(head);

        // Sort the linked list
        head = mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
