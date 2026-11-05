/* Linked List Node Structure
class Node {
    Node next;
    int data;
    public Node(int data) {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    public Node primeList(Node head) {
        int maxVal = 0;
        Node curr = head;
        while(curr != null) {
            maxVal = Math.max(curr.data, maxVal);
            curr = curr.next;
        }
        
        int limit = Math.max(maxVal + 200, 10005);
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int p = 2; p * p <= limit; p++) {
            if(isPrime[p]) {
                for(int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        curr = head;
        while(curr != null) {
            int val = curr.data;
            if(isPrime[val]) {
                curr = curr.next;
                continue;
            }
            
            int left = val - 1;
            int right = val + 1;
            int nearest = -1;
            
            while(true) {
                if(left >= 2 && isPrime[left]) {
                    nearest = left;
                    break;
                }
                if(right <= limit && isPrime[right]) {
                    nearest = right;
                    break;
                }
                if(left >= 2) {
                    left--;
                }
                right++;
            }
            
            curr.data = nearest;
            curr = curr.next;
        }
        
        return head;
    }
}