/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
// class Solution {
//     class Result {
//         int maxLen;
//         int maxSum;
//         Result(int maxLen, int maxSum){
//             this.maxLen = maxLen;
//             this.maxSum = maxSum;
//         }
//     }
    
//     public int sumOfLongRootToLeafPath(Node root) {
//         // code here
//         Result res = helper(root);
//         return res.maxSum;
//     }
    
//     private Result helper(Node node){
//         if(node == null ){
//             return new Result(0,0);
//         }
//         Result left = helper(node.left);
//         Result right = helper(node.right);
//         if(left.maxLen > right.maxLen){
//             return new Result(left.maxLen + 1, left.maxSum + node.data);
//         }else if(right.maxLen > left.maxLen) {
//             return new Result(right.maxLen + 1,right.maxSum + node.data);
//         }else {
//             int maxSum = Math.max(left.maxSum, right.maxSum);
//             return new Result(left.maxLen + 1, maxSum + node.data);
//         }
//     }
// }


















// Approach: Use DFS traversal from root to each leaf, keeping track of the current path length and current path sum. At each leaf, update the maxLen and maxSum accordingly.
// Time Complexity: O(N) where N is the number of nodes, since each node is visited once.
// Space Complexity: O(H) where H is the height of the tree, due to the recursion stack.

/*
 * class Node {
 *  int data;
 *  Node left, right;
 *
 *  public Node(int data){
 *      this.data = data;
 *  }
 * }
 */

class Solution {
    int maxLen = 0; // Stores the length of the longest path from root to leaf
    int maxSum = 0; // Stores the maximum sum along the longest path
    // Helper method to perform DFS traversal
    void dfs(Node node, int currLen, int currSum) {
        if(node == null) {
            return; // Base case: if node is null, just return
        }
        currLen += 1;             // Increment path length
        currSum += node.data;     // Add node value to path sum
        // If it's a leaf node
        if(node.left == null && node.right == null) {
            if(currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            }
            else if (currLen == maxLen && currSum > maxSum) {
                maxSum = currSum;
            }
            return;
        }
        // Recur for left and right subtree
        dfs(node.left, currLen, currSum);
        dfs(node.right, currLen, currSum);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        dfs(root, 0, 0);  // Start DFS with initial length and sum as 0
        return maxSum;    // Return the max sum found
    }
}

/*
 *
 * Dry Run
 * Tree:
 *          1
 *        /   \
 *       2     3
 *      /     / \
 *     4     5   6
 *            \
 *             7
 *
 * Start at root (1)
 * - currLen = 1, currSum = 1
 *
 * Go to left child (2)
 * - currLen = 2, currSum = 3
 *
 * Go to left child (4)
 * - currLen = 3, currSum = 7 -> leaf node
 * - maxLen = 3, maxSum = 7
 *
 * Backtrack to node 1 -> Go to right child (3)
 * - currLen = 2, currSum = 4
 *
 * Go to left child (5)
 * - currLen = 3, currSum = 9
 *
 * Go to right child (7)
 * - currLen = 4, currSum = 16 -> leaf node
 * - maxLen = 4, maxSum = 16
 *
 * Go to right child (6)
 * - currLen = 3, currSum = 10 -> leaf node
 * - maxLen remains 4, maxSum remains 16
 *
 * Final answer: 16
 *
 */