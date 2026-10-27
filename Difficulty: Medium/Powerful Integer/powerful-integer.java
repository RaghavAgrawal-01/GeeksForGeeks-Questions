class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end = interval[1] + 1;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        int active = 0;
        int maxPowerful = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int pos = entry.getKey();
            if(active >= k) {
                maxPowerful = Math.max(maxPowerful, pos - 1);
            }
            active += entry.getValue();
        }
        return maxPowerful;
    }
}