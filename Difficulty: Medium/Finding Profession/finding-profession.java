class Solution {
    public String profession(int level, int pos) {
        // code here
        int flips = 0;
        pos = pos - 1;
        while(pos > 0)
        {
            if((pos & 1) == 1)
            {
                flips++;
            }
            pos = pos >> 1;
        }
        return (flips % 2 == 0) ? "Engineer" : "Doctor";
    }
}