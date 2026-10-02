// class Solution {
//     public int minCost(int[] height) {
//         int N = height.length;
        
//         // Handle edge case where there's only one stair
//         if (N == 1) return 0;

//         // dp[i] will store the minimum cost to reach the i-th stair
//         int[] dp = new int[N];
        
//         // Base cases
//         dp[0] = 0;  // No cost to start at the first stair
//         dp[1] = Math.abs(height[1] - height[0]);  // Cost to jump from stair 0 to stair 1
        
//         // Fill dp array for subsequent stairs
//         for (int i = 2; i < N; i++) {
//             int jump1 = dp[i - 1] + Math.abs(height[i] - height[i - 1]);  // Jump from i-1 to i
//             int jump2 = dp[i - 2] + Math.abs(height[i] - height[i - 2]);  // Jump from i-2 to i
//             dp[i] = Math.min(jump1, jump2);  // Take the minimum of the two possible jumps
//         }
        
//         // The result will be the minimum cost to reach the last stair
//         return dp[N - 1];
//     }
// }









class Solution {
    // Recursive helper function
    private int helper(int i, int N, int[] height, int[] memo) {
        // If we have reached the last stair, no more cost
        if (i == N - 1) {
            return 0;
        }
        
        // If we've already computed the cost for this stair, return it
        if (memo[i] != -1) {
            return memo[i];
        }
        
        // Cost to jump to the next stair (i+1) or the stair after (i+2)
        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;
        
        // Jump to i + 1, if within bounds
        if (i + 1 < N) {
            cost1 = Math.abs(height[i] - height[i + 1]) + helper(i + 1, N, height, memo);
        }
        
        // Jump to i + 2, if within bounds
        if (i + 2 < N) {
            cost2 = Math.abs(height[i] - height[i + 2]) + helper(i + 2, N, height, memo);
        }
        
        // Store the minimum cost and return it
        memo[i] = Math.min(cost1, cost2);
        return memo[i];
    }
    
    // Function to compute the minimum cost to reach the last stair
    public int minCost(int[] height) {
        int N = height.length;
        
        // Memoization array to store the result for each stair
        int[] memo = new int[N];
        
        // Initialize memo array with -1 (indicating not computed yet)
        for (int i = 0; i < N; i++) {
            memo[i] = -1;
        }
        
        // Start recursion from the first stair (index 0)
        return helper(0, N, height, memo);
    }
}
