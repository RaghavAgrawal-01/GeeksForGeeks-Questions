import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        
        int n = arr.length;

        // Make odd numbers negative
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = -arr[i];
            }
        }

        // Sort array
        Arrays.sort(arr);

        // Convert odds back to positive
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[i] = Math.abs(arr[i]);
            }
        }
    }
}
