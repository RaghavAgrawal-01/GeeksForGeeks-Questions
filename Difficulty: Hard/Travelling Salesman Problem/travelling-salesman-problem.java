class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int[][] dp = new int[1 << n][n];        
        for(int[] curr:dp) Arrays.fill(curr, -1);
        
        return solve(1, 0, cost, dp, n);
    }

    private int solve(int mask, int pos, int[][] cost, int[][] dp, int n) {
        if(mask == (1 << n) - 1)  return cost[pos][0];
        if(dp[mask][pos] != -1)  return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for(int city = 0; city < n; city++)
        {
            if((mask & (1 << city)) == 0)
            {
                int newCost = cost[pos][city] + solve(mask | (1 << city), city, cost, dp, n);
                ans = Math.min(ans, newCost);
            }
        }
        return dp[mask][pos] = ans;
    }
}