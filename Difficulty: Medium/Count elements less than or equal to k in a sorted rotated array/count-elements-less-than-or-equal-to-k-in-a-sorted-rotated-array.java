class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
        Arrays.sort(arr);
        int l = 0, r = arr.length;

        while(l < r)
        {
            int mid = l + (r - l) / 2;

            if(arr[mid] <= x)
            {
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
}
