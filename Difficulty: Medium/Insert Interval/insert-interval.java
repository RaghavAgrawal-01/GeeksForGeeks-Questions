// class Solution {
//     public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
//         // code here
//         ArrayList<int[]> ans = new ArrayList<>();
//         int n = intervals.length;
//         int i = 0;
//         // Add all intervals ending before newInterval starts
//         while (i < n && intervals[i][1] < newInterval[0]) {
//             ans.add(intervals[i]);
//             i++;
//         }
//         // Merge overlapping intervals with newInterval
//         while (i < n && intervals[i][0] <= newInterval[1]) {
//             newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//             newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//             i++;
//         }
//         ans.add(newInterval);
//         // Add remaining intervals
//         while (i < n) {
//             ans.add(intervals[i]);
//             i++;
//         }
//         return ans;
//     }
// }








class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            result.add(intervals[i++]);
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        result.add(newInterval);
        
        while (i < intervals.length) result.add(intervals[i++]);
        
        return result;
    }
}