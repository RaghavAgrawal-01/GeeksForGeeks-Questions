class Solution {
    private static final int MOD = 1000000007;
    public int countSubsets(int[] arr) {
        // code here
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] primeMask = new int[31];

        for(int i = 2; i <= 30; i++) {
            int num = i, mask = 0;
            boolean isValid = true;
            for(int j = 0; j < primes.length; j++) {
                int p = primes[j];
                if(num % (p * p) == 0) {
                    isValid = false;
                    break;
                }
                if(num % p == 0) {
                    mask |= (1 << j);
                }
            }
            if(isValid) primeMask[i] = mask;
            else primeMask[i] = -1;
        }

        int[] freq = new int[31];
        for(int x : arr) freq[x]++;

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for(int i = 2; i <= 30; i++) {
            if(freq[i] == 0 || primeMask[i] == -1) continue;

            int mask = primeMask[i];
            long count = freq[i];

            for(int prev = (1 << 10) - 1; prev >= 0; prev--) {
                if((prev & mask) == 0 && dp[prev] > 0) {
                    dp[prev | mask] = (dp[prev | mask] + dp[prev] * count) % MOD;
                }
            }
        }

        long totalValidSubsets = 0;
        for(int mask = 1; mask < (1 << 10); mask++) {
            totalValidSubsets = (totalValidSubsets + dp[mask]) % MOD;
        }

        long onesPower = 1;
        for(int i = 0; i < freq[1]; i++) {
            onesPower = (onesPower * 2) % MOD;
        }

        return (int) ((totalValidSubsets * onesPower) % MOD);   
    }
}