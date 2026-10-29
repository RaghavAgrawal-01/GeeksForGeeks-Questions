class Solution {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int base = 26;
        long mod = 1_000_000_007L;
        long pHash = 0;
        long tHash = 0;
        long power = 1;

        for(int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        for(int i = 0; i < m; i++) {
            pHash = (pHash * base + pattern.charAt(i) - 'a') % mod;
            tHash = (tHash * base + text.charAt(i) - 'a') % mod;
        }

        for(int i = 0; i <= n - m; i++) {
            if(pHash == tHash) {
                boolean match = true;

                for(int j = 0; j < m; j++) {
                    if(text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if(match) {
                    ans.add(i);
                }
            }

            if(i < n - m) {
                tHash = (tHash - (text.charAt(i) - 'a') * power % mod + mod) % mod;
                tHash = (tHash * base + text.charAt(i + m) - 'a') % mod;
            }
        }

        return ans;
    }
}
