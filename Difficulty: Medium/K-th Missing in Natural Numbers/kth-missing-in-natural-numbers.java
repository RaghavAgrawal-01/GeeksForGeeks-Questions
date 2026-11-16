class Solution{
    public int findKthSmall(int[] arr,int k){
        Arrays.sort(arr);
        int missingCount=0;
        int curr=1;
        int i=0;
        int n=arr.length;
        while(true)
        {
            if(i<n&&arr[i]==curr){
                i++;
            }
            else{
                missingCount++;
                if(missingCount==k){
                    return curr;
                }
            }
            curr++;
        }
    }
}