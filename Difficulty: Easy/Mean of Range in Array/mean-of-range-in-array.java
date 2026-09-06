class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int[] q : queries)
        {
            int l = q[0];
            int r = q[1];
            long sum;
            if(l == 0) {
                sum = prefix[r];
            }
            else {
                sum = prefix[r] - prefix[l - 1];
            }
            int len = r - l + 1;
            result.add((int)(sum / len));
        }
       
        return result;
    }
}