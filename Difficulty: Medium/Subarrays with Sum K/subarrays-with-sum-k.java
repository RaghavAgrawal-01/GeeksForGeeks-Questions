class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for(int i=0; i<arr.length; i++)
        {
            sum += arr[i];
            if(sum == k)
                count++;
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}