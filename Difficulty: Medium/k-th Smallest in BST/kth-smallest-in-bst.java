// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    int count=0;
    int res=-1;
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        count=k;
        res=-1;
        utils(root);
        return res;
    }
    
    void utils(Node root)
    {
        if(root==null)
        {
            return;
        }
        utils(root.left);
        --count;
        
        if(count==0)
        {
            res=root.data;
            return;
        }
        utils(root.right);
    }
}