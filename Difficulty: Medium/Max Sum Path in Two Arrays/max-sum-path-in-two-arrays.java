class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int i = 0, j = 0;
        int m = a.length, n = b.length;
        int totalSum = 0;
        int sumA = 0, sumB = 0;
        while(i < m && j < n)
        {
            if(a[i] < b[j])
            {
                sumA += a[i++];
            }
            else if (b[j] < a[i])
            {
                sumB += b[j++];
            }
            else {
                totalSum += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }
        
        while(i < m)
        {
            sumA += a[i++];
        }
        while(j < n)
        {
            sumB += b[j++];
        }
        totalSum += Math.max(sumA, sumB);
        return totalSum;
    }
}