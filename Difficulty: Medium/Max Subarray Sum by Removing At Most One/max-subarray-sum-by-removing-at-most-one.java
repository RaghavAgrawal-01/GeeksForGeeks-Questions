class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            int prevNoDelete = noDelete;

            noDelete = Math.max(arr[i], noDelete + arr[i]);

            if (oneDelete == Integer.MIN_VALUE)
                oneDelete = prevNoDelete;
            else
                oneDelete = Math.max(oneDelete + arr[i], prevNoDelete);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}