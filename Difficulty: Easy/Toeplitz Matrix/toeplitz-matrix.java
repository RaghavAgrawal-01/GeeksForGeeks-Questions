class Solution {
    public boolean isToeplitz(int[][] mat) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                int diff = i - j;
                if(map.containsKey(diff))
                {
                    if(!map.get(diff).equals(mat[i][j]))
                        return false;
                }
                else{
                    map.put(diff, mat[i][j]);
                }
            }
        }
        return true;
    }
}