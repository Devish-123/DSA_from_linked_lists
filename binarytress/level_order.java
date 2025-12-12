package binarytress;

    // Online Java Compiler
// [5, 10, -1, -1, 20, -1, -1]

import java.util.*;

class Main {
    
    // -----------------------------------------------------------
    // NODE CLASS - Represents a single node in the binary tree
    // Each node contains:
    //  - data  → integer value
    //  - left  → pointer/reference to left child
    //  - right → pointer/reference to right child
    // -----------------------------------------------------------
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // -----------------------------------------------------------
    // TREE CLASS - Contains methods to build and traverse the tree
    // -----------------------------------------------------------
    static class tree {

        // This static index keeps track of our position in the array
        static int index = -1;

        // -----------------------------------------------------------
        // BUILD TREE FROM PREORDER ARRAY (WITH -1 AS NULL)
        //
        // Example input:
        // {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1}
        //
        // PREORDER BUILD LOGIC:
        // 1. Increase index
        // 2. If current value is -1 → node does NOT exist → return null
        // 3. Otherwise create a node
        // 4. Recursively build left subtree
        // 5. Recursively build right subtree
        // -----------------------------------------------------------
        public static Node buildtree(int arr[]) {
            index++;  // Move to next element in the array

            // If the value is -1, this is a NULL child
            if (arr[index] == -1) {
                return null;
            }

            // Create a new node with current value
            Node node = new Node(arr[index]);

            // Recursive calls: build left and right subtrees
            node.left = buildtree(arr);
            node.right = buildtree(arr);

            return node; // return constructed subtree root
        }

        // -----------------------------------------------------------
        // LEVEL ORDER TRAVERSAL (Breadth First Search)
        //
        // Process:
        // 1. Use a queue to process nodes level-by-level
        // 2. Add root, then add a NULL → level separator
        // 3. Remove nodes one by one
        // 4. When a NULL is removed → level is complete → print newline
        // 5. Add children of current node to queue
        //
        // NULL markers are used to know when a level ends.
        // -----------------------------------------------------------
        public static void levelorder(Node root) {

            // If tree is empty
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();

            q.add(root);  // Add the root node
            q.add(null);  // Add null marker for end of level

            // Continue until all nodes and null markers are processed
            while (!q.isEmpty()) {

                Node currNode = q.remove(); // Remove from front of queue

                // ----------------------  
                // CASE 1: Level complete
                // ----------------------
                if (currNode == null) {
                    System.out.println(); // Move to next line

                    // If queue empty → traversal complete
                    if (q.isEmpty()) {
                        break;
                    } else {
                        // Add NULL for next level
                        q.add(null);
                    }
                }

                // ----------------------
                // CASE 2: Valid node
                // ----------------------
                else {
                    // Print current node's data
                    System.out.print(currNode.data + " ");

                    // Add left child if exists
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    // Add right child if exists
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    // -----------------------------------------------------------
    // MAIN METHOD
    // -----------------------------------------------------------
    public static void main(String[] args) {

        // Tree represented in PREORDER with -1 as NULL indicator
        int[] nodes = {
            1, 2, 4, 8, -1, -1, 9, -1, -1,
            5, -1, -1,
            3, 6, -1, -1,
            7, -1, -1
        };

        tree t = new tree();

        // Build tree from array
        Node node = t.buildtree(nodes);

        // Perform level-order traversal
        t.levelorder(node);
    }
}

    

