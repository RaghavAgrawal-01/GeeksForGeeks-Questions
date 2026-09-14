class Solution {
    int maxSum(int[] arr) {
        // code here
        int n = arr.length;
        long sum = 0;
        long temp = 0;
        for(int i = 0; i < n; i++)
        {
            sum += arr[i];
            temp += (long) i * arr[i];
        }
        long ans = temp;
        for(int i = 1; i < n; i++)
        {
            temp = temp - sum + (long) arr[i - 1] * n;
            ans = Math.max(ans, temp);
        }
        return (int) ans;
    }
}