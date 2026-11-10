// class Solution {
//     public static int sumSubstrings(String s) {
//         // code here
//         long sum = 0;
//         long mf = 1;
//         for (int i = s.length() - 1; i >= 0; i--) {
//             sum += (s.charAt(i) - '0') * (i + 1) * mf;
//             mf = mf * 10 + 1;
//         }
//         return (int)sum;
//     }
// }






class Solution { 
    public static long sumSubstrings(String s) {
        long ans = 0, previous = 0;
        for(int i = 0; i < s.length(); i++)
        {
            long num = s.charAt(i) - '0';
            long curr = previous * 10 + num * (i + 1);
            previous = curr;
            ans += curr;
        }
        return ans;
    }
}
