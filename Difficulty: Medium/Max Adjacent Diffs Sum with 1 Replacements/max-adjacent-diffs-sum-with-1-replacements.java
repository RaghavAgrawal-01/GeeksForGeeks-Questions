class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if(n <= 1) 
        {
            return 0;
        }

        int prevOriginal = 0;
        int prevOne = 0;

        for(int i = 1; i < n; i++) 
        {
            int currOriginal = Math.max(
                prevOriginal + Math.abs(arr[i] - arr[i - 1]),
                prevOne + Math.abs(arr[i] - 1)
            );

            int currOne = Math.max(
                prevOriginal + Math.abs(1 - arr[i - 1]),
                prevOne + Math.abs(1 - 1)
            );

            prevOriginal = currOriginal;
            prevOne = currOne;
        }

        return Math.max(prevOriginal, prevOne);
    }
}