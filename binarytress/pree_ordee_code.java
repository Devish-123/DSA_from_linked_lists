package Binarytrees;

public class pree_ordee_code {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        static class BinaryTree{
            static int index = -1;
            public static Node buildtree(int nodes[]){
                index++;
                if(nodes[index] == -1){
                    return null;

                }
                Node newnode = new Node(nodes[index]);
                newnode.left = buildtree(nodes);
                newnode.right = buildtree(nodes);

                return newnode;
            }
        }
    
    public static void main(String args[]){
        int nodes[] = {1,23,45,-1,-1,56,-1,-1,67,78,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildtree(nodes);
        System.out.println(root.data);
        hi

    }
    }

