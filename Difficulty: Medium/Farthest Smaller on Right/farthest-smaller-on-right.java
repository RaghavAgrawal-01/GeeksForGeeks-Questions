class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        int[] suff = new int[n];
        suff[n - 1] = arr[n - 1];
        
        for (int i = n - 2; i >= 0; --i) {
            suff[i] = Math.min(arr[i], suff[i + 1]);
        }

        for (int i = 0; i < n; ++i) {
            int res = -1;
            
            // if(arr[i] == suff[i]) {
            //     ans.set(i, res);
            // }else{
                
            int l = i + 1, r = n - 1;
            
            while(l <= r) {
                int mid = (l + r) / 2;
                if (suff[mid] < arr[i]) {
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
                
                ans.set(i, res);
            //   }
          }
          
        return ans;
    }
}