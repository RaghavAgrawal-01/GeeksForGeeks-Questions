class Solution {
    int countWays(int n, int k) {
        long mod = 1000000007;
        if (n == 1) return k;
        long same = 0;
        long diff = k;
        for(int i = 2; i <= n; i++)
        {
            long prevSame = same;
            long prevDiff = diff;
            same = prevDiff;
            diff = (prevSame + prevDiff) * (k - 1) % mod;
        }
        return (int)((same + diff) % mod);
    }
}