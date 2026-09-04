class Solution {
    String URLify(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == ' ')
            {
                res += "%20";
            }
            else {
                res += ch;
            }
        }
        return res;
    }
}