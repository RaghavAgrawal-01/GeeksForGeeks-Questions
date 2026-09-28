class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> added = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : arr)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int num : arr)
        {
            if(freq.get(num) > 1 && !added.contains(num))
            {
                result.add(num);
                added.add(num);
            }
        }
        return result;
    }
}