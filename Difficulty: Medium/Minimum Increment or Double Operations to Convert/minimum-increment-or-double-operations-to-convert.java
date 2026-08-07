class Solution {
    public int countMinOperations(int arr[]) {
        // code here
        int totalIncrements = 0;
        int maxDoubles = 0;
        for(int num : arr)
        {
            int currDoubles = 0;
            while(num > 0)
            {
                if(num % 2 == 1)
                {
                    totalIncrements++;
                    num--;
                }
                else {
                    currDoubles++;
                    num /= 2;
                }
            }
            maxDoubles = Math.max(maxDoubles, currDoubles);
        }
        
        return totalIncrements + maxDoubles;
    }
}