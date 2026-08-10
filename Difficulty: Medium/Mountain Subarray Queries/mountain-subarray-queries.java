class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int lastInc = 0;
        left[0] = 0;
        for(int i = 1; i < n; i++) 
        {
            if(arr[i] > arr[i - 1])
            {
                lastInc = i;
            }
            left[i] = lastInc;
        }
        int lastDec = n - 1;
        right[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1]) {
                lastDec = i;
            }
            right[i] = lastDec;
        }

        ArrayList<Boolean> result = new ArrayList<>();
        for(int[] q : queries)
        {
            int l = q[0];
            int r = q[1];
            result.add(right[l] >= left[r]);
        }
        return result;
    }
}