class Solution {
    private String maxStr;

    public String findMaximumNum(String s, int k) {
        maxStr = s;
        solve(s, k, 0);
        return maxStr;
    }

    private void solve(String s, int k, int idx) {
        if (k == 0 || idx == s.length() - 1) {
            return;
        }

        char maxChar = s.charAt(idx);
        for (int i = idx + 1; i < s.length(); i++) {
            if (s.charAt(i) > maxChar) {
                maxChar = s.charAt(i);
            }
        }

        if (maxChar == s.charAt(idx)) {
            solve(s, k, idx + 1);
            return;
        }

        for (int i = s.length() - 1; i >= idx; i--) {
            if (s.charAt(i) == maxChar) {
                s = swap(s, idx, i);

                if (s.compareTo(maxStr) > 0) {
                    maxStr = s;
                }

                solve(s, k - 1, idx + 1);

                s = swap(s, idx, i);
            }
        }
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}