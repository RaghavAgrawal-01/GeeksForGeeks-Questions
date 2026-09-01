class Solution {
    private static final int MOD = 1000000007;
    public int palindromicStrings(int n, int k) {
        long totalWays = 0;
        for(int len = 1; len <= n; len++) 
        {
            int pairs = len / 2;
            int middle = len % 2;
            if(pairs + middle > k) 
            {
                continue;
            }
            long ways = 1;
            int availableChars = k;
            for(int i = 0; i < pairs; i++) 
            {
                ways = (ways * availableChars) % MOD;
                availableChars--;
            }
            if(middle == 1) 
            {
                ways = (ways * availableChars) % MOD;
            }

            totalWays = (totalWays + ways) % MOD;
        }
        return (int) totalWays;
    }
}