class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int violations = 0;
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                violations++;
            }
        }
        if(violations == 0) {
            return 0;
        }
        for(int day = 0; day < n; day++) {
            int idx = p[day];
            if(idx > 0 && arr[idx] == arr[idx - 1]) {
                violations--;
            }
            if(idx < n - 1 && arr[idx] == arr[idx + 1]) {
                violations--;
            }
            arr[idx] = '?';
            if(violations == 0) {
                return day + 1;
            }
        }
        return 0;
    }
}