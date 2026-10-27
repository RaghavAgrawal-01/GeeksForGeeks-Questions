class Solution {
    public char nthCharacter(int n) {
        long len = 0;
        long digits = 1;
        long count = 9;
        long start = 1;

        while(n > len + count * digits) {
            len += count * digits;
            digits++;
            start *= 10;
            count *= 10;
        }

        long diff = n - len - 1;
        long num = start + diff / digits;
        int rem = (int)(diff % digits);

        String s = Long.toString(num);
        return s.charAt(rem);
    }
}