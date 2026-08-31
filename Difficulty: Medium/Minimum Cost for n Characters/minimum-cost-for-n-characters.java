class Solution {
    public int minCost(int n, int i, int d, int c) {
        if(n <= 0) 
        {
            return 0;
        }
        long[] dp = new long[n + 1];
        dp[1] = i;
        for(int j = 2; j <= n; j++) 
        {
            if(j % 2 == 0) 
            {
                dp[j] = Math.min(dp[j - 1] + i, dp[j / 2] + c);
            } 
            else 
            {
                dp[j] = Math.min(dp[j - 1] + i, dp[(j + 1) / 2] + c + d);
            }
        }
        return (int) dp[n];
    }
}