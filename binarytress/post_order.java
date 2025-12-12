package Binarytrees;

public class post_order {
    // ------------------------------------------------------------
// BUILDING & TRAVERSING A BINARY TREE USING RECURSION
// ------------------------------------------------------------
//
// This program builds a Binary Tree using a PREORDER array format:
// ROOT → LEFT → RIGHT
//
// A value of -1 represents that a node does NOT exist (NULL CHILD).
//
// Example array used here:
//   {1,2,4,8,-1,-1,9,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1}
//
// The tree structure formed:
//
//                  1
//             /          \
//            2            3
//         /     \      /     \
//        4       5    6       7
//      /   \
//     8     9
//
// ------------------------------------------------------------
// Traversals:
// ------------------------------------------------------------
// PREORDER  = ROOT → LEFT → RIGHT
// INORDER   = LEFT → ROOT → RIGHT
// POSTORDER = LEFT → RIGHT → ROOT
//
// ------------------------------------------------------------



    // ---------------- NODE CLASS ----------------
    // Each node contains:
    // - data (the value)
    // - left child
    // - right child
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ---------------- TREE CLASS ----------------
    static class tree {

        // Global index used to read the array in preorder
        static int index = -1;

        // ------------------------------------------------------------
        // BUILD TREE FROM PREORDER ARRAY
        //
        // PREORDER BUILD LOGIC:
        // 1. Read current value
        // 2. If -1 → this node does not exist
        // 3. Else create node
        // 4. Recursively build LEFT subtree
        // 5. Recursively build RIGHT subtree
        // ------------------------------------------------------------
        public static Node buildtree(int arr[]) {
            index++; // move to next value

            // BASE CASE: if current value is -1 → return NULL
            if (arr[index] == -1) {
                return null;
            }

            // Create a new node
            Node node = new Node(arr[index]);

            // Build LEFT subtree recursively
            node.left = buildtree(arr);

            // Build RIGHT subtree recursively
            node.right = buildtree(arr);

            return node;
        }

        // ------------------------------------------------------------
        // PREORDER: ROOT → LEFT → RIGHT
        // ------------------------------------------------------------
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " "); // print root
            preorder(root.left);               // left subtree
            preorder(root.right);              // right subtree
        }

        // ------------------------------------------------------------
        // INORDER: LEFT → ROOT → RIGHT
        // (For BST gives sorted order)
        // ------------------------------------------------------------
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }

            inorder(root.left);                // left subtree
            System.out.print(root.data + " "); // print root
            inorder(root.right);               // right subtree
        }

        // ------------------------------------------------------------
        // POSTORDER: LEFT → RIGHT → ROOT
        // ------------------------------------------------------------
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.left);    // left subtree
            postorder(root.right);   // right subtree
            System.out.print(root.data + " "); // print root
        }
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        // PREORDER ARRAY WITH NULL MARKERS (-1)
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

        // Create tree object
        tree t = new tree();

        // Build the binary tree
        Node root = t.buildtree(nodes);

        // ---------------- PRINT TRAVERSALS ----------------

        System.out.println("\nPOSTORDER Traversal (L R Root):");
        t.postorder(root);

        System.out.println("\n\nINORDER Traversal (L Root R):");
        t.inorder(root);

        System.out.println("\n\nPREORDER Traversal (Root L R):");
        t.preorder(root);

        System.out.println();
    }
}


    

