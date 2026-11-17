import java.util.ArrayList;
import java.util.Arrays;

class Solution{
    public ArrayList<Integer> bellmanFord(int V,int[][] edges,int src){
        int[] dist=new int[V];
        Arrays.fill(dist,100000000);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for(int[] edge:edges){
                int u=edge[0],v=edge[1],w=edge[2];
                if(dist[u]!=100000000&&dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for(int[] edge:edges){
            int u=edge[0],v=edge[1],w=edge[2];
            if(dist[u]!=100000000&&dist[u]+w<dist[v]){
                ArrayList<Integer> negativeCycle=new ArrayList<>();
                negativeCycle.add(-1);
                return negativeCycle;
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<V;i++){
            result.add(dist[i]);
        }
        return result;
    }
}