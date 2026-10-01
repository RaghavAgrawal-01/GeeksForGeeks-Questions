class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        while(!q.isEmpty()) {
            int curr = q.poll();
            order.add(curr);
            for(int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if(order.size() != n) {
            return new ArrayList<>();
        }
        return order;
    }
}