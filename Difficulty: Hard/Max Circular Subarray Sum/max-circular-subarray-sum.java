class Solution {
    public int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int currMax = 0, maxSum = arr[0];
        int currMin = 0, minSum = arr[0];
        
        for(int x : arr) {
            currMax = Math.max(x, currMax + x);
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(x, currMin + x);
            minSum = Math.min(minSum, currMin);
            
            totalSum += x;
        }
        
        if(maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}