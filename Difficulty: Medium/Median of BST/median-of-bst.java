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

// class Solution {
//     public int findMedian(Node root) {
//         // Code here
        
//     }
// }






class Solution {
    public int findMedian(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();

        if (n % 2 == 0) {
            // GFG expects the lower of the two middle values (not average)
            return list.get(n / 2 - 1);
        } else {
            return list.get(n / 2);
        }
    }

    private void inorder(Node root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
