/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    int solve(Node root) {
        if(root == null) {
            return 0;
        }
        int old = root.data;
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        root.data = leftSum + rightSum;
        return old + root.data;
    }
    public void toSumTree(Node root) {
        solve(root);
    }
}