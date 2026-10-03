import java.util.*;

class Solution {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    private List<List<int[]>> adj;
    private int[][] up;
    private int[][] max1;
    private int[][] max2;
    private int[] depth;
    private int LOG;

    private void dfs(int u, int p, int weight, int d) {
        depth[u] = d;
        up[u][0] = p;
        max1[u][0] = weight;
        max2[u][0] = -1;

        for (int i = 1; i < LOG; i++) {
            int parent = up[u][i - 1];
            up[u][i] = up[parent][i - 1];

            int[] weights = {
                max1[u][i - 1], max2[u][i - 1],
                max1[parent][i - 1], max2[parent][i - 1]
            };

            int m1 = -1, m2 = -1;
            for (int w : weights) {
                if (w > m1) {
                    m2 = m1;
                    m1 = w;
                } else if (w < m1 && w > m2) {
                    m2 = w;
                }
            }
            max1[u][i] = m1;
            max2[u][i] = m2;
        }

        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int w = edge[1];
            if (v != p) {
                dfs(v, u, w, d + 1);
            }
        }
    }

    private int getMaxEdgeOnPath(int u, int v, int w) {
        int m1 = -1, m2 = -1;

        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                int[] weights = {m1, m2, max1[u][i], max2[u][i]};
                m1 = -1; m2 = -1;
                for (int weight : weights) {
                    if (weight > m1) {
                        m2 = m1; m1 = weight;
                    } else if (weight < m1 && weight > m2) {
                        m2 = weight;
                    }
                }
                u = up[u][i];
            }
        }

        if (u != v) {
            for (int i = LOG - 1; i >= 0; i--) {
                if (up[u][i] != up[v][i]) {
                    int[] weights = {m1, m2, max1[u][i], max2[u][i], max1[v][i], max2[v][i]};
                    m1 = -1; m2 = -1;
                    for (int weight : weights) {
                        if (weight > m1) {
                            m2 = m1; m1 = weight;
                        } else if (weight < m1 && weight > m2) {
                            m2 = weight;
                        }
                    }
                    u = up[u][i];
                    v = up[v][i];
                }
            }

            int[] weights = {m1, m2, max1[u][0], max1[v][0]};
            m1 = -1; m2 = -1;
            for (int weight : weights) {
                if (weight > m1) {
                    m2 = m1; m1 = weight;
                } else if (weight < m1 && weight > m2) {
                    m2 = weight;
                }
            }
        }

        if (m1 != w) return m1;
        return m2;
    }

    public int secondMST(int V, int[][] edges) {
        int E = edges.length;
        Edge[] edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            edgeList[i] = new Edge(edges[i][0], edges[i][1], edges[i][2]);
        }

        Arrays.sort(edgeList, (a, b) -> Integer.compare(a.w, b.w));

        DSU dsu = new DSU(V);
        int mstWeight = 0;
        int edgesCount = 0;
        boolean[] inMST = new boolean[E];

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            Edge e = edgeList[i];
            if (dsu.union(e.u, e.v)) {
                mstWeight += e.w;
                inMST[i] = true;
                edgesCount++;
                adj.get(e.u).add(new int[]{e.v, e.w});
                adj.get(e.v).add(new int[]{e.u, e.w});
            }
        }

        if (edgesCount != V - 1) return -1;

        LOG = 0;
        while ((1 << LOG) <= V) LOG++;

        up = new int[V][LOG];
        max1 = new int[V][LOG];
        max2 = new int[V][LOG];
        depth = new int[V];

        dfs(0, 0, 0, 0);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            if (!inMST[i]) {
                Edge e = edgeList[i];
                int maxWeight = getMaxEdgeOnPath(e.u, e.v, e.w);
                if (maxWeight != -1) {
                    minDiff = Math.min(minDiff, e.w - maxWeight);
                }
            }
        }

        return (minDiff == Integer.MAX_VALUE) ? -1 : mstWeight + minDiff;
    }
}