class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        if(u == v) {
            return true;
        }
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[u] = true;
        q.offer(u);
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == v) {
                return true;
            }
            for(int nxt : adj.get(curr)) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
        return false;
    }
}