class Solution {
    int n, m;
    int[][][] dp;
    public int solve(int i, int j1, int j2, int[][] grid){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;
        }
        if(i == n) {
            return 0;
        }
        if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int ans = 0;
        for(int d1 = -1; d1 <= 1; d1++){
            for(int d2 = -1; d2 <= 1; d2++){
                int val = 0;
                if(j1 == j2) {
                    val = grid[i][j1];
                }
                else {
                    val = grid[i][j1] + grid[i][j2];
                }
                val += solve(i + 1, j1 + d1, j2 + d2, grid);
                ans = Math.max(ans, val);
            }
        }
        return dp[i][j1][j2] = ans;
    }
    public int maxChocolate(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        for(int i = 0; i < n; i++) {
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }
        return solve(0, 0, m - 1, grid);
    }
}