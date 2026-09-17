
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int zeros=0, ones=0;
        for(int num:arr)
        {
            if(num==0) zeros++;
            else if(num==1) ones++;
        }
        
        for(int i=0; i<arr.length; i++)
        {
            if(zeros>0)
            {
                arr[i]=0;
                zeros--;
            }
            else if(ones>0)
            {
                arr[i]=1;
                ones--;
            }
            else{
                arr[i]=2;
            }
        }
    }
}

