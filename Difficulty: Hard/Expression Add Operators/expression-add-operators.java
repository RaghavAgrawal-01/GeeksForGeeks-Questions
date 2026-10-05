import java.util.ArrayList;

class Solution {
    static void help(String s, int target, int index, ArrayList<String> ans, int value, int pichla, String newString) {
        if(index == s.length()) {
            if(value == target) {
                ans.add(newString);
            }
            return;
        }

        String temp = "";
        int n = 0;
        for (int i = index; i < s.length(); i++) {
            temp += s.charAt(i);
            n = n * 10 + (s.charAt(i) - '0');

            if (index == 0) {
                help(s, target, i + 1, ans, n, n, temp);
            } else {
                help(s, target, i + 1, ans, value + n, n, newString + "+" + temp);
                help(s, target, i + 1, ans, value - n, -n, newString + "-" + temp);
                help(s, target, i + 1, ans, value - pichla + pichla * n, pichla * n, newString + "*" + temp);
            }

            // Avoid numbers with leading zeros
            if (s.charAt(index) == '0') break;
        }
    }

    public static ArrayList<String> findExpr(String S, int target) {
        ArrayList<String> ans = new ArrayList<>();
        help(S, target, 0, ans, 0, 0, "");
        return ans;
    }
}
