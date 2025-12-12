package binarytress;

import java.util.*;

public class sum_nodes {

    // Online Java Compiler
// [5, 10, -1, -1, 20, -1, -1]



    
    // -----------------------------------------------------------
    // NODE CLASS
    // Represents a single node in the binary tree.
    // Each node contains:
    //   - data : value stored in the node
    //   - left : pointer to left subtree
    //   - right: pointer to right subtree
    // -----------------------------------------------------------
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // -----------------------------------------------------------
    // TREE CLASS
    // Contains method to build a binary tree from an array that
    // represents a PREORDER traversal where -1 indicates NULL.
    // -----------------------------------------------------------
    static class tree {
        static int index = -1; // Global index tracking current position in array

        public static Node buildtree(int arr[]) {
            index++; // Move to next element

            // Base condition:
            // If current value is -1 → no node at this position → return null
            if (arr[index] == -1) {
                return null;
            }

            // Create a new node with the current value
            Node node = new Node(arr[index]);

            // Recursively build LEFT subtree
            node.left = buildtree(arr);

            // Recursively build RIGHT subtree
            node.right = buildtree(arr);

            return node; // Return root of this subtree
        }
    }

    public static void main(String[] args) {

        // PREORDER representation of the binary tree
        // -1 means the node is NULL
        int[] nodes = {1,2,4,8,-1,-1,9,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        tree t = new tree();

        // Build tree from given array
        Node node = t.buildtree(nodes);

        // Print sum using BFS (level order)
        System.out.println(level_order_sum(node));

        // Print sum using recursion
        System.out.println(count_recursive(node));
    }

    // -----------------------------------------------------------
    // FUNCTION 1: level_order_sum
    //
    // Computes the **sum of all nodes** in the tree
    // using LEVEL ORDER TRAVERSAL (BFS).
    //
    // We use:
    // - A queue to process nodes level by level
    // - A NULL marker to detect when a level ends
    //
    // Steps:
    // 1. Add root + null to queue
    // 2. Pop nodes one by one
    // 3. Add their values to sum
    // 4. Add children to queue
    // 5. When null appears, end of level → add another null
    // -----------------------------------------------------------
    public static int level_order_sum(Node node) {

        Queue<Node> q = new LinkedList<>();

        // If tree is empty, sum is 0
        if (node == null) {
            return 0;
        }

        q.add(node);  // Add root
        q.add(null);  // Add level marker

        int sum = 0;  // Stores total sum of all nodes

        while (!q.isEmpty()) {

            Node curr = q.remove(); // Remove current element

            // CASE 1: NULL marker → end of a level
            if (curr == null) {

                // If queue empty → no more nodes left
                if (q.isEmpty()) {
                    break;
                } else {
                    // Add another NULL to mark next level
                    q.add(null);
                }
            }

            // CASE 2: Valid node
            else {

                // Add node’s data to sum
                sum += curr.data;

                // Add LEFT child if exists
                if (curr.left != null) {
                    q.add(curr.left);
                }

                // Add RIGHT child if exists
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return sum; // Final sum of all nodes
    }

    // -----------------------------------------------------------
    // FUNCTION 2: count_recursive
    //
    // Recursively computes the sum of all nodes in the tree.
    //
    // Recursion Logic:
    // - If node is NULL → return 0  (base case)
    // - Compute sum of left subtree
    // - Compute sum of right subtree
    // - Return (left sum + right sum + current node’s value)
    //
    // This works because recursion naturally explores all nodes.
    // -----------------------------------------------------------
    public static int count_recursive(Node n) {

        // Base condition:
        // If node is null → contributes 0 to the sum
        if (n == null) {
            return 0;
        }

        // Recursively compute left subtree sum
        int left = count_recursive(n.left);

        // Recursively compute right subtree sum
        int right = count_recursive(n.right);

        // Return total sum for this subtree
        return left + right + n.data;
    }

}

    

