class Solution {
    int[][][] dp;
    public int countWithout(int n, int d) {
        // code here
        if(n <= 0) 
        {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();
        dp = new int[len][2][2];
        for(int i = 0; i < len; i++) 
        {
            for(int j = 0; j < 2; j++) 
            {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 1, 0, s, d);
    }

    private int solve(int idx, int tight, int leadingZero, String s, int d) {
        if(idx == s.length()) 
        {
           return leadingZero == 1 ? 1 : 0;
        }
        if(dp[idx][tight][leadingZero] != -1)
        {
            return dp[idx][tight][leadingZero];
        }
        int limit = tight == 1 ? (s.charAt(idx) - '0') : 9;
        int ans = 0;
        for(int dig = 0; dig <= limit; dig++) 
        {
            if(dig == d && (leadingZero == 1 || d != 0)) 
            {
                continue;
            }
            int newTight = (tight == 1 && dig == limit) ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 || dig > 0) ? 1 : 0;
            ans += solve(idx + 1, newTight, newLeadingZero, s, d);
        }
        return dp[idx][tight][leadingZero] = ans;
    }
}