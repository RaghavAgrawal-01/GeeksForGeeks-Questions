import java.util.*;

class Solution {
    // Adjacency list for the graph
    List<List<Integer>> adj;
    int ans = 0;

    // Helper function to perform DFS and calculate the diameter
    public int dfs(int node, int parent) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                pq.offer(dfs(neighbor, node));
            }
            if (pq.size() > 2) pq.poll();
        }

        int maxDist = 0, val = 0;
        while (!pq.isEmpty()) {
            int dist = pq.poll();
            maxDist += dist;
            val = Math.max(val, dist);
        }

        ans = Math.max(ans, maxDist);
        return val + 1;  // Return the longest distance + 1
    }

    public int diameter(int V, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Start DFS from node 0
        dfs(0, -1);
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution obj = new Solution();

        int V = 6;  // Number of vertices
        int[][] edges = {
            {0, 1},
            {0, 4},
            {1, 3},
            {1, 2},
            {2, 5}
        };

        // Call the diameter method
        int result = obj.diameter(V, edges);

        // Print the result
        System.out.println("The diameter of the tree is: " + result);
    }
}
