class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] pre : prerequisites)
        {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for(int neighbor : graph.get(curr))
            {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                {
                    queue.offer(neighbor);
                }
            }
        }
        return count == n;
    }
}