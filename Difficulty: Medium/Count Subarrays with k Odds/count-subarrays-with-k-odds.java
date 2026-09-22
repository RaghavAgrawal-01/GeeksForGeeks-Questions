class Solution {
    private int solve(int[] arr, int k) {
        if(k < 0) return 0;
        int n = arr.length;
        int i = 0, j = 0;
        int odd = 0;
        int ans = 0;
        while(i < n)
        {
            if(arr[i] % 2 == 1)
            {
                odd++;
            }

            while(odd > k)
            {
                if(arr[j]%2 == 1)
                {
                    odd--;
                }
                j++;
            }
            ans += (i-j+1);
            i++;
        }
        return ans;
    }
    public int countSubarrays(int[] arr, int k) {
        return solve(arr, k) - solve(arr, k - 1);
    }
}
