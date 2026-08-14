class Solution {
    public int maxCharGap(String s) {
        // code here
        int[] first = new int[26];
        Arrays.fill(first, -1);

        int ans = -1;

        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            if(first[ch] == -1) {
                first[ch] = i;
            } else {
                ans = Math.max(ans, i - first[ch] - 1);
            }
        }

        return ans;
    }
};