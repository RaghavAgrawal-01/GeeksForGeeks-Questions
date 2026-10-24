class Solution {
    public boolean isPossible(int n, int m, String s) {
        int maxL = 0, maxR = 0, maxU = 0, maxD = 0;
        int currX = 0, currY = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'L') {
                currY--;
            }
            else if (ch == 'R') {
                currY++;
            }else if (ch == 'D') {
                currX--;
            }
            else if (ch == 'U') {
                currX++;
            }
            maxL = Math.min(maxL, currY);
            maxR = Math.max(maxR, currY);
            maxD = Math.min(maxD, currX);
            maxU = Math.max(maxU, currX);
        }
        int rowsNeeded = maxU - maxD + 1;
        int colsNeeded = maxR - maxL + 1;
        return rowsNeeded <= n && colsNeeded <= m;
    }
}