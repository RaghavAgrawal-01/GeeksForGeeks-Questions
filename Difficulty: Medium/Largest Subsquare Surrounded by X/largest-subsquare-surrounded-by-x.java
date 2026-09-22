class Solution {
    public int largestSubsquare(char[][] mat) {
        int n = mat.length;
        int[][] left = new int[n][n];
        int[][] top = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 'X')
                {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                    top[i][j] = (i == 0 ? 0 : top[i - 1][j]) + 1;
                }
            }
        }
        int maxSide = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = n - 1; j >= 0; j--)
            {
                int small = Math.min(left[i][j], top[i][j]);
                while(small > maxSide)
                {
                    if(top[i][j - small + 1] >= small && left[i - small + 1][j] >= small) {
                        maxSide = small;
                        break;
                    }
                    small--;
                }
            }
        }
        return maxSide;
    }
}