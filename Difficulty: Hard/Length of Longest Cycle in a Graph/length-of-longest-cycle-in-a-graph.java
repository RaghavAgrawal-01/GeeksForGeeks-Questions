class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] out = new int[V];
        Arrays.fill(out, -1);
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            out[u] = v;
        }
        int[] visited = new int[V];
        int ans = -1;
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 1) continue;
            Map<Integer, Integer> stepMap = new HashMap<>();
            int node = i;
            int step = 0;
            while(node != -1 && visited[node] == 0)
            {
                visited[node] = 1;
                stepMap.put(node, step++);
                node = out[node];
                if(node != -1 && stepMap.containsKey(node)) {
                    int cycleLength = step - stepMap.get(node);
                    ans = Math.max(ans, cycleLength);
                    break;
                }
            }
        }

        return ans;
    }
}