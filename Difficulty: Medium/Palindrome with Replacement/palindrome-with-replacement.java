class Solution {
    public int minimumSum(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0, r = n - 1;

        while (l < r) {
            if (arr[l] != '?' && arr[r] != '?') {
                if (arr[l] != arr[r]) {
                    return -1;
                }
            } else if (arr[l] != '?') {
                arr[r] = arr[l];
            } else if (arr[r] != '?') {
                arr[l] = arr[r];
            }
            l++;
            r--;
        }

        char prev = ' ';
        for (int i = 0; i < n; i++) {
            if (arr[i] != '?') {
                prev = arr[i];
                break;
            }
        }

        if (prev == ' ') {
            for (int i = 0; i < n; i++) {
                arr[i] = 'a';
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] == '?') {
                    arr[i] = prev;
                } else {
                    prev = arr[i];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}