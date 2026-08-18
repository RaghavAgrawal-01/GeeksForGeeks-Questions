class Solution {
    public int maxArea(List<Integer> height) {
        // code here
        int n = height.size();
        if (n < 2) return 0;
        int left = 0, right = n - 1;
        long maxArea = 0;
        while(left < right)
        {
            long width = right - left - 1;
            long area = Math.min(height.get(left), height.get(right)) * width;
            maxArea = Math.max(maxArea, area);
            if(height.get(left) <= height.get(right))
            {
                left++;
            }
            else {
                right--;
            }
        }
        return (int) maxArea;
    }
}