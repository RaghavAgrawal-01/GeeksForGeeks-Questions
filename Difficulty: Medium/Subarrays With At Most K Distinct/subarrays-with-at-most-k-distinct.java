// Approach: Use sliding window with two pointers (i, j) and a map to track frequencies. Expand j to include elements and shrink i if distinct elements > k. At every step, add (j - i + 1) to result to count valid subarrays ending at j.
// Time Complexity: O(n) — each element is inserted and removed from map at most once.
// Space Complexity: O(k) — map stores at most k keys (distinct integers in current window).
class Solution {
    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>(); // to store frequency of elements in current window
        int i = 0; // left boundary of sliding window
        int j = 0; // right boundary of sliding window
        int result = 0; // total number of valid subarrays
        while(j < n)
        {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1); // include arr[j] in the window
            while(mp.size() > k)
            {  
                // if distinct elements exceed k, shrink window from left
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if(mp.get(arr[i]) == 0)
                {
                    mp.remove(arr[i]); // remove element with 0 frequency
                }
                i++; // move left pointer to right
            }
            result += (j - i + 1); // count subarrays ending at j with at most k distinct elements
            j++; // expand window to the right
        }
        return result;
    }
}

/*
 *
 * Dry Run
 * arr = [1, 2, 1, 2, 3], k = 2
 * i = 0, j = 0, result = 0, mp = {}
 *
 * j = 0 → arr[0] = 1
 *     mp = {1=1}, size = 1 <= k
 *     result += (0 - 0 + 1) = 1 → result = 1
 *
 * j = 1 → arr[1] = 2
 *     mp = {1=1, 2=1}, size = 2 <= k
 *     result += (1 - 0 + 1) = 2 → result = 3
 *
 * j = 2 → arr[2] = 1
 *     mp = {1=2, 2=1}, size = 2 <= k
 *     result += (2 - 0 + 1) = 3 → result = 6
 *
 * j = 3 → arr[3] = 2
 *     mp = {1=2, 2=2}, size = 2 <= k
 *     result += (3 - 0 + 1) = 4 → result = 10
 *
 * j = 4 → arr[4] = 3
 *     mp = {1=2, 2=2, 3=1}, size = 3 > k → shrink
 *         i = 0 → arr[0] = 1 → mp = {1=1, 2=2, 3=1}
 *         i = 1 → arr[1] = 2 → mp = {1=1, 2=1, 3=1}
 *         i = 2 → arr[2] = 1 → mp = {2=1, 3=1}, size = 2 → stop
 *     result += (4 - 3 + 1) = 2 → result = 12
 *
 * Final Result = 12
 */