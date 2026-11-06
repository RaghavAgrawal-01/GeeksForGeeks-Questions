class Solution {
    public int findMissing(int[] arr) {
        int n = arr.length;
        if(n == 2) {
            int d = arr[1] - arr[0];
            return arr[1] + d;
        }

        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];

        int d = diff1;
        if(Math.abs(diff2) < Math.abs(diff1)) {
            d = diff2;
        } else if(Math.abs(diff1) == Math.abs(diff2)) {
            d = diff1;
        }

        int low = 0, high = n - 1;
        int missing = arr[n - 1] + d;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] != arr[0] + mid * d) {
                missing = arr[0] + mid * d;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return missing;
    }
}