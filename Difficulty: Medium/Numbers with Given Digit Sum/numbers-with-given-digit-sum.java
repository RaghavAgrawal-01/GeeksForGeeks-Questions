class Solution {
    public int countWays(int n, int sum) {
        // code here
        if(sum < 1 || sum > 9 * n) 
        {
            return -1;
        }
        int[][] dp = new int[n + 1][sum + 1];
        for(int digit = 1; digit <= 9; digit++) 
        {
            if(digit <= sum) 
            {
                dp[1][digit] = 1;
            }
        }
        for(int len = 2; len <= n; len++) 
        {
            for(int s = 1; s <= sum; s++) 
            {
                for(int digit = 0; digit <= 9; digit++) 
                {
                    if(s >= digit) 
                    {
                        dp[len][s] += dp[len - 1][s - digit];
                    }
                }
            }
        }
        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
};