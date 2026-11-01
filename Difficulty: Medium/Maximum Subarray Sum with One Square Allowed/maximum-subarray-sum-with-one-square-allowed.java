class Solution {
    public int maximumSubarray(int[] arr) {
        int n = arr.length;
        long[] maxEnding = new long[n];
        long[] maxEndingSq = new long[n];

        long maxSoFar = arr[0];
        long val0 = arr[0];
        long sq0 = (long) arr[0] * arr[0];

        maxEnding[0] = val0;
        maxEndingSq[0] = Math.max(val0, sq0);
        maxSoFar = Math.max(maxSoFar, maxEndingSq[0]);

        for(int i = 1; i < n; i++) {
            long v = arr[i];
            long sq = v * v;

            maxEnding[i] = Math.max(v, maxEnding[i - 1] + v);

            long opt1 = sq;
            long opt2 = maxEnding[i - 1] + sq;
            long opt3 = maxEndingSq[i - 1] + v;

            maxEndingSq[i] = Math.max(opt1, Math.max(opt2, opt3));

            maxSoFar = Math.max(maxSoFar, maxEndingSq[i]);
        }

        return (int) maxSoFar;
    }
}