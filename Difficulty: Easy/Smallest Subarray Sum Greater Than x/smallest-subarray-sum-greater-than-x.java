class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        long sum = 0;
        int left = 0;
        for(int right = 0; right < n; right++)
        {
            sum += arr[right];
            while(sum > x)
            {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}