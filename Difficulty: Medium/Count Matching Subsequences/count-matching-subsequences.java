class Solution {
    static final int MOD = 1000000007;

    public int solve(int i, int j, String s1, String s2, int[][] dp) {
        // base cases
        if (j == s2.length()) return 1;
        if (i == s1.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        // recursive case
        if (s1.charAt(i) == s2.charAt(j)) {
            int take = solve(i + 1, j + 1, s1, s2, dp);
            int skip = solve(i + 1, j, s1, s2, dp);
            dp[i][j] = (take + skip) % MOD;
        } else {
            int skip = solve(i + 1, j, s1, s2, dp);
            dp[i][j] = skip % MOD;
        }

        return dp[i][j];
    }

    public int countWays(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];

        // initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s1, s2, dp);
    }
}