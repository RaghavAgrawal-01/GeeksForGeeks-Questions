class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int i = 0;
        int j = arr.length - 1;
        int ans = j + 1;
        while(i <= j)
        {
            int mid = i + (j - i) / 2;
            if(arr[mid] >= k)
            {
                ans = mid;
                j = mid - 1;
            }
            else i = mid + 1;
        }

        return ans;
    }
};