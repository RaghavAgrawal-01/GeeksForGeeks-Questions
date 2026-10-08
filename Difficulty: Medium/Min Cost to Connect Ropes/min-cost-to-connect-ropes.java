import java.util.PriorityQueue;

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public static int minCost(int[] arr) {
        // If there's only one rope, the cost is 0.
        if (arr.length == 1) return 0;
        
        // Priority queue (min heap) to always get the smallest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for (int num : arr) {
            pq.add(num); // Add each element from arr into the priority queue
        }

        int sum = 0;
        
        // Combine ropes until only one is left
        while (pq.size() > 1) {
            int a = pq.poll();  // Get the smallest element
            int b = pq.poll();  // Get the second smallest element

            sum += (a + b);  // Add the cost of combining these two ropes
            pq.add(a + b);   // Add the new combined rope back to the priority queue
        }
        
        return sum;
    }

    public static void main(String[] args) {
        // Example test case
        int[] a = {4, 3, 2, 6}; 
        Solution ob = new Solution();
        System.out.println(ob.minCost(a));  // Output the result
    }
}
