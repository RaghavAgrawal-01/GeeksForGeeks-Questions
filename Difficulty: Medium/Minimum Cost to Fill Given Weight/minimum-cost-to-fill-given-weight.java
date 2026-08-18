class Solution {
    public int minimumCost(int[] cost, int w) {
        // code here
        int INF = (int) 1e9;
        int[] dp = new int[w + 1];
        for(int i = 1; i <= w; i++)
        {
            dp[i] = INF;
        }
        dp[0] = 0;
        for(int i = 1; i <= w; i++)
        {
            for(int j = 0; j < cost.length; j++)
            {
                int wt = j + 1;
                if(cost[j] != -1 && wt <= i) {
                    dp[i] = Math.min(dp[i], dp[i - wt] + cost[j]);
                }
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}