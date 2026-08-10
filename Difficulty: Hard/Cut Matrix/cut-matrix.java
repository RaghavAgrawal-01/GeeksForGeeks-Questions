class Solution {
    private static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pref = new int[n + 1][m + 1];
        
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j < m; j++) 
            {
                pref[i + 1][j + 1] = matrix[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        
        int[][][] dp = new int[n][m][k + 1];
        
        for(int r = 0; r < n; r++) 
        {
            for(int c = 0; c < m; c++) 
            {
                if(hasOne(pref, r, c, n - 1, m - 1)) 
                {
                    dp[r][c][1] = 1;
                }
            }
        }
        
        for(int p = 2; p <= k; p++) 
        {
            int[][] sumRow = new int[n + 1][m];
            int[][] sumCol = new int[n][m + 1];

            for(int r = n - 1; r >= 0; r--) 
            {
                for(int c = m - 1; c >= 0; c--) 
                {
                    sumRow[r][c] = (sumRow[r + 1][c] + dp[r][c][p - 1]) % MOD;
                    sumCol[r][c] = (sumCol[r][c + 1] + dp[r][c][p - 1]) % MOD;
                }
            }

            for(int r = n - 1; r >= 0; r--) 
            {
                for(int c = m - 1; c >= 0; c--) 
                {
                    long ways = 0;

                    for(int nr = r + 1; nr < n; nr++) 
                    {
                        if(hasOne(pref, r, c, nr - 1, m - 1)) 
                        {
                            ways = (ways + sumRow[nr][c]) % MOD;
                            break;
                        }
                    }

                    for(int nc = c + 1; nc < m; nc++) 
                    {
                        if(hasOne(pref, r, c, n - 1, nc - 1)) 
                        {
                            ways = (ways + sumCol[r][nc]) % MOD;
                            break;
                        }
                    }

                    dp[r][c][p] = (int) ways;
                }
            }
        }
        
        return dp[0][0][k];
    }

    private boolean hasOne(int[][] pref, int r1, int c1, int r2, int c2) {
        int ones = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];
        return ones > 0;
    }
}