class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;

        for(int b = 0; b < 32; b++) {
            long count = 0;
            for(int val : arr) {
                if((val & (1 << b)) != 0) {
                    count++;
                }
            }
            long pairs = (count * (count - 1)) / 2;
            ans += pairs * (1L << b);
        }

        return ans;
    }
}