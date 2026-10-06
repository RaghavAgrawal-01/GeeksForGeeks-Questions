/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int maxSum;

    int solve(Node root) {
        if (root == null)
        {
            return 0;
        }

        if (root.left == null && root.right == null)
        {
            return root.data;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        if (root.left != null && root.right != null)
        {
            maxSum = Math.max(maxSum, left + right + root.data);
            return Math.max(left, right) + root.data;
        }

        return (root.left == null) ? right + root.data : left + root.data;
    }

    int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        int val = solve(root);

        if (root != null && (root.left == null || root.right == null))
        {
            if (maxSum == Integer.MIN_VALUE)
            {
                return -1;
            }
        }

        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}