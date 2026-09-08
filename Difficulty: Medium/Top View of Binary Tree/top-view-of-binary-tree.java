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
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if(!map.containsKey(hd)){
                map.put(hd, curr.data);
            }
            if(curr.left!=null){
                q.add(new Pair(curr.left, hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right, hd+1));
            }
        }
        for(int x:map.values()){
            list.add(x);
        }
        return list;
    }
    class Pair{
        Node node;
        int hd;
        Pair(Node n, int h){
            this.node=n;
            this.hd = h;
        }
    }
}