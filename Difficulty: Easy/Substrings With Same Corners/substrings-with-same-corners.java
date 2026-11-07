class Solution {
    public int countSubstring(String s) {
        // code here
        HashMap<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(mp.containsKey(ch))
            {
                count += mp.get(ch);
            }
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        return n + count;
    }
}