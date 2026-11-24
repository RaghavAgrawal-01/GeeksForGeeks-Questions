class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        Integer[][] dp = new Integer[wt.length][W + 1];
        return fun(W, val, wt, 0, dp);
    }
    int fun(int C, int val[], int wt[], int i, Integer[][] dp)
    {
        if(C==0) return 0;
        if(i==val.length) return 0;
        if(dp[i][C] != null) return dp[i][C];
        
        // include -> jb set m capacity hogi
        int inc=0, exc=0;
        if(wt[i]<= C){
            inc = val[i] + fun(C - wt[i], val, wt, i+1, dp);
        }
        
        // exclude cond. -> always hit
        exc = fun(C , val , wt, i+1, dp);
        return dp[i][C] =Math.max(inc, exc);
        
    }
}
