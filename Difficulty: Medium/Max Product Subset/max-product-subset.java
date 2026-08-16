class Solution {
    public int findMaxProduct(int[] arr) {
        // code here
        long MOD = 1000000007L;

        if(arr.length == 1)
        {
            return arr[0];
        }

        int negCount = 0;
        int zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;

        for(int x : arr)
        {
            if(x == 0)
            {
                zeroCount++;
            }
            else if(x < 0)
            {
                negCount++;
                maxNeg = Math.max(maxNeg, x);
            }
        }

        if(zeroCount == arr.length)
        {
            return 0;
        }

        if(negCount == 1 && negCount + zeroCount == arr.length)
        {
            return 0;
        }

        long product = 1;
        boolean skipped = false;

        for(int x : arr)
        {
            if(x == 0)
            {
                continue;
            }

            if((negCount & 1) == 1 && x == maxNeg && !skipped)
            {
                skipped = true;
                continue;
            }

            product = (product * ((x % MOD + MOD) % MOD)) % MOD;
        }

        return (int)product;
    }
}