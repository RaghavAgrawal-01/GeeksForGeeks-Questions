class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new int[]{v, 0});
            adj.get(v).add(new int[]{u, 1});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0;
        dq.offerFirst(src);
        while(!dq.isEmpty())
        {
            int u = dq.pollFirst();
            if(u == dst)
            {
                return dist[u];
            }
            for(int[] next : adj.get(u))
            {
                int v = next[0];
                int weight = next[1];
                if(dist[u] + weight < dist[v])
                {
                    dist[v] = dist[u] + weight;
                    if(weight == 0)
                    {
                        dq.offerFirst(v);
                    }
                    else{
                        dq.offerLast(v);
                    }
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}