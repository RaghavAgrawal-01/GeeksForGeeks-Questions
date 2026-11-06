/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        fun(root, 0, list);
        return list;
    }
    void fun(Node root, int l, ArrayList<Integer> list){
        if(root==null) return;
        if(l==list.size()){
            list.add(root.data);
        }
        fun(root.left, l+1, list);
        fun(root.right, l+1, list);
    }
}