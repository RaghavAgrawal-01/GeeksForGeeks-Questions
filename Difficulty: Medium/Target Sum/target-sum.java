class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
        int sum = 0;
        for(int num : arr)
        {
            sum += num;
        }
        if(sum + target < 0 || (sum + target) % 2 != 0) {
            return 0;
        }
        int P = (sum + target) / 2;
        int[] dp = new int[P + 1];
        dp[0] = 1;
        for(int num : arr)
        {
            for(int i = P; i >= num; i--)
            {
                dp[i] += dp[i - num];
            }
        }
        return dp[P];
    }
}