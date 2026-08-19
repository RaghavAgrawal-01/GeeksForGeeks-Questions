class Solution {
    public int countStrings(int n, int k) {
        int MOD = 1000000007;

        int[][][] dp = new int[n + 1][k + 1][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for(int i = 2; i <= n; i++) 
        {
            for(int j = 0; j <= k; j++)
            {
                // ending with 0
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                // ending with 1 from previous 0
                dp[i][j][1] = (dp[i][j][1] + dp[i-1][j][0]) % MOD;
                // ending with 1 from previous 1 (creates new pair)
                if(j > 0) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i-1][j-1][1]) % MOD;
                }
            }
        }
        return (dp[n][k][0] + dp[n][k][1]) % MOD;
    }
}