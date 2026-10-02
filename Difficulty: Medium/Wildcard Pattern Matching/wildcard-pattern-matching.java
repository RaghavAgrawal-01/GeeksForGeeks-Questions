// class Solution {
//     public boolean wildCard(String txt, String pat) {
//         int m = txt.length();
//         int n = pat.length();

//         // dp[i][j] will be true if txt[0..i-1] matches pat[0..j-1]
//         boolean[][] dp = new boolean[m + 1][n + 1];

//         // An empty pattern can match with an empty text
//         dp[0][0] = true;

//         // Only '*' can match with an empty string, so we pre-fill the first row
//         for (int j = 1; j <= n; j++) {
//             if (pat.charAt(j - 1) == '*') {
//                 dp[0][j] = dp[0][j - 1];
//             }
//         }

//         // Fill the rest of the table
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 // If characters match or there's a '?' in the pattern, we can inherit the previous match
//                 if (pat.charAt(j - 1) == '?' || txt.charAt(i - 1) == pat.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 }
//                 // If there's a '*' in the pattern, it can match zero or more characters in the text
//                 else if (pat.charAt(j - 1) == '*') {
//                     dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                 }
//             }
//         }

//         // The answer will be in the bottom-right cell of the dp table
//         return dp[m][n];
//     }

//     public static void main(String[] args) {
//         Solution g = new Solution();
//         String text = "adceb";
//         String pat = "*a*b";
        
//         // Use the corrected method to check for a match
//         if (g.wildCard(text, pat)) {
//             System.out.println("Match found");
//         } else {
//             System.out.println("No match found");
//         }
//     }
// }








class Solution {
    public boolean wildCard(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int j = 1; j <= m; j++) 
            if (pat.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(pat.charAt(j - 1) == '*') 
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if(pat.charAt(j - 1) == '?' || txt.charAt(i - 1) == pat.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }
}