/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        if(root == null || k <= 0) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 1;
        int count = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                Node curr = q.poll();
                if(curr.left == null && curr.right == null) {
                    if(k >= level) {
                        k -= level;
                        count++;
                    } else {
                        return count;
                    }
                }

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }

            level++;
        }

        return count;
    }
}