/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private Integer prev;
    private int minDiff;

    public int absDiff(Node root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);

        if(prev != null) {
            minDiff = Math.min(minDiff, root.data - prev);
        }
        prev = root.data;

        inorder(root.right);
    }
}