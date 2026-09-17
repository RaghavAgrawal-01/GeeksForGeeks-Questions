class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        Map<Integer,Integer> firstIdx = new HashMap<>();
        int s = 0, res = 0;
        for(int i = 0; i < arr.length; i++)
        {
            s += arr[i] > k ? 1 : -1;
            if(s > 0)
            {
                res = i + 1;
            }
            else{
                firstIdx.putIfAbsent(s, i);
                if(firstIdx.containsKey(s - 1))
                {
                    res = Math.max(res, i - firstIdx.get(s - 1));
                }
            }
        }
        return res;
    }
}