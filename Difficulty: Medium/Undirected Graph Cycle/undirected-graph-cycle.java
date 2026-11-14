class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] vis = new boolean[v];

        for(int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkCycle(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (checkCycle(neighbor, node, adj, vis)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    
}