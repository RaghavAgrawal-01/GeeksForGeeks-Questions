class Solution {
    public long sumXOR(int[] arr) {
        // code here
        int n = arr.length;
        long total = 0;
        for(int bit = 0; bit < 20; bit++)
        {
            long count1 = 0;
            for(int num : arr)
            {
                if((num & (1 << bit)) != 0)
                {
                    count1++;
                }
            }
            long count0 = n - count1;
            total += count1 * count0 * (1L << bit);
        }
        return total;
    }
}