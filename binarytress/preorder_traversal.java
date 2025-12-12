// Online Java Compiler
// [5, 10, -1, -1, 20, -1, -1]


class preorder_traversal {
    
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class tree{
        static int index = -1;
        public static Node buildtree(int arr[]){
            index++;
            if(arr[index] == -1){
                return null;
            }
            Node node = new Node(arr[index]);
            node.left = buildtree(arr);
            node.right = buildtree(arr);
            return node;
            
        }
        
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+
            " ");
            preorder(root.left);
            preorder(root.right);
            
        }
        
    }
    public static void main(String[] args) {
        int[] nodes = {5, 10, -1, -1, 20, -1, -1};
      tree t = new tree();
        Node node = t.buildtree(nodes);
       t.preorder(node);
        
        
       
    }
}