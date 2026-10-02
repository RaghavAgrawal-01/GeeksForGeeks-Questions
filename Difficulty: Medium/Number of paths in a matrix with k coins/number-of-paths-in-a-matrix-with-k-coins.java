class Solution {
    int n, m;
    int[][] mat;
    int[][][] dp;
    public int numberOfPath(int[][] mat, int k) {
        this.n = mat.length;
        this.m = mat[0].length;
        this.mat = mat;
        this.dp = new int[n][m][k + 1];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                for(int s = 0; s <= k; s++)
                {
                    dp[i][j][s] = -1;
                }
            }
        }
        return helper(0, 0, k);
    }
    private int helper(int i, int j, int remaining) {
        if(i >= n || j >= m || remaining < 0)
            return 0;
        if(i == n - 1 && j == m - 1)
            return (remaining == mat[i][j]) ? 1 : 0;
        if(dp[i][j][remaining] != -1)
            return dp[i][j][remaining];
        int right = helper(i, j + 1, remaining - mat[i][j]);
        int down = helper(i + 1, j, remaining - mat[i][j]);
        return dp[i][j][remaining] = right + down;
    }
}
