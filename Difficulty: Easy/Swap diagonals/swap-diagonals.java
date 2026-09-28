class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int l = 0, r = mat.length - 1;
        for(int[] row : mat)
        {
            // swap  l && r
            int t = row[l]; row[l] = row[r]; row[r] = t;
            l++; r--;
        }
    }
}