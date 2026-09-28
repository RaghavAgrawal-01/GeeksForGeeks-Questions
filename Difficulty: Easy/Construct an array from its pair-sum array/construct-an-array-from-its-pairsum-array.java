class Solution {
    public ArrayList<Integer> constructArr(int[] a) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(a.length == 1)
        {
            res.add(1);
            res.add(a[0] - 1);
            return res;
        }
        final int n = (int) (1 + Math.sqrt(1 + 8*a.length) / 2);
        res.add((a[1] + a[0] - a[n-1]) / 2);
        for(int i = 1; i < n; i++)
        {
            res.add(a[i-1] - res.get(0));
        }
        return res;
    }
}
