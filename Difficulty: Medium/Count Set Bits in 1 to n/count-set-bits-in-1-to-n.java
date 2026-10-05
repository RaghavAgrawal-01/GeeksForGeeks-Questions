class Solution {
    public static int countSetBits(int n) {
       if(n == 0) return 0;

        int mp = (int)(Math.log(n) / Math.log(2));

        int x = mp * (1 << (mp - 1));
        int msbs = n - (1 << mp) + 1;
        int rem = n - (1 << mp);

        return x + msbs + countSetBits(rem);
    }
}