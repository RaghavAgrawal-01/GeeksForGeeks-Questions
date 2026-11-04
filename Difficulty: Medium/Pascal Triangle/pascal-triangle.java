// User function Template for Java

class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1); // First element is always 1
        long prev = 1;
        for(int i = 1; i < n; i++) {
            long curr = prev * (n - i) / i;
            res.add((int) curr);
            prev = curr;
        }
        return res;
    }
}