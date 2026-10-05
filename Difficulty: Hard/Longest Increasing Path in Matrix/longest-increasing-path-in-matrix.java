class Solution {
    private int[][] dp;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private int dfs(int[][] matrix, int r, int c, int n, int m) {
        if(dp[r][c] != 0)
        {
            return dp[r][c];
        }

        int maxLength = 1;

        for(int i = 0; i < 4; i++)
        {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[r][c])
            {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, nr, nc, n, m));
            }
        }

        return dp[r][c] = maxLength;
    }

    public int longIncPath(int[][] matrix, int n, int m) {
        dp = new int[n][m];
        int maxPath = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, n, m));
            }
        }

        return maxPath;
    }
}