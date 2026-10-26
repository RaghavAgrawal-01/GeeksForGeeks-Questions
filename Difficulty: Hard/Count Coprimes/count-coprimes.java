class Solution {
    
    static final int MAX = 10000;
    static int[] mobius = new int[MAX + 1];

    static void computeMobius() {
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= MAX; j += i) {
                    mobius[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j <= MAX; j += i * i) {
                    mobius[j] = 0;
                }
            }
        }
    }

     int cntCoprime(int[] arr) {
        computeMobius(); 

        int[] freq = new int[MAX + 1];
        for (int num : arr) {
            freq[num]++;
        }

     
        int[] divisibleCount = new int[MAX + 1];
        for (int d = 1; d <= MAX; d++) {
            for (int j = d; j <= MAX; j += d) {
                divisibleCount[d] += freq[j];
            }
        }

       
        long total = 0;
        for (int d = 1; d <= MAX; d++) {
            int count = divisibleCount[d];
            long pairs = (long) count * (count - 1) / 2;
            total += mobius[d] * pairs;
        }

        return (int) total;
    }

}