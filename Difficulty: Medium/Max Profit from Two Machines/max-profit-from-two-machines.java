class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        // code here
        int n = a.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (i, j) -> Math.abs(a[j] - b[j]) - Math.abs(a[i] - b[i]));
        int profit = 0;
        for(int i = 0; i < n; i++)
        {
            int task = idx[i];
            if((a[task] >= b[task] && x > 0) || y == 0)
            {
                profit += a[task];
                x--;
            }
            else {
                profit += b[task];
                y--;
            }
        }
        return profit;
    }
}