class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n= arr.length, missingCount=0, current =1, i=0;
        while(missingCount<k)
        {
            if(i<n && arr[i]==current)
            {
                i++;
            }
            else
            {
                missingCount++;
                if(missingCount==k)
                {
                    return current;
                }
            }
            current++;
        }
        return -1;
    }
}