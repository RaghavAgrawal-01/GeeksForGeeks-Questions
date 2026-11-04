class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int result = 0;

        if(n % 2 == 1) {
            for(int i = 0; i < n; i += 2) {
                result ^= arr[i];
            }
        }

        return result;
    }
}