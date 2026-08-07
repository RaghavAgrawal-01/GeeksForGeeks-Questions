class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        // code here
        return (int) (cntSubarysWthSumAtMost(arr, r) - cntSubarysWthSumAtMost(arr, l - 1));
    }
    private long cntSubarysWthSumAtMost(int[] arr, long x) {
        if(x < 0) return 0;
        long count = 0;
        long curSum = 0;
        int left = 0;
        for(int right = 0; right < arr.length; right++)
        {
            curSum += arr[right];
            while(curSum > x && left <= right)
            {
                curSum -= arr[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}