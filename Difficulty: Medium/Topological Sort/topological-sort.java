class Solution {
    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int[] inDegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);

            for (int neighbor : adj.get(u)) {
                if (--inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return res;
    }
}