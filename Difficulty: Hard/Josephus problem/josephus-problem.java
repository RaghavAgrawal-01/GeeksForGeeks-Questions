class Solution {
    int solve(int n, int k) {
        /* solve() 0-based index mein winner return karta hai
            Base case: n == 1 → answer 0
        */
        if(n == 1)
        {
            return 0;
        }
        return (solve(n - 1, k) + k) % n;
    }
    public int josephus(int n, int k) {
        // code here
        return solve(n,k) +1;  // josephus() mein +1 isliye kiya kyunki final answer 1-based indexing mein chahiye
    }
}





