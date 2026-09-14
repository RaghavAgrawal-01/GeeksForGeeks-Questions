class Solution {
    public java.util.ArrayList<Integer> smallestDiff(int a[], int b[], int c[]) {
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        java.util.Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int bestMax = 0, bestMid = 0, bestMin = 0;

        while(i < a.length && j < b.length && k < c.length) {
            int curMin = Math.min(a[i], Math.min(b[j], c[k]));
            int curMax = Math.max(a[i], Math.max(b[j], c[k]));
            int curMid = a[i] + b[j] + c[k] - curMin - curMax;
            int diff = curMax - curMin;
            int sum = a[i] + b[j] + c[k];

            if(diff < minDiff || (diff == minDiff && sum < minSum)) {
                minDiff = diff;
                minSum = sum;
                bestMax = curMax;
                bestMid = curMid;
                bestMin = curMin;
            }

            if(curMin == a[i]) i++;
            else if(curMin == b[j]) j++;
            else k++;
        }

        java.util.ArrayList<Integer> res = new java.util.ArrayList<>();
        res.add(bestMax);
        res.add(bestMid);
        res.add(bestMin);
        return res;
    }
}