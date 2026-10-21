class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if(m * k > arr.length) return -1;
        int low = 1, high = Arrays.stream(arr).max().getAsInt();
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            int cnt = 0, parts = 0;
            for(int n : arr) {
                cnt = (n <= mid) ? cnt + 1 : 0;
                if(cnt == k) {
                    parts++;
                    cnt = 0;
                }
            }
            if(parts < m) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}