class Solution {
    public int minSquares(int n, int m) {
        long a = n, b = m;
        long count = 0;

        while (a > 0 && b > 0) {
            if (a < b) {
                long temp = a;
                a = b;
                b = temp;
            }

            count += a / b;
            a %= b;
        }

        return (int) count;
    }
}