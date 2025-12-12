package binarytress;

import java.util.*;

public class count_nodes {

    // Online Java Compiler
// [5, 10, -1, -1, 20, -1, -1]



    
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
        
        
        
       
        
    }
    public static void main(String[] args) {
      int[] nodes = {1,2,4,8,-1,-1,9,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

      tree t = new tree();
        Node node = t.buildtree(nodes);
       System.out.println(count(node));
        
        
       
    }
   
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftcount = count(root.left);
        int rightcount = count(root.right);
        
        return leftcount+rightcount+1;
    }
    
    
    
    
    
    
    
}


    

