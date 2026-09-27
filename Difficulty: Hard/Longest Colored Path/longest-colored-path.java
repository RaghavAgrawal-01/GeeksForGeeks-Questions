import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) {
            g.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int[] c = new int[n];
        for(int i=0;i<n;i++) {
            c[i] = (s.charAt(i) == 'B') ? 1 : 0;
        }

        int[] par = new int[n];
        Arrays.fill(par, -1);
        List<Integer> order = new ArrayList<>();
        List<Integer> st = new ArrayList<>();

        st.add(0);
        par[0] = -2;

        while (!st.isEmpty()) {
            int u = st.remove(st.size() - 1);
            order.add(u);
            List<Integer> neighbors = g.get(u);
            for(int i=0;i<neighbors.size();i++) {
                int v = neighbors.get(i);
                if (v != par[u]) {
                    par[v] = u;
                    st.add(v);
                }
            }
        }

        int[] down = new int[n];
        int[] up = new int[n];
        Arrays.fill(down, 1);
        Arrays.fill(up, 1);

        int ans = 1;

        for(int i=n-1;i>=0;i--) {
            int u = order.get(i);
            int t1 = 0, t2 = 0;
            List<Integer> neighbors = g.get(u);
            for(int j=0;j<neighbors.size();j++) {
                int v = neighbors.get(j);
                if (par[v] == u && c[v] == c[u]) {
                    if (down[v] > t1) {
                        t2 = t1;
                        t1 = down[v];
                    } else if (down[v] > t2) {
                        t2 = down[v];
                    }
                }
            }
            down[u] = t1 + 1;
            ans = Math.max(ans, down[u]);
            if (t2 > 0) {
                ans = Math.max(ans, t1 + t2 + 1);
            }
        }

        for(int i=0;i<order.size();i++) {
            int u = order.get(i);
            int t1 = 0, t2 = 0, id = -1;
            List<Integer> neighbors = g.get(u);
            for(int j=0;j<neighbors.size();j++) {
                int v = neighbors.get(j);
                if (par[v] == u && c[v] == c[u]) {
                    if (down[v] > t1) {
                        t2 = t1;
                        t1 = down[v];
                        id = v;
                    } else if (down[v] > t2) {
                        t2 = down[v];
                    }
                }
            }
            for(int j=0;j<neighbors.size();j++) {
                int v = neighbors.get(j);
                if (par[v] == u) {
                    if (c[v] != c[u]) {
                        up[v] = 1;
                    } else {
                        up[v] = 1 + Math.max(up[u], 1 + (v == id ? t2 : t1));
                    }
                }
            }
        }

        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            if (c[u] != c[v]) {
                ans = Math.max(ans, Math.max(down[u], up[u]) + Math.max(down[v], up[v]));
            }
        }

        return ans;
    }
}