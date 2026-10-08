class Solution {
    public void fill(char[][] grid) {
        // Edge case: if grid is empty, return
        if (grid == null || grid.length == 0 || grid[0].length == 0) return;
        
        int n = grid.length;       // number of rows
        int m = grid[0].length;    // number of columns
        
        // Start DFS from the first and last row
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') dfs(grid, i, 0, n, m);    // First column
            if (grid[i][m - 1] == 'O') dfs(grid, i, m - 1, n, m);  // Last column
        }

        // Start DFS from the first and last column
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O') dfs(grid, 0, j, n, m);    // First row
            if (grid[n - 1][j] == 'O') dfs(grid, n - 1, j, n, m);  // Last row
        }

        // Replace all remaining 'O' with 'X' (they are surrounded)
        // Replace all '-' with 'O' (they are not surrounded, safe O's)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';  // Replace surrounded O with X
                } else if (grid[i][j] == '-') {
                    grid[i][j] = 'O';  // Restore the safe O
                }
            }
        }
    }

    // DFS to mark 'O's connected to border
    private void dfs(char[][] grid, int x, int y, int n, int m) {
        // Check if out of bounds or not 'O'
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 'O') {
            return;
        }

        // Mark this cell as visited (temporarily mark it as '-')
        grid[x][y] = '-';
        
        // Visit all 4 possible directions
        dfs(grid, x + 1, y, n, m);  // Down
        dfs(grid, x - 1, y, n, m);  // Up
        dfs(grid, x, y + 1, n, m);  // Right
        dfs(grid, x, y - 1, n, m);  // Left
    }
}
