class Solution {
    public String compress(String s) {
        // code here
        int n = s.length();
        int[] lps = new int[n];
        for(int i = 1; i < n; i++) 
        {
            int j = lps[i - 1];
            while(j > 0 && s.charAt(i) != s.charAt(j)) 
            {
                j = lps[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)) 
            {
                j++;
            }
            lps[i] = j;
        }
        StringBuilder res = new StringBuilder();
        int i = n - 1;
        while(i >= 0) 
        {
            if(i % 2 == 1) 
            {
                int len = i + 1;
                int half = len / 2;
                int k = lps[i];
                while(k > half) 
                {
                    k = lps[k - 1];
                }

                if(k == half) 
                {
                    res.append('*');
                    i = half - 1;
                    continue;
                }
            }

            res.append(s.charAt(i));
            i--;
        }

        return res.reverse().toString();
    }
}