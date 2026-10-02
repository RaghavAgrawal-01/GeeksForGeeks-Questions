class Solution {
    public String lexiString(String s) {
        String str = s + s;
        int n = str.length();
        int i = 0;
        int j = 1;
        int k = 0;

        while(i < n / 2 && j < n / 2 && k < n / 2)
        {
            if(str.charAt(i + k) == str.charAt(j + k))
            {
                k++;
            }
            else if(str.charAt(i + k) > str.charAt(j + k))
            {
                i = i + k + 1;
                if(i <= j)
                {
                    i = j + 1;
                }
                k = 0;
            }
            else
            {
                j = j + k + 1;
                if(j <= i)
                {
                    j = i + 1;
                }
                k = 0;
            }
        }

        int start = Math.min(i, j);
        return str.substring(start, start + s.length());
    }
}