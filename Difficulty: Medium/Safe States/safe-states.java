class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Create adjacency list from the edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        // Reverse the graph
        List<List<Integer>> revadj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            revadj.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++) {
            for(int nei : adj.get(i)) {
                revadj.get(nei).add(i);
            }
        }

        // Perform topological sorting on the reversed graph using Kahn's algorithm
        ArrayList<Integer> result = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        // Calculate the indegree for the reversed graph
        for (int i = 0; i < V; i++) {
            for (int nei : revadj.get(i)) {
                indegree[nei]++;
            }
        }

        // Add nodes with zero indegree to the queue
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        // Process the nodes in the queue
        while(!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for(int neighbor : revadj.get(node)) {
                if(--indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        // Sort the result in ascending order
        Collections.sort(result);
        return result; // Return ArrayList<Integer> directly
    }
}