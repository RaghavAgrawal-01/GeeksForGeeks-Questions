class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for (int r : roll) {
            diff[0]++;
            diff[r]--;
        }
        char[] arr = s.toCharArray();
        int currentRoll = 0;
        for (int i = 0; i < n; i++) {
            currentRoll += diff[i];
            int totalRoll = (arr[i] - 'a' + currentRoll) % 26;
            arr[i] = (char) ('a' + totalRoll);
        }
        return new String(arr);
    }
}