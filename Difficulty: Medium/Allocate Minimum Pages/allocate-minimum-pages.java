class Solution {
    public int findPages(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }

        long low = 0;
        long high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    private boolean isPossible(int[] arr, int k, long maxPages) {
        int students = 1;
        long currentPages = 0;

        for (int pages : arr) {
            if (pages > maxPages) {
                return false;
            }
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            } else {
                students++;
                currentPages = pages;
            }
        }

        return students <= k;
    }
}