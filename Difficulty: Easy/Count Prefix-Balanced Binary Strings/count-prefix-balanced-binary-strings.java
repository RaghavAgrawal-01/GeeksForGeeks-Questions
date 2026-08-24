class Solution {
     private static final int MOD = 1000000007;

     public int prefixStrings(int n) {
         long[] catalan = new long[n + 1];
         catalan[0] = 1;
         catalan[1] = 1;

         for(int i = 2; i <= n; i++) 
         {
             catalan[i] = 0;
             for(int j = 0; j < i; j++) 
             {
                 catalan[i] = (catalan[i] + (catalan[j] * catalan[i - 1 - j]) % MOD) % MOD;
             }
         }

         return (int) catalan[n];
     }
 }