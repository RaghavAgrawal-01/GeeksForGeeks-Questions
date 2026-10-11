/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head==null || head.next==null || k==1)
        {
            return head;
        }
        Node curr=head;
        int count=1;
        while(curr.next !=null && count <k)
        {
            curr = curr.next;
            count++;
        }
        Node re=null;
        if(count==k)
        {
            re=reverseKGroup(curr.next, k);
        }
        curr.next=null;
        Node rev=reverse(head);
        head.next=re;
        return rev;
        
    }
    public static Node reverse(Node head)
    {
        Node currNode = head;
        Node prevNode = null;
        while(currNode !=null)
        {
            Node nextNode= currNode.next;
            currNode.next=prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}