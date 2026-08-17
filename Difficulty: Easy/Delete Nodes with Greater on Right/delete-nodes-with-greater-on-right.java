/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        // reverse list
        Node prev = null;
        Node curr = head;

        while(curr != null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // process reversed list
        Node newHead = prev;
        Node maxNode = newHead;

        Node temp = newHead;

        while(temp != null && temp.next != null) {
            if(temp.next.data < maxNode.data) 
            {
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
                maxNode = temp;
            }
        }

        // reverse again
        prev = null;
        curr = newHead;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}