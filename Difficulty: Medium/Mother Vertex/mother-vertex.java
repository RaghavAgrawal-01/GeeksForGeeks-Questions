class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges)
        {
            adj.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[V];
        int candidate = -1;
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                Stack<Integer> st = new Stack<>();
                st.push(i);
                while(!st.isEmpty())
                {
                    int node = st.pop();
                    if(!visited[node])
                    {
                        visited[node] = true;
                        for(int nei : adj.get(node))
                        {
                            if(!visited[nei]) {
                                st.push(nei);
                            }
                        }
                    }
                }
                candidate = i;
            }
        }
        
        visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        st.push(candidate);
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(!visited[node])
            {
                visited[node] = true;
                for(int nei : adj.get(node))
                {
                    if(!visited[nei])
                    {
                        st.push(nei);
                    }
                }
            }
        }
        for(boolean v : visited)
        {
            if(!v){
                return -1;
            }
        }
        for(int i = 0; i < candidate; i++)
        {
            visited = new boolean[V];
            st = new Stack<>();
            st.push(i);
            while(!st.isEmpty())
            {
                int node = st.pop();
                if(!visited[node])
                {
                    visited[node] = true;
                    for(int nei : adj.get(node))
                    {
                        if(!visited[nei])
                        {
                            st.push(nei);
                        }
                    }
                }
            }
            boolean ok = true;
            for(boolean v : visited)
            {
                if(!v)
                {
                    ok = false;
                    break;
                }
            }
            if(ok)
            {
                return i;
            }
        }
        return candidate;
    }
}