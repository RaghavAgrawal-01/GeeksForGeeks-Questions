class Solution {
    public int maxSubsetXOR(int[] arr) {
        // code here
        int index = 0;
        
        for(int i = 20; i >= 0; i--) {
            int maxIdx = index;
            int maxEle = Integer.MIN_VALUE;
            
            for(int j = index; j < arr.length; j++) {
                if((arr[j] & (1 << i)) != 0 && arr[j] > maxEle) {
                    maxEle = arr[j];
                    maxIdx = j;
                }
            }
            
            if(maxEle == Integer.MIN_VALUE) continue;
            
            int temp = arr[index];
            arr[index] = arr[maxIdx];
            arr[maxIdx] = temp;
            
            maxIdx = index;
            
            for(int j = 0; j < arr.length; j++) {
                if(j != maxIdx && (arr[j] & (1 << i)) != 0) {
                    arr[j] ^= arr[maxIdx];
                }
            }
            
            index++;
        }
        
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        
        return res;
    }
}