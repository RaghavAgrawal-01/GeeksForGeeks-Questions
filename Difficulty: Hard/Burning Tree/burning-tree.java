/*
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
*/
class Solution {
    private int maxDepth(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private int traverse(Node node, int target, int[] ret) {
        if (node == null) return 0;
        if (node.data == target) {
            ret[0] = Math.max(ret[0], maxDepth(node.left));
            ret[0] = Math.max(ret[0], maxDepth(node.right));
            return 1;
        }

        int left = traverse(node.left, target, ret);
        int right = traverse(node.right, target, ret);

        if (left > 0) {
            ret[0] = Math.max(ret[0], left + maxDepth(node.right));
            return left + 1;
        }

        if (right > 0) {
            ret[0] = Math.max(ret[0], right + maxDepth(node.left));
            return right + 1;
        }

        return 0;
    }

    public int minTime(Node root, int target) {
        int[] ret = new int[1];
        traverse(root, target, ret);
        return ret[0];
    }
}