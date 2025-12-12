package Binarytrees;

public class in_order {
    // This program builds a binary tree from a PREORDER array
// where -1 represents a null child.
// Then it prints the INORDER traversal of the tree.


    // ---------------- NODE CLASS ---------------------
    // Represents one node of the binary tree
    static class Node {
        int data;      // value stored in node
        Node left;     // pointer to left child
        Node right;    // pointer to right child

        Node(int data) {
            this.data = data;
            this.left = null;   // initially no left child
            this.right = null;  // initially no right child
        }
    }

    // ---------------- TREE CLASS ---------------------
    static class tree {

        // Index used to read values from the array
        // It moves forward each time buildtree() is called
        static int index = -1;

        // Builds a binary tree using preorder traversal logic:
        // ROOT → LEFT → RIGHT
        public static Node buildtree(int arr[]) {

            index++;  // move to next element in array

            // If value is -1 → this position has no node → return null
            if (arr[index] == -1) {
                return null;
            }

            // Create a new node with the current value
            Node node = new Node(arr[index]);

            // Recursively build the left subtree
            node.left = buildtree(arr);

            // Recursively build the right subtree
            node.right = buildtree(arr);

            // Return the fully constructed node
            return node;
        }

        // ---------------- INORDER TRAVERSAL ---------------------
        // Inorder = LEFT → ROOT → RIGHT
        public static void inorder(Node root) {

            // Base case: if root is null, stop recursion
            if (root == null) {
                return;
            }

            // Traverse LEFT subtree first
            inorder(root.left);

            // Visit ROOT (print the value)
            System.out.print(root.data + " ");

            // Traverse RIGHT subtree
            inorder(root.right);
        }
    }

    // ---------------- MAIN FUNCTION ---------------------
    public static void main(String[] args) {

        // This is a valid PREORDER array with -1 as NULL markers
        // Represents the tree:
        //
        //                 1
        //           /             \
        //         2                 3
        //     /      \          /       \
        //    4        5        6         7
        //  /   \
        // 8     9
        //
        int[] nodes = {
            1, 
            2,
                4,
                    8, -1, -1,
                    9, -1, -1,
                5, -1, -1,
            3,
                6, -1, -1,
                7, -1, -1
        };

        tree t = new tree();   // create tree object
        Node root = t.buildtree(nodes);  // build tree from array

        // Print INORDER traversal of the constructed tree
        System.out.println("Inorder traversal:");
        t.inorder(root);
    }
}


    

