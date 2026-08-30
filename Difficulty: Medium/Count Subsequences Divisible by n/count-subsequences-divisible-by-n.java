class Solution {
    private static final int MOD = 1000000007;

    public int countSubsequences(String s, int n) {
        int[] dp = new int[n];

        for(int i = 0; i < s.length(); i++) 
        {
            int digit = s.charAt(i) - '0';
            int[] nextDp = new int[n];

            for(int r = 0; r < n; r++) 
            {
                nextDp[r] = dp[r];
            }

            nextDp[digit % n] = (nextDp[digit % n] + 1) % MOD;

            for(int r = 0; r < n; r++) 
            {
                if(dp[r] > 0) 
                {
                    int newRem = (r * 10 + digit) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[r]) % MOD;
                }
            }

            dp = nextDp;
        }

        return dp[0];
    }
}