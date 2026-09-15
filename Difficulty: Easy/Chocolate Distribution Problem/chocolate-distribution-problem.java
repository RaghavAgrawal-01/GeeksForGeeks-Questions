// User function Template for Java

class Solution {
    public int findMinDiff(int[] arr, int m) {
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i + m <= arr.length; i++)
        {
            res = Math.min(res, arr[i + m - 1] - arr[i]);
        }
        return res;
    }
}