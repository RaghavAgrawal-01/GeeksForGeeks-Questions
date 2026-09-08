// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Info {
    boolean isBST;
    int size;
    int minVal;
    int maxVal;

    Info(boolean isBST, int size, int minVal, int maxVal) {
        this.isBST = isBST;
        this.size = size;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
}

class Solution {
    private Info largestBSTHelper(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBSTHelper(root.left);
        Info rightInfo = largestBSTHelper(root.right);
        if(leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.maxVal && root.data < rightInfo.minVal) {
            return new Info(true, 1 + leftInfo.size + rightInfo.size, 
                Math.min(root.data, leftInfo.minVal), Math.max(root.data, rightInfo.maxVal));
        }
        else {
            return new Info(false, Math.max(leftInfo.size, rightInfo.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    }
    public int largestBst(Node root) {
        return largestBSTHelper(root).size;
    }
}