class Solution {
    class DisjointSet {
        int[] parent, rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++)
            {
                parent[i] = i;
            }
        }
        public int find(int i)
        {
            if(parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public boolean union(int u, int v) {
            int rootU = find(u), rootV = find(v);
            if(rootU != rootV) {
                if(rank[rootU] < rank[rootV])
                {
                    parent[rootU] = rootV;
                }
                else if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                }
                else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
                return true;
            }
            return false;
        }
    }
    int minEdgesReq(int n, int[][] edges) {
        // code here
        if(edges.length < n - 1) return -1;
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for(int[] edge : edges)
        {
            if(!ds.union(edge[0], edge[1]))
            {
                extraEdges++;
            }
        }
        int components = 0;
        for(int i = 0; i < n; i++) 
        {
            if(ds.find(i) == i) {
                components++;
            }
        }

        int requiredEdges = components - 1;
        return (extraEdges >= requiredEdges) ? requiredEdges : -1;
    }
}