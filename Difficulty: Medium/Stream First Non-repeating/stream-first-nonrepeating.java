class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int n = s.length();
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();
        int j = 0; // pointer to track first non-repeating
        for(int i = 0; i < n; i++)
        {
            freq[s.charAt(i) - 'a']++;
            while(j <= i && freq[s.charAt(j) - 'a'] > 1) {
                j++;
            }
            if(j > i){
                ans.append('#');
            }
            else{
                ans.append(s.charAt(j));
            }
        }
        return ans.toString();
    }
}