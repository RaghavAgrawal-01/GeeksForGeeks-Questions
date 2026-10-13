class Solution {
    static int maxArea(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[] height = new int[m];
        int maxArea = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 0)
                    height[j] = 0;
                else
                    height[j] += 1;
            }
            maxArea = Math.max(maxArea, getMaxArea(height));
        }
        return maxArea;
    }
    private static int getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0; i <= n; i++)
        {
            int currHeight=(i==n) ? 0 : heights[i];
            while(!stack.isEmpty() && currHeight < heights[stack.peek()])
            {
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
