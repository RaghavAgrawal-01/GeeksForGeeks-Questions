class Solution {
    public boolean isSumString(String s) {
        // code here
        int n = s.length();
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; i + j < n; j++)
            {
                if(check(s, 0, i, j))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(String s, int beg, int len1, int len2) {
        String s1 = s.substring(beg, beg + len1);
        String s2 = s.substring(beg + len1, beg + len1 + len2);
        String s3 = addStrings(s1, s2);

        int len3 = s3.length();
        if(beg + len1 + len2 + len3 > s.length())
        {
            return false;
        }

        if(!s.substring(beg + len1 + len2, beg + len1 + len2 + len3).equals(s3))
        {
            return false;
        }

        if(beg + len1 + len2 + len3 == s.length())
        {
            return true;
        }

        return check(s, beg + len1, len2, len3);
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry > 0)
        {
            int sum = carry;
            if(i >= 0)
            {
                sum += num1.charAt(i--) - '0';
            }
            if(j >= 0)
            {
                sum += num2.charAt(j--) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}