class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(V <= 0) return ans;
        if(V == 1) {
            ans.add(0);
            return ans;
        }
        if(V == 2) {
            ans.add(0);
            ans.add(1);
            return ans;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int[] e : edges) {
            indegree[e[0]]++;
            indegree[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 1) {
                q.offer(i);
            }
        }

        int remainingNodes = V;
        while(remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            while(size-- > 0) {
                int u = q.poll();
                for(int it : adj.get(u)) {
                    indegree[it]--;
                    if(indegree[it] == 1) {
                        q.offer(it);
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}