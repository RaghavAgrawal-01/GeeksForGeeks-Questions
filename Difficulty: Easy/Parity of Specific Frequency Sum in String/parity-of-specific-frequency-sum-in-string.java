class Solution {
    public boolean isEven(String s) {
        // code here
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        int x = 0; // even position, even frequency
        int y = 0; // odd position, odd frequency

        for(int i = 0; i < 26; i++)
        {
            if(freq[i] > 0)
            {
                int pos = i + 1; // 1-based position in English alphabet

                if(pos % 2 == 0 && freq[i] % 2 == 0)
                {
                    x++;
                }
                else if(pos % 2 != 0 && freq[i] % 2 != 0)
                {
                    y++;
                }
            }
        }

        return (x + y) % 2 == 0;
    }
}