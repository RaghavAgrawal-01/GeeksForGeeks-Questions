class Solution {
    public int subsequenceSum(String s) {
        long mod = 1000000007L;
        long sum = 0;

        for(int i=0;i<s.length();i++) {
            sum = (sum + (s.charAt(i) - '0')) % mod;
        }

        long power = 1;
        long base = 2;
        long exp = s.length() - 1;

        while(exp > 0) {
            if((exp & 1) == 1) {
                power = (power * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return (int)((sum * power) % mod);
    }
}
