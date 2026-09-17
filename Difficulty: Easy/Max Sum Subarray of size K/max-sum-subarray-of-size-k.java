class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int max = 0, sum=0;
        for(int i=0; i<arr.length; i++)
        {
            sum+=arr[i];
            if(i<k-1) continue;
            max = Math.max(max, sum);
            sum-=arr[i-k+1];
        }
        return max;
    }
}
