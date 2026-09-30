import java.util.*;

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);   // sort array

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];

            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);

            ans.add(right - left);
        }
        return ans;
    }

    // equivalent of lower_bound in C++
    private int lowerBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < key)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // equivalent of upper_bound in C++
    private int upperBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= key)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
