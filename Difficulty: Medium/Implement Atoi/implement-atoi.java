class Solution {
    public int myAtoi(String s) {
        // code here
        int i = 0, n = s.length();
        while(i < n && s.charAt(i) == ' ')
        {
            i++;
        }
        if(i == n) return 0;
        int sign = 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-')
        {
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }
        long num = 0;
        while(i < n)
        {
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') break;
            num = num * 10 + (ch - '0');
            if(sign * num >= Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            if(sign * num <= Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign * num);
    }
}