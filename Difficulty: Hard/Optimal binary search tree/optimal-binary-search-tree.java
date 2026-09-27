import java.util.*;

class Solution {
    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++) {
            dp[i][i] = freq[i];
        }

        for(int len=2;len<=n;len++) {
            for(int i=0;i<=n-len;i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                int sum = 0;
                for(int k=i;k<=j;k++) {
                    sum += freq[k];
                }

                for(int r=i;r<=j;r++) {
                    int cost = sum;
                    if(r > i) {
                        cost += dp[i][r - 1];
                    }
                    if(r < j) {
                        cost += dp[r + 1][j];
                    }
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}