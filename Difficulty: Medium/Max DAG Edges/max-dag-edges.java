class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
        long maxEdges = (long) V * (V - 1) / 2;
        return (int) (maxEdges - edges.length);
    }
}