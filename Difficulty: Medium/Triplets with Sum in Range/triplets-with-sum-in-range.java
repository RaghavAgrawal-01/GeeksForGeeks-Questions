class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);
        return countTripletsLessThan(arr, r) - countTripletsLessThan(arr, l - 1);
    }

    private int countTripletsLessThan(int[] arr, int val) {
        int count = 0;
        int n = arr.length;

        for(int i = 0; i < n - 2; i++) 
        {
            int left = i + 1;
            int right = n - 1;

            while(left < right) 
            {
                int sum = arr[i] + arr[left] + arr[right];

                if(sum <= val) 
                {
                    count += (right - left);
                    left++;
                } 
                else 
                {
                    right--;
                }
            }
        }

        return count;
    }
}