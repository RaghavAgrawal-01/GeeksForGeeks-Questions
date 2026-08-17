class Solution {
    public int computeValue(int n) {
        int MOD = 1000000007;
        long[] fact = new long[2 * n + 1];
        fact[0] = 1;
        for(int i = 1; i <= 2 * n; i++)
        {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        long denom = (fact[n] * fact[n]) % MOD;
        long ans = (fact[2 * n] * power(denom, MOD - 2, MOD)) % MOD;
        return (int)ans;
    }

    long power(long a, long b, int mod) {
        long res = 1;
        while(b > 0)
        {
            if((b & 1) == 1){
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}