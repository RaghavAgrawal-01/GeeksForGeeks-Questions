class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        ArrayList<Integer> stored = new ArrayList<>();
        int xorVal = 0;
        stored.add(0);
        for(int[] query : queries)
        {
            int type = query[0];
            int x = query[1];
            if(type == 0)
            {
                stored.add(x ^ xorVal);
            }
            else {
                xorVal ^= x;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : stored) {
            ans.add(val ^ xorVal);
        }
        
        Collections.sort(ans);
        return ans;
    }
}