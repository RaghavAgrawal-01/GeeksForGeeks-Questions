class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;
        int[][] discs = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int maxR = 0, maxH = 0;
        for(int i = 0; i < n; i++)
        {
            maxR = Math.max(maxR, discs[i][0]);
            maxH = Math.max(maxH, discs[i][1]);
        }

        int[] tree = new int[maxH + 1];
        int ans = 0;

        int i = 0;
        while(i < n)
        {
            int j = i;
            while(j < n && discs[j][0] == discs[i][0])
            {
                j++;
            }

            int[] tempMax = new int[j - i];
            for(int k = i; k < j; k++)
            {
                int bestBelow = query(tree, discs[k][1] - 1);
                tempMax[k - i] = bestBelow + discs[k][1];
            }

            for(int k = i; k < j; k++)
            {
                update(tree, maxH, discs[k][1], tempMax[k - i]);
                ans = Math.max(ans, tempMax[k - i]);
            }

            i = j;
        }

        return ans;
    }

    private void update(int[] tree, int maxH, int idx, int val) {
        while(idx <= maxH)
        {
            tree[idx] = Math.max(tree[idx], val);
            idx += idx & (-idx);
        }
    }

    private int query(int[] tree, int idx) {
        int maxVal = 0;
        while(idx > 0)
        {
            maxVal = Math.max(maxVal, tree[idx]);
            idx -= idx & (-idx);
        }
        return maxVal;
    }
}