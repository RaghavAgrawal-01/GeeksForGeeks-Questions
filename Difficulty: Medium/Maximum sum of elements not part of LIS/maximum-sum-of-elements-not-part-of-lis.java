class Solution {
    public int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int totalSum = arr[0];
        int lisLength = 1;
        int currMin = Integer.MAX_VALUE;

        // Build the dp array for LIS lengths
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lisLength = Math.max(lisLength, dp[i]);
            totalSum += arr[i];
        }

        // Subtract elements that form LIS from total sum
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lisLength && arr[i] < currMin) {
                totalSum -= arr[i];
                currMin = arr[i];
                lisLength--;
            }
        }

        return totalSum;
        
    }
}