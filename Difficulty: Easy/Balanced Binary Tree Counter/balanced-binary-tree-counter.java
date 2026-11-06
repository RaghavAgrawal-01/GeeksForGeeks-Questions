class Solution {
    public int countBT(int h) {
        long mod = 1000000007;
        long[] dp = new long[h + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= h; i++)
        {
            long term1 = (dp[i - 1] * dp[i - 1]) % mod;
            long term2 = (2 * dp[i - 1] * dp[i - 2]) % mod;
            dp[i] = (term1 + term2) % mod;
        }

        return (int) dp[h];
    }
}