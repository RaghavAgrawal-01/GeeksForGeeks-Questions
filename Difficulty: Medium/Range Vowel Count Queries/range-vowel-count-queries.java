class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] pref = new int[n + 1];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int isVowel = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? 1 : 0;
            pref[i + 1] = pref[i] + isVowel;
        }
        ArrayList<Integer> ans = new ArrayList<>(queries.length);
        for(int[] q : queries) {
            int l = q[0];
            int r = q[1];
            ans.add(pref[r + 1] - pref[l]);
        }
        return ans;
    }
}