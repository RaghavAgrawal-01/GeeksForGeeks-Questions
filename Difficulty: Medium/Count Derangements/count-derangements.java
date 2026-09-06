class Solution {
    public int derangeCount(int n) {
        // code here
        int N = 1 << n;
        int[][] dp = new int[n + 1][N];
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j < N; j++)
            {
                dp[i][j] = -1;
            }
        }
        return f(0, 0, n, dp);
    }

    private int f(int i, int mask, int n, int[][] dp) {
        if(i == n) return 1;
        if(dp[i][mask] != -1) return dp[i][mask];
        int ans = 0;
        for(int j = 0; j < n; j++) {
            if((mask & (1 << j)) != 0) continue;
            if(j == i) continue;
            ans += f(i + 1, mask | (1 << j), n, dp);
        }
        return dp[i][mask] = ans;
        
    }
};