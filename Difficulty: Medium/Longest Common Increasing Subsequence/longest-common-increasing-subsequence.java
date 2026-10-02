class Solution {
    public int LCIS(int[] a, int[] b) {
        // code here
        int n = a.length, m = b.length;
        int[] dp = new int[m];
        
        for (int i = 0; i < n; i++) {
            int best = 0;
            
            for (int j = 0; j < m; j++) {

                if (b[j] < a[i]) {
                    best = Math.max(best, dp[j]);
                }
                else if (a[i] == b[j]) {
                    dp[j] = Math.max(dp[j], best + 1);
                }
            }
        }

        int ans = 0;
        for (int x : dp) ans = Math.max(ans, x);
        return ans;
    }
}