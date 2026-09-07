class Solution {
    private Integer[][][] memo;

    public int minCount(int[] arr) {
        int n = arr.length;
        memo = new Integer[n][102][102];
        int maxIncluded = solve(0, 0, 101, arr);
        return n - maxIncluded;
    }

    private int solve(int idx, int lastInc, int lastDec, int[] arr) {
        if(idx == arr.length) {
            return 0;
        }

        if(memo[idx][lastInc][lastDec] != null) {
            return memo[idx][lastInc][lastDec];
        }

        int val = arr[idx];

        int ans = solve(idx + 1, lastInc, lastDec, arr);

        if(val > lastInc) {
            ans = Math.max(ans, 1 + solve(idx + 1, val, lastDec, arr));
        }

        if(val < lastDec) {
            ans = Math.max(ans, 1 + solve(idx + 1, lastInc, val, arr));
        }

        return memo[idx][lastInc][lastDec] = ans;
    }
}