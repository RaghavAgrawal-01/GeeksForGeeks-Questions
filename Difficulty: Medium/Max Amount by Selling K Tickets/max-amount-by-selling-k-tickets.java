class Solution {
    public int maxAmount(int[] arr, int k) {
        // code here
        int MOD = 1000000007;
        int maxVal = 0;
        for(int num : arr)
        {
            if(num > maxVal)
            {
                maxVal = num;
            }
        }
        long[] freq = new long[maxVal + 1];
        for(int num : arr)
        {
            freq[num]++;
        }
        long totalAmount = 0;
        for(int i = maxVal; i > 0 && k > 0; i--)
        {
            if(freq[i] > 0)
            {
                long take = Math.min((long) k, freq[i]);
                long earned = (take * i) % MOD;
                totalAmount = (totalAmount + earned) % MOD;
                k -= take;
                freq[i - 1] += freq[i];
            }
        }
        return (int) totalAmount;
    }
}