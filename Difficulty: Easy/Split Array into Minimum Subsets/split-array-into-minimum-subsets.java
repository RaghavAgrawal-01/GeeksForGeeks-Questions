class Solution {
    int minSubsets(int arr[]) {
        // code here
        Arrays.sort(arr);
        int count = 1;
        for(int i = 1; i < arr.length; i++) 
        {
            if(arr[i] != arr[i - 1] + 1) 
            {
                count++;
            }
        }
        
        return count;
    }
}