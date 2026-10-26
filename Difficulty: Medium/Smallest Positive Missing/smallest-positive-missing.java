class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            while(arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1])
            {
                // Swap arr[i] with arr[arr[i] - 1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for(int i = 1; i <= n; i++)
        {
            if(arr[i - 1] != i)
            {
                return i;
            }
        }
        return n + 1;
    }
}
