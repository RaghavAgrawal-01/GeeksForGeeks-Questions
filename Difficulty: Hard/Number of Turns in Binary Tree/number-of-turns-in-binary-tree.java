/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    private Node findLCA(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) return root;

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if(left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    private boolean countTurns(Node root, int key, boolean turn, int[] count) {
        if(root == null) return false;

        if(root.data == key) return true;

        if(turn) {
            if(countTurns(root.left, key, turn, count)) return true;
            if(countTurns(root.right, key, !turn, count)) {
                count[0]++;
                return true;
            }
        } else {
            if(countTurns(root.right, key, turn, count)) return true;
            if(countTurns(root.left, key, !turn, count)) {
                count[0]++;
                return true;
            }
        }
        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {
        if(root == null || p == q) return -1;

        Node lca = findLCA(root, p, q);
        if(lca == null) return -1;

        int[] count = new int[]{0};

        if(lca.data != p && lca.data != q) {
            if(countTurns(lca.left, p, true, count) || countTurns(lca.right, p, false, count)) {
                if(countTurns(lca.left, q, true, count) || countTurns(lca.right, q, false, count)) {
                    return count[0] + 1;
                }
            }
            return -1;
        }

        int target = (lca.data == p) ? q : p;
        if(countTurns(lca.left, target, true, count) || countTurns(lca.right, target, false, count)) {
            return count[0] == 0 ? -1 : count[0];
        }

        return -1;
    }
}