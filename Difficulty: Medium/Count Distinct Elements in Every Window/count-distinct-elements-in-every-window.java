class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<k ; i++)
        {
            mp.put(arr[i], mp.getOrDefault(arr[i],0) + 1);
        }
        ans.add(mp.size());
        for(int i=k;i<arr.length;i++)
        {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            mp.put(arr[i-k], mp.get(arr[i-k]) - 1);
            if(mp.get(arr[i-k])==0) mp.remove(arr[i-k]);
            ans.add(mp.size());
        }
        return ans;
    }
}
