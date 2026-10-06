/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/



//optimal
//n, n

// class Solution {
//     HashMap<Node, Integer> dp = new HashMap<>();
//     public int getMaxSum(Node root) {
//         // Add your code here
//         return rec(root);
//     }
//     // Function to return the maximum sum of non-adjacent nodes.
//      int rec(Node root) {
//         if (root == null)
//             return 0;
        
//         if (dp.containsKey(root))
//             return dp.get(root);

//         int nottake = rec(root.left) + rec(root.right);

//         int take = root.data;
//         if (root.left != null)
//             take += rec(root.left.left) + rec(root.left.right);
        
//         if (root.right != null)
//             take += rec(root.right.left) + rec(root.right.right);

//       int result = Math.max(take, nottake);
//         dp.put(root, result);
//         return result;
//     }
// }















class Solution {
    int[] solve(Node root) {
        if(root == null)
        {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int include = root.data + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }

    public int getMaxSum(Node root) {
        int[] res = solve(root);
        return Math.max(res[0], res[1]);
    }
}