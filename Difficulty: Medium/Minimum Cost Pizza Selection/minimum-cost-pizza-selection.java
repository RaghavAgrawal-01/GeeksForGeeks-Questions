class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
        int maxArea = x + l;
        int[] dp = new int[maxArea + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;

        for(int i = 0; i < maxArea; i++)
        {
            if(dp[i] != (int) 1e9)
            {
                if(i + s <= maxArea)
                {
                    dp[i + s] = Math.min(dp[i + s], dp[i] + cs);
                }
                if(i + m <= maxArea)
                {
                    dp[i + m] = Math.min(dp[i + m], dp[i] + cm);
                }
                if(i + l <= maxArea)
                {
                    dp[i + l] = Math.min(dp[i + l], dp[i] + cl);
                }
            }
        }

        int minCost = (int) 1e9;
        for(int i = x; i <= maxArea; i++)
        {
            minCost = Math.min(minCost, dp[i]);
        }

        return minCost;
    }
}