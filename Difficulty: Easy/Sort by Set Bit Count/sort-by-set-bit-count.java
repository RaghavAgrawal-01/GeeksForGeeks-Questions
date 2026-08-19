class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            temp[i]=arr[i];
        }
        Arrays.sort(temp,(a,b)->Integer.bitCount(b)-Integer.bitCount(a));
        ArrayList<Integer> result = new ArrayList<>();
        for(int x: temp)
        {
            result.add(x);
        }

        return result;
    }
}