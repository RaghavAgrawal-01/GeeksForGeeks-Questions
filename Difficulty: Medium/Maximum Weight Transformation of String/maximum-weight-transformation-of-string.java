class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            int res = dp[i + 1] + 1;
            if(i + 1 < n) {
                int cost = (s.charAt(i) == s.charAt(i + 1)) ? 3 : 4;
                res = Math.max(res, cost + dp[i + 2]);
            }
            dp[i] = res;
        }

        return dp[0];
    }
}