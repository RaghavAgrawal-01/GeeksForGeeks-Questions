class Solution {
    public int minProd(int[] arr) {
        // code here
         int n = arr.length;
         if(n == 1) 
         {
             return arr[0];
         }

         int negCount = 0;
         int zeroCount = 0;
         int posCount = 0;

         int maxNeg = Integer.MIN_VALUE;
         int minPos = Integer.MAX_VALUE;
         int prod = 1;
         for(int i = 0; i < n; i++) 
         {
             int val = arr[i];

             if(val == 0) 
             {
                 zeroCount++;
                 continue;
             }

             if(val < 0) 
             {
                 negCount++;
                 maxNeg = Math.max(maxNeg, val);
             } 
             else 
             {
                 posCount++;
                 minPos = Math.min(minPos, val);
             }

             prod *= val;
         }

         if(zeroCount == n || (negCount == 0 && zeroCount > 0)) 
         {
             return 0;
         }

         if(negCount == 0) 
         {
             return minPos;
         }

         if(negCount % 2 == 0) 
         {
             prod /= maxNeg;
         }

         return prod;
     }
 }