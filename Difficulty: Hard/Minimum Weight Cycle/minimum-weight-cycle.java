import java.util.*;

class Solution {
    public int findMinCycle(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int V = adj.size();
        int minCycle = Integer.MAX_VALUE;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        for(int u = 0; u < V; u++){
            for(ArrayList<Integer> edge : adj.get(u)){
                int v = edge.get(0);
                int w = edge.get(1);
                graph.get(u).add(new int[]{v, w});
            }
        }

        for(int i = 0; i < V; i++){
            for(int[] neighbor : graph.get(i)){
                int target = neighbor[0];
                int weight = neighbor[1];

                int dist = dijkstra(V, graph, i, target, weight);
                if(dist != -1){
                    minCycle = Math.min(minCycle, dist + weight);
                }
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }

    private int dijkstra(int V, List<List<int[]>> adj, int src, int dest, int excludeWeight){
        int[] dist = new int[V];
        Arrays.fill(dist, 1000000000);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(u == dest) return d;
            if(d > dist[u]) continue;

            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];

                if(u == src && v == dest && w == excludeWeight){
                    continue;
                }

                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        return -1;
    }
}