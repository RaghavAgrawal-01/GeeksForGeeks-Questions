/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);

        return new ArrayList<>(map.values());
    }

    private void dfs(Node root, int hd, TreeMap<Integer, Integer> map) {
        if(root == null) return;
        map.put(hd, map.getOrDefault(hd, 0) + root.data);
        dfs(root.left, hd - 1, map);
        dfs(root.right, hd + 1, map);
    }
}