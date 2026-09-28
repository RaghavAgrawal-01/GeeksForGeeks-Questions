class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        ArrayList<ArrayList<Integer>> transposed = new ArrayList<>();
        for(int i = 0; i < cols; i++)
        {
            transposed.add(new ArrayList<Integer>());
        } 
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                transposed.get(j).add(mat[i][j]);
            }
        }
        return transposed;
    }
}
