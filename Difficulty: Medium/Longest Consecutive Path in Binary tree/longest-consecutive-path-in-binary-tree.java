/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    private int maxLen = 0;
    public int longestConsecutive(Node root) {
        // code here
        if(root == null) return -1;
        maxLen = 0;
        solve(root, 0, root.data);
        return maxLen <= 1 ? -1 : maxLen;
    }

    private void solve(Node node, int currLen, int expectedVal) {
        if(node == null) return;
        if(node.data == expectedVal) 
        {
            currLen++;
        } 
        else {
            currLen = 1;
        }
        maxLen = Math.max(maxLen, currLen);
        solve(node.left, currLen, node.data + 1);
        solve(node.right, currLen, node.data + 1);
        
    }
}