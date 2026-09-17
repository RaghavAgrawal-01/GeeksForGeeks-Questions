class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        if(s1.length() != s2.length())
        {
            return false;
        }
        HashMap<Character, Character> mp1 = new HashMap<>();
        HashMap<Character, Character> mp2 = new HashMap<>();
        int n = s1.length();
        for(int i = 0; i < n; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if((mp1.containsKey(c1) && mp1.get(c1) != c2) ||
                (mp2.containsKey(c2) && mp2.get(c2) != c1)) {
                return false;
            }
            mp1.put(c1, c2);
            mp2.put(c2, c1);
        }
        return true;
    }
}