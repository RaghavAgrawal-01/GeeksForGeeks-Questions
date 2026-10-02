import java.util.*;

class Solution {
    private int memo[][][];

    private int solve(int r1, int c1, int r2, int n, int[][] mat) {
        int c2 = r1 + c1 - r2;

        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n)
        {
            return Integer.MIN_VALUE;
        }

        if(mat[r1][c1] == -1 || mat[r2][c2] == -1)
        {
            return Integer.MIN_VALUE;
        }

        if(memo[r1][c1][r2] != -2)
        {
            return memo[r1][c1][r2];
        }

        if(r1 == n - 1 && c1 == n - 1)
        {
            return mat[r1][c1];
        }

        int chocolates = mat[r1][c1];
        if(r1 != r2 || c1 != c2)
        {
            chocolates += mat[r2][c2];
        }

        int best = Integer.MIN_VALUE;
        best = Math.max(best, solve(r1 + 1, c1, r2 + 1, n, mat));
        best = Math.max(best, solve(r1 + 1, c1, r2, n, mat));
        best = Math.max(best, solve(r1, c1 + 1, r2 + 1, n, mat));
        best = Math.max(best, solve(r1, c1 + 1, r2, n, mat));

        if(best == Integer.MIN_VALUE)
        {
            return memo[r1][c1][r2] = Integer.MIN_VALUE;
        }

        return memo[r1][c1][r2] = chocolates + best;
    }

    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        memo = new int[n][n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                Arrays.fill(memo[i][j], -2);
            }
        }

        int ans = solve(0, 0, 0, n, mat);
        return Math.max(0, ans);
    }
}