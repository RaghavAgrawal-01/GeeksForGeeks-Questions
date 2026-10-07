/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum;
    public static void transformTree(Node root) {
        // code here
        sum=0;
        dfs(root);
        
    }
    static void dfs(Node root){
        if(root==null)
        return;
        
        dfs(root.right);
        sum+=root.data;
        root.data  = sum-root.data;
        dfs(root.left);
    }
}