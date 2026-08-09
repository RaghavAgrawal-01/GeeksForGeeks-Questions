class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int n = s.length();
        int[] maxReach = new int[26];
        Arrays.fill(maxReach, -1);
        
        int maxDiff = -1;
        
        for (int i = n - 1; i >= 0; i--) {
            int charIdx = s.charAt(i) - 'a';
            
            int reachableFromI = i;
            if (charIdx < 25 && maxReach[charIdx + 1] != -1) {
                reachableFromI = maxReach[charIdx + 1];
            }
            
            if (charIdx == 0) {
                maxDiff = Math.max(maxDiff, reachableFromI - i);
            }
            
            maxReach[charIdx] = Math.max(maxReach[charIdx], reachableFromI);
        }
        
        return maxDiff;
    }
}