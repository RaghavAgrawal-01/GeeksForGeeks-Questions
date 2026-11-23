class Solution {
    public char posInfinite(String s, int pos) {
        long n = s.length();
        long target = pos - 1;
        ArrayList<Long> prevLengths = new ArrayList<>();
        ArrayList<Long> dollarCounts = new ArrayList<>();
        long curLen = n;
        long step = 1;
        while(curLen <= target) {
            prevLengths.add(curLen);
            dollarCounts.add(step);
            curLen = 2 * curLen + step;
            step++;
        }
        for(int i = prevLengths.size() - 1; i >= 0; i--) {
            long prevLen = prevLengths.get(i);
            long dollars = dollarCounts.get(i);
            if(target < prevLen) {
                continue;
            }
            else if(target < prevLen + dollars) {
                return '$';
            }
            else {
                long offset = target - (prevLen + dollars);
                target = prevLen - 1 - offset;
            }
        }
        return s.charAt((int)target);
    }
}