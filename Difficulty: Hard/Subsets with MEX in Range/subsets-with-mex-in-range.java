class Solution {
    static final long MOD = 1_000_000_007L;

    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;
        int[] freq = new int[n + 1];

        for(int x : arr) {
            if(x <= n) {
                freq[x]++;
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for(int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long[] F = new long[n + 2];
        F[0] = pow2[n];

        long product = 1;
        int elementsUsed = 0;

        for(int k = 1; k <= n + 1; k++) {
            int x = k - 1;
            elementsUsed += freq[x];

            if(freq[x] == 0) {
                product = 0;
            } else {
                product = (product * (pow2[freq[x]] - 1 + MOD)) % MOD;
            }

            F[k] = (product * pow2[n - elementsUsed]) % MOD;
        }

        long ans = (F[l] - F[r + 1] + MOD) % MOD;
        return (int)ans;
    }
}
