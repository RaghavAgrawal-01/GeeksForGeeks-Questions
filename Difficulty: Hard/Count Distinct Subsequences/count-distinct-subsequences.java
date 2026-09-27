class Solution {
    int distinctSubseq(String s) {
        // code here
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 1; i <= n; i++)
        {
            char ch = s.charAt(i - 1);
            dp[i] = (2 * dp[i - 1]) % mod;
            if(mp.containsKey(ch))
            {
                int index = mp.get(ch);
                dp[i] = (dp[i] - dp[index - 1] + mod) % mod;
            }
            mp.put(ch, i);
        }
        return dp[n];
    }
}