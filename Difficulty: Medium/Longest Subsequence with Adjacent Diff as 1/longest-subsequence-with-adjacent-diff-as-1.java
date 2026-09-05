class Solution {
    public int longestSubseq(int[] arr) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        for(int x : arr)
        {
            int len = Math.max(dp.getOrDefault(x - 1, 0), dp.getOrDefault(x + 1, 0)) + 1;
            dp.put(x, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}