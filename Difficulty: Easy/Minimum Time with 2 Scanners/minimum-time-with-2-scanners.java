class Solution {
    public int minTime(int n, int s1, int s2) {
        int low = 1, high = Math.max(s1, s2) * n;
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count1 = mid / s1;
            int count2 = mid / s2;
            if(count1 + count2 >= n) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}