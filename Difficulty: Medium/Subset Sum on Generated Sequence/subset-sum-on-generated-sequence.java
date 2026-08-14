class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        if(x == 0) 
        {
            return true;
        }

        List<Long> seq = new ArrayList<>();
        seq.add((long) s);

        long currentSum = s;

        for(int i = 0; i < arr.length; i++) 
        {
            long nextVal = currentSum + arr[i];
            seq.add(nextVal);
            currentSum += nextVal;

            if(currentSum > x) 
            {
                break;
            }
        }

        long target = x;

        for(int i = seq.size() - 1; i >= 0; i--) 
        {
            if(target >= seq.get(i)) 
            {
                target -= seq.get(i);
            }
        }

        return target == 0;
    }
}