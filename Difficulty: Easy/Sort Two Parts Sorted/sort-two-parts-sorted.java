class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;

        int breakIdx = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                breakIdx = i + 1;
                break;
            }
        }

        if (breakIdx == -1) {
            return;
        }

        int[] temp = new int[n];
        int i = 0;
        int j = breakIdx;
        int k = 0;

        while (i < breakIdx && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < breakIdx) {
            temp[k++] = arr[i++];
        }

        while (j < n) {
            temp[k++] = arr[j++];
        }

        for (int idx = 0; idx < n; idx++) {
            arr[idx] = temp[idx];
        }
    }
}