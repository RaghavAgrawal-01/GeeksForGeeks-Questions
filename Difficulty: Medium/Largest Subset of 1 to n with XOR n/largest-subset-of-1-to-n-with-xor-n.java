class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            ans.add(i + 1);
        }
        int allxor = 0;
        for(int i = 1; i <= n; i++) {
            allxor ^= i;
        }
        if(allxor == n)  return ans;
        int val = allxor ^ n;
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : ans)
        {
            if((num^allxor) == n) continue;
            else res.add(num);
        }
        return res;
    }
}
