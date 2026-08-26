class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist, 0);
        for(int i = 1; i <= V - 1; i++) 
        {
            for(int[] edge : edges) 
            {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) 
                {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) 
            {
                return true;
            }
        }
        return false;
    }
}