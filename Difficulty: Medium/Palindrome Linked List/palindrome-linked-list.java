/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        // code here
        if(head == null || head.next == null)
        {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow;
        while(curr != null)
        {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        while(secondHalf != null)
        {
            if(firstHalf.data != secondHalf.data)
            {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}