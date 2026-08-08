class Solution {
    public int maximumSum(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int[][] pref = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i = k; i <= n; i++) 
        {
            for(int j = k; j <= n; j++) 
            {
                int total = pref[i][j] - pref[i - k][j] - pref[i][j - k] + pref[i - k][j - k];
                maxSum = Math.max(maxSum, total);
            }
        }
        
        return maxSum;
    }
}