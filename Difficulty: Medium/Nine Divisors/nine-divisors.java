class Solution {
    static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int p = 2; p * p <= n; p++) {
            if(isPrime[p]) {
                for(int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) primes.add(i);
        }
        return primes;
    }

    public static long countNumbers(long n) {
        List<Integer> primes = sieve((int)Math.sqrt(n) + 1);
        long count = 0;

        for(int p : primes) {
            long num = (long)p * p * p * p * p * p * p * p;
            if(num <= n) count++;
            else break;
        }

        int size = primes.size();
        for(int i = 0; i < size; i++) {
            long p2 = (long)primes.get(i) * primes.get(i);
            for(int j = i + 1; j < size; j++) {
                long q2 = (long)primes.get(j) * primes.get(j);
                if(p2 * q2 <= n) count++;
                else break;
            }
        }
        return count;
    }
}