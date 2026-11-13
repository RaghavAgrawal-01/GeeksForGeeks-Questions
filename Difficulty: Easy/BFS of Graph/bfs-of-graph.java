class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited= new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.add(0);
        while(!q.isEmpty())
        {
            int node = q.poll();
            list.add(node);
            for(int neighbor:adj.get(node))
            {
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.add(neighbor);
                }
            }
        }
        return list;
    }
}