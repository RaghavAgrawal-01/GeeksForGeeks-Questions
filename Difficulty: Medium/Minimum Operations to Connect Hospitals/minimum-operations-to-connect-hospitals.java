class Solution {

    static class DSU {
        int[] parent, rank;
        
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int minConnect(int V, int[][] edges) {
        DSU dsu = new DSU(V);
        
        int extraEdges = 0;
        
        for (int[] e : edges) {
            if (!dsu.union(e[0], e[1])) {
                extraEdges++;
            }
        }
        
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (dsu.find(i) == i) components++;
        }
        
        int required = components - 1;
        
        if (extraEdges >= required) return required;
        return -1;
    }
}