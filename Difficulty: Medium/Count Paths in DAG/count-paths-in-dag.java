class Solution {
    static int dfs(int u, int dest, 
    ArrayList<ArrayList<Integer>> adj, int[] memo) {
        if(u == dest) return 1;
        if(memo[u] != -1) return memo[u];
        int count = 0;
        for(int v : adj.get(u)) {
            count += dfs(v, dest, adj, memo);
        }
        return memo[u] = count;
    }
    static int countPaths( int[][] edges, int V, int src, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        int[] memo = new int[V];
        Arrays.fill(memo, -1);
        return dfs(src, dest, adj, memo);
    }
}