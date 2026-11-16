class Solution{
    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj,int src){
        int v=adj.size();
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int[] d=new int[v];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[src]=0;
        q.offer(new int[]{0,src});
        while(!q.isEmpty()){
            int[] p=q.poll();
            int wt=p[0],u=p[1];
            if(wt>d[u]) continue;
            for(ArrayList<Integer> it:adj.get(u)){
                int neighbor=it.get(0);
                int edgeWeight=it.get(1);
                if(d[u]+edgeWeight<d[neighbor]){
                    d[neighbor]=d[u]+edgeWeight;
                    q.offer(new int[]{d[neighbor],neighbor});
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<v;i++){
            res.add(d[i]);
        }
        return res;
    }
}