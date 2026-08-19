class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int[][] dp = new int[n + 1][m + 1];

        // initialize
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 0; // only zeros inserted in b
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) 
            {
                // skip a[i-1]
                dp[i][j] = dp[i-1][j];
                // match a[i-1] with b[j-1]
                dp[i][j] = Math.max(
                    dp[i][j],
                    dp[i-1][j-1] + a[i-1] * b[j-1]
                );
            }
        }
        return dp[n][m];
    }
}