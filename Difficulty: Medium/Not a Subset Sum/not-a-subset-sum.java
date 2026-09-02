class Solution {
    public int findSmallest(int[] arr) {
        // code here
        Arrays.sort(arr);
        long smallest = 1;
        for(int num : arr)
        {
            if(num > smallest)
            {
                break;
            }
            smallest += num;
        }
        return (int)smallest;
    }
}