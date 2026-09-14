class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if(n <= 1) return 0;

        int[] firstBFS = bfs(1, n, adj);
        int startNode = firstBFS[0];

        int[] secondBFS = bfs(startNode, n, adj);
        int diameter = secondBFS[1];

        return (diameter + 1) / 2;
    }

    private int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[n + 1];
        java.util.Arrays.fill(dist, -1);
        java.util.Queue<Integer> q = new java.util.LinkedList<>();

        q.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxD = 0;

        while(!q.isEmpty())
        {
            int u = q.poll();

            if(dist[u] > maxD){
                maxD = dist[u];
                farthestNode = u;
            }

            for(int v : adj.get(u - 1))
            {
                if(dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        return new int[]{farthestNode, maxD};
    }
}