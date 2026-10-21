class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : arr) {
            result.add(num);
        }
        int i = 0;
        while(i < n)
        {
            int j = i;
            while(j < n - 1 && (result.get(j) + result.get(j + 1)) % 2 == 0) {
                j++;
            }
            if(i < j)
            {
                List<Integer> sublist = result.subList(i, j + 1);
                sublist.sort(Collections.reverseOrder());
            }
            i = j + 1;
        }
        return result;
    }
}