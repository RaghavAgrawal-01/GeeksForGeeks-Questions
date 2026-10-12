// Intuition: To minimize the max time, we must pair mice and holes such that their relative order is preserved.
// Pairing the i-th smallest mouse with the i-th smallest hole is the optimal strategy.
// Any other pairing would necessarily lead to a larger or equal maximum distance for at least one mouse.
//
// Approach:
// 1. Sort the `mices` array to order mice positions.
// 2. Sort the `holes` array to order hole positions.
// 3. Initialize `maxDiff = 0` to store the maximum time taken.
// 4. Iterate from i = 0 to n-1 (where n is the number of mice/holes).
// 5. In each iteration, calculate the time for the i-th pair: `diff = abs(mices[i] - holes[i])`.
// 6. Update `maxDiff` with the maximum difference found so far: `maxDiff = max(maxDiff, diff)`.
// 7. After the loop, `maxDiff` will hold the time taken by the last mouse in the optimal assignment, which is our answer.
//
// Time Complexity: O(N log N), dominated by the two sorting operations. The final loop is O(N).
// Space Complexity: O(1) (or O(log N) for the sort recursion stack), as we modify arrays in-place.

class Solution {
    public int assignHole(int[] mices, int[] holes) {
        int n = mices.length; // Number of mice and holes

        // Step 1: Sort both arrays
        Arrays.sort(mices);
        Arrays.sort(holes);

        // Step 2: Initialize max time
        int maxDiff = 0;

        // Step 3: Iterate and compute max absolute difference
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(mices[i] - holes[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        // Step 4: Return the result
        return maxDiff;
    }
}

/*
*
* Dry Run
* * Input: mices[] = [4, -4, 2], holes[] = [4, 0, 5]
* n = 3
* * 1. Sort mices: [-4, 2, 4]
* 2. Sort holes: [0, 4, 5]
* 3. Initialize max = 0
* * 4. Loop:
* i = 0:
* diff = abs(mices[0] - holes[0]) = abs(-4 - 0) = 4
* Is max (0) < diff (4)? Yes.
* Set max = 4
* * i = 1:
* diff = abs(mices[1] - holes[1]) = abs(2 - 4) = 2
* Is max (4) < diff (2)? No.
* max remains 4
* * i = 2:
* diff = abs(mices[2] - holes[2]) = abs(4 - 5) = 1
* Is max (4) < diff (1)? No.
* max remains 4
* * 5. Loop finishes.
* 6. Return max (4).
*
*/