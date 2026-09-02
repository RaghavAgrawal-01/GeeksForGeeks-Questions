class Solution {
    public int solve(int n, String s) {
        int[] status = new int[26];
        int occupied = 0;
        int rejected = 0;
        for(int i = 0; i < s.length(); i++) 
        {
            int idx = s.charAt(i) - 'A';
            if(status[idx] == 0) 
            {
                if(occupied < n) 
                {
                    occupied++;
                    status[idx] = 1;
                } 
                else 
                {
                    status[idx] = 2;
                    rejected++;
                }
            } 
            else if(status[idx] == 1) 
            {
                occupied--;
                status[idx] = 0;
            }
        }
        return rejected;
    }
}