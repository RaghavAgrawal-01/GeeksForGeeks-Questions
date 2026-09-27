import java.util.*;

class Solution {
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] brackets = new int[n][n];

        for(int len=2;len<n;len++) {
            for(int i=1;i<n-len+1;i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if(cost < dp[i][j]) {
                        dp[i][j] = cost;
                        brackets[i][j] = k;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        constructResult(1, n - 1, brackets, sb);
        return sb.toString();
    }

    private void constructResult(int i, int j, int[][] brackets, StringBuilder sb) {
        if(i == j) {
            sb.append((char) ('A' + i - 1));
            return;
        }
        sb.append('(');
        constructResult(i, brackets[i][j], brackets, sb);
        constructResult(brackets[i][j] + 1, j, brackets, sb);
        sb.append(')');
    }
}