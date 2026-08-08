/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        // code here
        return build(pre, 0, pre.length - 1, preMirror, 0, preMirror.length - 1);
    }
    
    private Node build(int[] pre, int preStart, int preEnd, int[] preMirror, int mirrorStart, int mirrorEnd) {
        if(preStart > preEnd) return null;
        Node root = new Node(pre[preStart]);
        if(preStart == preEnd) return root;
        int leftRootVal = pre[preStart + 1];
        int mirrorIdx = mirrorStart;
        while (mirrorIdx <= mirrorEnd) 
        {
            if (preMirror[mirrorIdx] == leftRootVal) break;
            mirrorIdx++;
        }
        int leftSize = mirrorEnd - mirrorIdx + 1;
        root.left = build(pre, preStart + 1, preStart + leftSize, preMirror, mirrorIdx, mirrorEnd);
        root.right = build(pre, preStart + leftSize + 1, preEnd, preMirror, mirrorStart + 1, mirrorIdx - 1);
        return root;
    }
}