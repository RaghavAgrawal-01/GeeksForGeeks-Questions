class Solution {
    int getLPSLength(String s) {
        // code here
        int n = s.length();
        int p = 0, pos = 1, sPtr = 1, count = 0;

        while(p < n && sPtr < n)
        {
            if(s.charAt(p)==s.charAt(sPtr))
            {
                p++;
                sPtr++;
                count++;
            }
            else {
                p = 0;
                pos++;
                sPtr = pos;
                count = 0;
            }
        }
        return count;
    }
}