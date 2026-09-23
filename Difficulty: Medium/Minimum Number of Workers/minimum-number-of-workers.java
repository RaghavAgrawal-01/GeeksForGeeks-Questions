class Solution {
    public int minMen(int arr[]) {
        // code here
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        // Convert workers into intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{left, right});
            }
        }

        // Sort intervals by starting point
        intervals.sort((a, b) -> a[0] - b[0]);

        int count = 0;
        int covered = 0;
        int i = 0;

        // Greedy coverage of [0, n-1]
        while (covered < n) {
            int farthest = covered;

            while (i < intervals.size() && intervals.get(i)[0] <= covered) {
                farthest = Math.max(farthest, intervals.get(i)[1] + 1);
                i++;
            }

            // If we cannot extend coverage
            if (farthest == covered)
                return -1;

            count++;
            covered = farthest;
        }

        return count;
    }
}