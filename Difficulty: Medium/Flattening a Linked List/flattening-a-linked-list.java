/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        if(root == null) return null;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        Node curr = root;
        while(curr != null) {
            pq.add(curr);
            curr = curr.next;
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while(!pq.isEmpty()) {
            Node minNode = pq.poll();

            tail.bottom = minNode;
            tail = minNode;

            if(minNode.bottom != null) {
                pq.add(minNode.bottom);
            }
        }

        tail.bottom = null;
        return dummy.bottom;
    }
}