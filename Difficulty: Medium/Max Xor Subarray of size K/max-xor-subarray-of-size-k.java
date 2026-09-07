class Solution{
    public int maxSubarrayXOR(int[] arr, int k){
        int n = arr.length;
        int curXor=0;
        for(int i=0;i<k; i++){
            curXor ^= arr[i];
        }
        int maxXor = curXor;
        for(int i=k; i<n; i++){
            curXor = curXor ^ arr[i-k] ^ arr[i];
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;
    }
}

