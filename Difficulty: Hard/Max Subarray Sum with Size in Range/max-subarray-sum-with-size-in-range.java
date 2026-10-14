class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        // code here
        int n = arr.length;
        long[] prefix = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int ans = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int r = a; r <= n; r++) {
            int left = r - b;
            int right = r - a;

            while (!dq.isEmpty() && dq.peekFirst() < left) {
                dq.pollFirst();
            }

            if (right >= 0) {
                while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[right]) {
                    dq.pollLast();
                }
                dq.offerLast(right);
            }

            if (!dq.isEmpty()) {
                ans = Math.max(ans, (int)(prefix[r] - prefix[dq.peekFirst()]));
            }
        }
        return ans;
    }
}