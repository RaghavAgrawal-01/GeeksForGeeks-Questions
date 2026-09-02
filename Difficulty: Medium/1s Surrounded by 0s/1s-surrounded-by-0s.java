class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    void dfs(int x, int y, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        vis[x][y] = true;
        for(int k = 0; k < 4; k++)
        {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m &&
                grid[nx][ny] == 1 && !vis[nx][ny]) {
                dfs(nx, ny, grid, vis);
            }
        }
    }

    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {

            if(grid[i][0] == 1 && !vis[i][0]) {
                dfs(i, 0, grid, vis);
            }

            if(grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(i, m - 1, grid, vis);
            }
        }

        for(int j = 0; j < m; j++) 
        {
            if(grid[0][j] == 1 && !vis[0][j]) {
                dfs(0, j, grid, vis);
            }

            if(grid[n - 1][j] == 1 && !vis[n - 1][j])
            {
                dfs(n - 1, j, grid, vis);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}