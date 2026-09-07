// class Solution {
//     void pushZerosToEnd(int[] arr) {
//         // code here
//         int pos = 0;
//         for(int i = 0; i < arr.length; i++)
//             if (arr[i] != 0) arr[pos++] = arr[i];
//         while(pos < arr.length) arr[pos++] = 0;
//     }
// }





// class Solution {
//     void pushZerosToEnd(int[] arr) {
//         int n = arr.length;
//         int nonZeroIndex = 0;
//         for(int i = 0; i < n; i++) {
//             if(arr[i] != 0){
//                 int temp = arr[nonZeroIndex];
//                 arr[nonZeroIndex] = arr[i];
//                 arr[i] = temp;
//                 nonZeroIndex++;
//             }
//         }
//     }
// }






class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0)
            {
                int temp = arr[nonZeroIndex];
                arr[nonZeroIndex] = arr[i];
                arr[i] = temp;
                nonZeroIndex++;
            }
        }
    }
}