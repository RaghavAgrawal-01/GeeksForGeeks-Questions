

/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {  // <-- Method name changed here
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int c = 1;
                while ((fast = fast.next) != slow) c++;
                return c;
            }
        }
        return 0;
    }
}
