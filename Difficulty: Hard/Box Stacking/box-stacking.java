class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {
        // code here
        int n = height.length;
        int[][] boxes = new int[3 * n][3];

        for(int i = 0; i < n; i++)
        {
            int h = height[i];
            int w = width[i];
            int l = length[i];

            boxes[3 * i][0] = h;
            boxes[3 * i][1] = Math.max(w, l);
            boxes[3 * i][2] = Math.min(w, l);

            boxes[3 * i + 1][0] = w;
            boxes[3 * i + 1][1] = Math.max(h, l);
            boxes[3 * i + 1][2] = Math.min(h, l);

            boxes[3 * i + 2][0] = l;
            boxes[3 * i + 2][1] = Math.max(h, w);
            boxes[3 * i + 2][2] = Math.min(h, w);
        }

        int len = boxes.length;
        Arrays.sort(boxes, (a, b) -> {
            if(b[1] != a[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[2], a[2]);
        });

        long[] dp = new long[len];
        long maxH = 0;

        for(int i = 0; i < len; i++)
        {
            dp[i] = boxes[i][0];
            for(int j = 0; j < i; j++)
            {
                if(boxes[i][1] < boxes[j][1] && boxes[i][2] < boxes[j][2])
                {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i][0]);
                }
            }
            maxH = Math.max(maxH, dp[i]);
        }

        return (int) maxH;
    }
}