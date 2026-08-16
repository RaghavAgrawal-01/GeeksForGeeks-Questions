class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);

        int sum = 0;
        int i = arr.length - 1;
        while(i > 0)
        {
            if(arr[i] - arr[i - 1] < k)
            {
                sum += arr[i] + arr[i - 1];
                i -= 2;
            }
            else {
                i--;
            }
        }

        return sum;
    }
}