class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0;i<dependencies.length;i++)
        {
            int u = dependencies[i][0];
            int v = dependencies[i][1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] completionTime = new int[n];
        for(int i=0;i<n;i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
                completionTime[i] = duration[i];
            }
        }
        int processedNodes = 0;
        int maxTime = 0;
        while(!queue.isEmpty())
        {
            int u = queue.poll();
            processedNodes++;
            maxTime = Math.max(maxTime, completionTime[u]);
            List<Integer> neighbors = adj.get(u);
            for(int i=0;i<neighbors.size();i++)
            {
                int v = neighbors.get(i);
                completionTime[v] = Math.max(completionTime[v], completionTime[u] + duration[v]);
                indegree[v]--;
                if(indegree[v] == 0)
                {
                    queue.add(v);
                }
            }
        }
        if(processedNodes != n)
        {
            return -1;
        }
        return maxTime;
    }
}