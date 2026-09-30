class Solution {
    public int minTime(int[] A, int N) {
        int low = 0, high = Integer.MAX_VALUE;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long cnt = 0;

            for (int r : A) {
                cnt += countDonut(r, mid);
                if (cnt >= N) break; // early stop
            }

            if (cnt >= N) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static long countDonut(int R, int T) {
        // k = floor((-1 + sqrt(1 + 8T/R)) / 2)
        long val = 1L + 8L * T / R;
        long k = (long) ((Math.sqrt(val) - 1) / 2);
        return k;
    }
}