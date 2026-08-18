class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        long cost = 0;
        ans.add(0);
        for(int i = 1; i < arr.length; i++)
        {
            cost += (long) arr[i] - arr[i / 2];
            ans.add((int) cost);
        }
        return ans;
    }
}