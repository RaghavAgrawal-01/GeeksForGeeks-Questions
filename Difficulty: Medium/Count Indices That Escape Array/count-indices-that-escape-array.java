class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] vis = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(vis[i] == 0)
            {
                int curr = i;
                java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
                while(curr >= 0 && curr < n && vis[curr] == 0)
                {
                    vis[curr] = 1;
                    path.add(curr);
                    curr += arr[curr];
                }
                if(curr < 0 || curr >= n) {
                    for(int idx : path) {
                        vis[idx] = 2;
                    }
                }
                else if(vis[curr] == 2) {
                    for(int idx : path) {
                        vis[idx] = 2;
                    }
                }
                else{
                    for(int idx : path)
                    {
                        vis[idx] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(vis[i] == 2)
            {
                count++;
            }
        }
        return count;
    }
}