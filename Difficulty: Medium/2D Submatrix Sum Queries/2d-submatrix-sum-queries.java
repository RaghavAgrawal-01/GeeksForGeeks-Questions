class Solution {
    static ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        prefixSumMatrix(mat, n, m);
        for(int[] query : queries)
        {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            int total = mat[r2][c2];
            int leftSubMat = (c1 > 0) ? mat[r2][c1 - 1] : 0;
            int rightSubMat = (r1 > 0) ? mat[r1 - 1][c2] : 0;
            int overlap = (r1 > 0 && c1 > 0) ? mat[r1 - 1][c1 - 1] : 0;

            int sum = total - leftSubMat - rightSubMat + overlap;
            list.add(sum);
        }
        return list;
    }
    private static void prefixSumMatrix(int[][] mat, int n, int m) {
        // prefix-sum for rows
        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                mat[i][j] += mat[i][j - 1];
            }
        }
        // prefix-sum for columns
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                mat[i][j] += mat[i - 1][j];
            }
        }
    }

}
