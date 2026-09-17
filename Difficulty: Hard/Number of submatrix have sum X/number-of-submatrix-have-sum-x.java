class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][] pre = new int[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                pre[i][j] = mat[i][j];
                if(i>0){
                    pre[i][j] += pre[i-1][j];
                }
                if(j>0){
                    pre[i][j] += pre[i][j-1];
                }
                if(i>0 && j>0){
                    pre[i][j] -= pre[i-1][j-1];
                }
            }
        }
        int count=0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                for(int size = 1; size<=Math.min(n-i, m-j); size++)
                {
                    int r1 = i;
                    int c1 = j;
                    int r2 = i+size-1;
                    int c2 = j+size-1;
                    int sum = pre[r2][c2];
                    if(r1>0){
                        sum -= pre[r1-1][c2];
                    }
                    if(c1>0){
                        sum -= pre[r2][c1-1];
                    }
                    if(r1>0 && c1>0){
                        sum += pre[r1-1][c1-1];
                    }
                    if(sum==x){
                        count++;
                    }
                }
            }
        }
        return count;
        
    }
}