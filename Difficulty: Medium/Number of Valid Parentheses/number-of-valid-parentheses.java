class Solution {
    int solve(int open, int close, int n) {
        // invalid state
        if(open > n/2 || close > open)
        {
            return 0;
        }
        // valid sequence completed
        if(open + close == n)
        {
            return 1;
        }
        int ways = 0;
        // add '('
        ways += solve(open + 1, close, n);
        // add ')'
        ways += solve(open, close + 1, n);
        return ways;
    }

    int findWays(int n) {
        if (n % 2 != 0) return 0;
        return solve(0, 0, n);
    }
}
