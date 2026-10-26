class Solution {
    public int maxKPower(int n, int k) {
      Map<Integer, Integer> primeFactors = new HashMap<>();
        int num = k;
        for(int i = 2; i * i <= num; i++) {
            while(k % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if(k > 1) {
            primeFactors.put(k, 1);
        }
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int powerInK = entry.getValue();
            int count = 0;
            int tempN = n;
            while(tempN > 0) {
                count += tempN / prime;
                tempN /= prime;
            }
            result = Math.min(result, count / powerInK);
        }
        return result;
    }
}