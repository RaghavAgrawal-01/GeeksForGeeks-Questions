class Solution {

    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        final int MOD = 1_000_000_007;

        long[][] ways = new long[n][n];
        int[][] max = new int[n][n];

        // -1 means unreachable
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(max[i], -1);
        }

        ways[0][0] = 1;
        max[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                // Come from top: top cell must allow DOWN
                if (i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3)) {
                    ways[i][j] = (ways[i][j] + ways[i - 1][j]) % MOD;

                    if (max[i - 1][j] != -1) {
                        max[i][j] = Math.max(
                            max[i][j],
                            max[i - 1][j] + grid[i][j]
                        );
                    }
                }

                // Come from left: left cell must allow RIGHT
                if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 3)) {
                    ways[i][j] = (ways[i][j] + ways[i][j - 1]) % MOD;

                    if (max[i][j - 1] != -1) {
                        max[i][j] = Math.max(
                            max[i][j],
                            max[i][j - 1] + grid[i][j]
                        );
                    }
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int) ways[n - 1][n - 1]);

        // No valid path => maximum Adventure is 0
        ans.add(max[n - 1][n - 1] == -1 ? 0 : max[n - 1][n - 1]);

        return ans;
    }
}