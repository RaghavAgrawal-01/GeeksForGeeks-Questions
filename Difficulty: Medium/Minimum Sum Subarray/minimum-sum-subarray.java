class Solution {
    public int minSubarraySum(int[] arr) {
        int minVal = arr[0];
        int currentSum = arr[0];

        for(int i = 1; i < arr.length; i++) {
            currentSum = Math.min(arr[i], currentSum + arr[i]);
            minVal = Math.min(minVal, currentSum);
        }

        return minVal;
    }
}