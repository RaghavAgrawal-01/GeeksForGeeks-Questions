import java.util.ArrayList;

class Solution {
    // Helper function to find the row index of the maximum element in a column
    public int findMax(int[][] mat, int col) {
        int maxi = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > maxi) {
                maxi = mat[i][col];
                row = i;
            }
        }
        return row;
    }

    // Main function to find the peak element's coordinates
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length; // number of rows
        int m = mat[0].length; // number of columns
        
        // Special case for a single column matrix
        if (m == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(findMax(mat, 0));
            result.add(0);
            return result;
        }
        
        // Special case for a single row matrix
        if (n == 1) {
            int maxCol = 0;
            for (int i = 0; i < m; i++) {
                if (mat[0][i] > mat[0][maxCol]) {
                    maxCol = i;
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(maxCol);
            return result;
        }
        
        int left = 0;
        int right = m - 1;
        
        // Binary search on columns
        while (left <= right) {
            int mid = (left + right) / 2;
            int maxRow = findMax(mat, mid);
            int leftel = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
            int rightel = (mid + 1 < m) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;
            
            if (mat[maxRow][mid] >= leftel && mat[maxRow][mid] >= rightel) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(maxRow);
                result.add(mid);
                return result;
            } else if (mat[maxRow][mid] < rightel) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Default return (this line should theoretically never be hit)
        return new ArrayList<>();
    }
}
