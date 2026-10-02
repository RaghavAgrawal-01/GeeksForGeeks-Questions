// class Solution {
//     int[] dp = new int[46];  // Array to store the computed results for dynamic programming.
//     // Helper function to compute the number of ways recursively.
//     public int solve(int n) {
//         // Base case: if n is 0 or 1, return 1 (only one way).
//         if(n == 0 || n == 1)
//         {
//             return 1;
//         }
//         // If the result is already computed, return it.
//         if(dp[n] != -1)
//         {
//             return dp[n];
//         }
//         // Recursive case: calculate the number of ways for (n-1) and (n-2).
//         int ans = solve(n - 1) + solve(n - 2);
//         // Store the computed result in dp array.
//         dp[n] = ans;
//         return ans;
//     }
//     public int numberOfWays(int n) {
//         // Initialize dp array with -1 to indicate that no results have been computed.
//         for(int i = 0; i < dp.length; i++) {
//             dp[i] = -1;
//         }
//         // Call the recursive helper function to get the result.
//         return solve(n);
//     }
// }










class Solution {
    
    public int numberOfWays(int n) {
        // Create an array to store results of subproblems, initialized to -1
        int[] dp = new int[46];
        for(int i = 0; i < dp.length; i++)
        {
            dp[i] = -1;
        }
        // Base cases for dp
        if(n == 0 || n == 1)
        {
            return 1;
        }
        // Fill dp array using a bottom-up approach
        dp[0] = 1;  // Base case: 1 way to reach step 0
        dp[1] = 1;  // Base case: 1 way to reach step 1
        for(int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];  // Fibonacci relation
        }
        // Return the result for dp[n]
        return dp[n];
    }
}



