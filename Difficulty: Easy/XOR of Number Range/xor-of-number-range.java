class Solution {
    public int findXOR(int l, int r) {
        return computeXOR(l - 1) ^ computeXOR(r);
    }

    private int computeXOR(int n) {
        int rem = n % 4;
        if(rem == 0) return n;
        if(rem == 1) return 1;
        if(rem == 2) return n + 1;
        return 0;
    }
}