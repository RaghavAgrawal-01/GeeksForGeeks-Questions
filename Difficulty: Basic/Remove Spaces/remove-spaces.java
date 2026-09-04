class Solution {
    String removeSpaces(String s) {
        // code here
        StringBuilder res = new StringBuilder();
        for(int a=0;  a<s.length(); a++)
        {
            if(s.charAt(a)!=' ')
            {
                res.append(s.charAt(a));
            }
        }
        return res.toString();
    }
}