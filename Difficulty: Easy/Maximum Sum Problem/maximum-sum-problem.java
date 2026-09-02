class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int maxSum(int n) {
        // code here.
        if(n == 0)
        {
            return 0;
        }
        if(memo.containsKey(n))
        {
            return memo.get(n);
        }
        int breakSum = maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4);
        int result = Math.max(n, breakSum);
        memo.put(n, result);
        return result;
    }
}
