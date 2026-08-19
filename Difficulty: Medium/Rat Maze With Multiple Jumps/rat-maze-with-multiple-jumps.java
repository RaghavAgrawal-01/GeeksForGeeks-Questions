import java.util.*;

class Solution {

    // Recursive function to find the shortest path
    boolean solve(int i, int j, int[][] mat, ArrayList<ArrayList<Integer>> ans,
                  int[][] dp) {
        int n = mat.length;

        // Base case: reached the destination
        if (i == n - 1 && j == n - 1) {
            ans.get(i).set(j, 1);
            return true;
        }

        // Check if current cell is blocked
        if (mat[i][j] == 0) return false;

        // Check if already visited this cell
        if (dp[i][j] != -1) return dp[i][j] == 1;

        ans.get(i).set(j, 1);
        int jump = mat[i][j];

        // Try jumping in all possible directions
        for (int step = 1; step <= jump; step++) {
            if (j + step < n && solve(i, j + step, mat, ans, dp)) {
                dp[i][j] = 1;
                return true;
            }
            if (i + step < n && solve(i + step, j, mat, ans, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }

        // Mark current cell as unreachable
        ans.get(i).set(j, 0);
        dp[i][j] = 0;
        return false;
    }

    // Main function to find the shortest path in the matrix
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

        // Base cases for matrix of size 1
        if (n == 1) {
            ans.get(0).set(0, 1);
            return ans;
        }

        // Check if starting cell is blocked
        if (mat[0][0] == 0) {
            ans.clear();
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // If no path found, return -1
        if (!solve(0, 0, mat, ans, dp)) {
            ans.clear();
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        return ans;
    }
}