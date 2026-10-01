/*
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
    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    static Node addTwoLists(Node num1, Node num2) {
        while(num1 != null && num1.data == 0) {
            num1 = num1.next;
        }
        while(num2 != null && num2.data == 0) {
            num2 = num2.next;
        }

        if(num1 == null && num2 == null) {
            return new Node(0);
        }
        if(num1 == null) {
            return num2;
        }
        if(num2 == null) {
            return num1;
        }

        Node l1 = reverseList(num1);
        Node l2 = reverseList(num2);

        Node curr = null;
        int carry = 0;

        while(l1 != null || l2 != null || carry > 0) {
            int v1 = (l1 != null) ? l1.data : 0;
            int v2 = (l2 != null) ? l2.data : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            Node tmp = new Node(sum % 10);
            tmp.next = curr;
            curr = tmp;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        while(curr != null && curr.data == 0 && curr.next != null) {
            curr = curr.next;
        }

        return curr;
    }
}