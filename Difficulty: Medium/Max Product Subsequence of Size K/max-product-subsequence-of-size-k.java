class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int prod = 1;

        if(arr[n - 1] <= 0) {
            if(k % 2 != 0) {
                for(int i = n - 1; i >= n - k; i--) {
                    prod *= arr[i];
                }
                return prod;
            }
            else {
                for(int i = 0; i < k; i++) {
                    prod *= arr[i];
                }
                return prod;
            }
        }
        int l = 0;
        int r = n - 1;
        if(k % 2 != 0) {
            prod *= arr[r];
            r--;
            k--;
        }

        while(k > 0) {
            int leftProd = arr[l] * arr[l + 1];
            int rightProd = arr[r] * arr[r - 1];
            if(leftProd > rightProd) {
                prod *= leftProd;
                l += 2;
            }
            else {
                prod *= rightProd;
                r -= 2;
            }
            k -= 2;
        }

        return prod;
    }
}