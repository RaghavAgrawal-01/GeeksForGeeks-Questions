class Solution {
    int subsetXORSum(int arr[]) {
        // code here
        int or = 0;
        for(int num : arr) or |= num;
        
        return or<<arr.length-1;
    }
}