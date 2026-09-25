class Solution {
    public boolean findSwapValues(int[] a, int[] b) {
        // code here
        long sumA = 0;
        long sumB = 0;

        for(int x : a)
        {
            sumA += x;
        }

        for(int y : b)
        {
            sumB += y;
        }

        long diff = sumA - sumB;
        if(diff % 2 != 0)
        {
            return false;
        }

        long target = diff / 2;

        Set<Long> setB = new HashSet<>();
        for(int y : b)
        {
            setB.add((long) y);
        }

        for(int x : a)
        {
            if(setB.contains((long) x - target))
            {
                return true;
            }
        }

        return false;
    }
}