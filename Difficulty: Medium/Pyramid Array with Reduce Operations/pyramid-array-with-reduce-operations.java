class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        long totalSum = 0;
        for(int x : arr)
        {
            totalSum += x;
        }
        left[0] = Math.min(arr[0], 1);
        for(int i = 1; i < n; i++)
        {
            left[i] = Math.min(arr[i], Math.min(left[i - 1] + 1, i + 1));
        }
        right[n - 1] = Math.min(arr[n - 1], 1);
        for(int i = n - 2; i >= 0; i--)
        {
            right[i] = Math.min(arr[i], Math.min(right[i + 1] + 1, n - i));
        }
        int maxX = 0;
        for(int i = 0; i < n; i++)
        {
            int h = Math.min(left[i], right[i]);
            maxX = Math.max(maxX, h);
        }
        long pyramidSum = (long) maxX * maxX;
        return (int) (totalSum - pyramidSum);
    }
}