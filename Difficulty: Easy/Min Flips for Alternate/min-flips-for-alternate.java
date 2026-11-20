class Solution {
    public int minFlips(String s) {
        int flipsStartZero = 0;
        int flipsStartOne = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char expectedZero = (i % 2 == 0) ? '0' : '1';
            char expectedOne = (i % 2 == 0) ? '1' : '0';
            if(s.charAt(i) != expectedZero){
                flipsStartZero++;
            }
            if(s.charAt(i) != expectedOne){
                flipsStartOne++;
            }
        }
        return Math.min(flipsStartZero, flipsStartOne);
    }
}