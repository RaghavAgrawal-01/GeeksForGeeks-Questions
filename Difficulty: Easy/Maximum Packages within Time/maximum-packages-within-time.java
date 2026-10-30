class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        if(totalTime > n) {
            totalTime = n;
        }

        int currentSum = 0;
        for(int i = 0; i < totalTime; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;
        for(int i = totalTime; i < n; i++) {
            currentSum += arr[i] - arr[i - totalTime];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}