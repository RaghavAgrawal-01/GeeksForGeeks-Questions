class Solution {

    static class Pair {
        int dist, node, used;
        Pair(int dist, int node, int used) {
            this.dist = dist;
            this.node = node;
            this.used = used;
        }
    }

    @SuppressWarnings("unchecked")    // remove GFG warning
    public int shortestPath(int V, int a, int b, int[][] edges) {

        List<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int x = e[0], y = e[1], w1 = e[2], w2 = e[3];
            adj[x].add(new int[]{y, w1, w2});
            adj[y].add(new int[]{x, w1, w2});
        }

        int[][] dist = new int[V][2];
        for (int i = 0; i < V; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));

        dist[a][0] = 0;
        pq.add(new Pair(0, a, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.dist != dist[cur.node][cur.used]) continue;

            for (int[] e : adj[cur.node]) {
                int nxt = e[0];
                int w1 = e[1];
                int w2 = e[2];

                if (cur.dist + w1 < dist[nxt][cur.used]) {
                    dist[nxt][cur.used] = cur.dist + w1;
                    pq.add(new Pair(dist[nxt][cur.used], nxt, cur.used));
                }

                if (cur.used == 0 && cur.dist + w2 < dist[nxt][1]) {
                    dist[nxt][1] = cur.dist + w2;
                    pq.add(new Pair(dist[nxt][1], nxt, 1));
                }
            }
        }

        int ans = Math.min(dist[b][0], dist[b][1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
