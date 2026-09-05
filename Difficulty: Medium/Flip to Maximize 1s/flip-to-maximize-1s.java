class Solution {
    int maxOnes(int[] arr) {
        // code here
        int totalOnes = 0;
        for(int x:arr){
            if(x==1) totalOnes++;
        }
        int maxGain = 0;
        int current = 0;
        for(int x:arr){
            if(x==0) current +=1;
            else current -=1;
            if(current<0) current = 0;
            if(current > maxGain)
            {
                maxGain = current;
            }
        }
        return totalOnes + maxGain;
    }
};