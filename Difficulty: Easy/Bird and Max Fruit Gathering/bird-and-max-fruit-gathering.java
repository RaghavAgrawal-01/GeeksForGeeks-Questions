class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if(m >= n)
        {
            int sum = 0;
            for(int val : arr) sum += val;
            return sum;
        }

        int cur = 0;
        for(int i = 0; i < m; i++)
        {
            cur += arr.get(i);
        }

        int maxFruits = cur;
        for(int i = m; i < n + m - 1; i++)
        {
            cur += arr.get(i % n) - arr.get((i - m) % n);
            maxFruits = Math.max(maxFruits, cur);
        }

        return maxFruits;
    }
}