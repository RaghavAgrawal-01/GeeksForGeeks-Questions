class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int total = 0;
        for(int num : arr)
        {
            total += num;
        }
        if(total % 2 != 0) return false;
        int prefixSum = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            prefixSum += arr[i];
            if(prefixSum == total / 2)
            {
                return true;
            }
        }
        return false;
    }
}