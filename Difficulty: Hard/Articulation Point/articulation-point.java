import java.util.*;

class Solution {

    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(parent, -1);

        int time = 0;

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                time = dfsIterative(i, adj, visited, disc, low, parent, ap, time);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(ap[i]) res.add(i);
        }

        if(res.size() == 0) res.add(-1);
        return res;
    }

    private int dfsIterative(int start, ArrayList<ArrayList<Integer>> adj,boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, int time) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, -1, 0});
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int u = top[0], par = top[1], state = top[2];
            if(state == 0){
                if(visited[u]) continue;
                visited[u] = true;
                disc[u] = low[u] = time++;
                stack.push(new int[]{u, par, 1});
                for(int v : adj.get(u)){
                    if(!visited[v]){
                        parent[v] = u;
                        stack.push(new int[]{v, u, 0});
                    } else if(v != par){
                        low[u] = Math.min(low[u], disc[v]);
                    }
                }

            } else {
                int children = 0;

                for(int v : adj.get(u)){
                    if(parent[v] == u){
                        children++;
                        low[u] = Math.min(low[u], low[v]);

                        if(parent[u] == -1 && children > 1)
                            ap[u] = true;

                        if(parent[u] != -1 && low[v] >= disc[u])
                            ap[u] = true;
                    }
                }
            }
        }

        return time;
    }
}