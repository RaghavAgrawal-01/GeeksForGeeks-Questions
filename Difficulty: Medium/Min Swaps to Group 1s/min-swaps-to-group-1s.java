class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int n = arr.length;
        int totalOnes = 0;
        for(int num : arr)
        {
            if (num == 1) totalOnes++;
        }
        if(totalOnes == 0) return -1;
        int zeroCount = 0;
        for(int i = 0; i < totalOnes; i++)
        {
            if(arr[i] == 0) zeroCount++;
        }
        int minSwaps = zeroCount;
        for(int i = totalOnes; i < n; i++)
        {
            if(arr[i - totalOnes] == 0) zeroCount--;
            if(arr[i] == 0) zeroCount++;
            minSwaps = Math.min(minSwaps, zeroCount);
        }
        
        return minSwaps;
    }
}
