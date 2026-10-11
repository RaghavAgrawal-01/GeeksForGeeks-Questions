/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;
        Node merged = null;

        for (Node list : lists) {
            Node l1 = merged;
            Node l2 = list;
            Node dummy = new Node(0);
            Node tail = dummy;

            while (l1 != null && l2 != null) {
                if (l1.data < l2.data) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            if (l1 != null) tail.next = l1;
            else tail.next = l2;

            merged = dummy.next;
        }
        return merged;
    }
}
