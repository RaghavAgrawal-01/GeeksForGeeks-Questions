class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int n = arr.length;
        int[] maxEnd = new int[n];
        maxEnd[n - 1] = arr[n - 1];
        int curr = arr[n - 1];
        for(int i = n - 2; i >= 0; i--)
        {
            curr = Math.max(arr[i], curr + arr[i]);
            maxEnd[i] = curr;
        }
        int sum = 0;
        for(int i = 0; i < k; i++) 
        {
            sum += arr[i];
        }
        int maxSize = sum;
        if(k < n)
        {
            maxSize = Math.max(maxSize, sum + maxEnd[k]);
        }
        
        for(int i = k; i < n; i++) 
        {
            sum = sum + arr[i] - arr[i - k];
            maxSize = Math.max(maxSize, sum);
            if(i + 1 < n) {
                maxSize = Math.max(maxSize, sum + maxEnd[i + 1]);
            }
        }
        return maxSize;
    }
}