// class Solution {
//     public int maxWater(int arr[]) {
//         // code here
//         int l = 0, r = arr.length - 1, lmax = 0, rmax = 0, res = 0;
//         while(l < r)
//         {
//             if(arr[l] < arr[r])
//             {
//                 lmax = Math.max(lmax, arr[l]);
//                 res += lmax - arr[l++];
//             }
//             else {
//                 rmax = Math.max(rmax, arr[r]);
//                 res += rmax - arr[r--];
//             }
//         }
//         return res;
//     }
// }







class Solution {
    public int maxWater(int[] arr) {
        int l = 0, r = arr.length - 1, res = 0, lMax = 0, rMax = 0;
        while(l < r)
        {
            if(arr[l] < arr[r])
            {
                lMax = lMax > arr[l] ? lMax : arr[l];
                res += lMax - arr[l++];
            }
            else {
                rMax = rMax > arr[r] ? rMax : arr[r];
                res += rMax - arr[r--];
            }
        }
        return res;
    }
}
