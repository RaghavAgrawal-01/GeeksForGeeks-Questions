class Solution {
    public int validGroups(String s) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for(int i = 0; i < n; i++)
        {
            prefix[i + 1] = prefix[i] + (s.charAt(i) - '0');
        }
        int[][] dp = new int[n][901];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, s, prefix, dp);
    }

    private int solve(int idx, int prevSum, String s, int[] prefix, int[][] dp) {
        int n = s.length();
        if(idx == n) return 1;

        if(dp[idx][prevSum] != -1)
        {
            return dp[idx][prevSum];
        }
        int ans = 0;
        for(int j = idx; j < n; j++)
        {
            int currSum = prefix[j + 1] - prefix[idx];
            if(currSum >= prevSum)
            {
                ans += solve(j + 1, currSum, s, prefix, dp);
            }
        }
        return dp[idx][prevSum] = ans;
    }
}