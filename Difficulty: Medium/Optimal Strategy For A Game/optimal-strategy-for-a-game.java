class Solution {
    public int maximumAmount(int[] arr) {
        int n = arr.length;
        long[][] dp = new long[n][n];
        // Base cases: when the subarray length is 1 or 2
        for(int i = 0; i < n; ++i)
        {
            dp[i][i] = arr[i];
            if (i + 1 < n) dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }
        // Fill the dp table for larger subarrays
        for(int gap = 2; gap < n; ++gap)
        {
            for(int i = 0, j = gap; j < n; ++i, ++j)
            {
                long chooseLeft = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                long chooseRight = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                dp[i][j] = Math.max(chooseLeft, chooseRight);
            }
        }
        return (int) dp[0][n - 1]; // Return the maximum amount
    }
}
