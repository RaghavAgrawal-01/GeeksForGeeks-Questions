class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // by def its min
        for(int i=0;i <n; i++){
            for(int j=0; j<m; j++){
                pq.add(mat[i][j]);
                
                if(pq.size()>k)
                    pq.poll();
            }
        }
        return pq.peek();
    }
}
