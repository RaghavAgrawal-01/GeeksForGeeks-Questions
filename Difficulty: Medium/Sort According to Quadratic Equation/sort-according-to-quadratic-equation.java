




// Approach 2: Use a two-pointer approach to evaluate and insert transformed values based on the direction of the parabola (A >= 0 fills from end, A < 0 fills from start).
// Time Complexity: O(N), as each element is processed once using two pointers.
// Space Complexity: O(N), for storing the sorted transformed values in a new ArrayList.
class Solution {
    // Method to evaluate the quadratic equation for a given x
    private int evaluate(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0)); // Initialize list with size n

        int l   = 0;                                                            // Left pointer
        int r   = n - 1;                                                        // Right pointer
        int idx = (A >= 0) ? n - 1 : 0;                                         // Start filling from end if A >= 0, else from start

        while (l <= r) {
            int leftVal  = evaluate(arr[l], A, B, C);
            int rightVal = evaluate(arr[r], A, B, C);

            if (A >= 0) {
                // Parabola opens upward → fill larger values at the end
                if (leftVal > rightVal) {
                    result.set(idx--, leftVal);
                    l++;
                } else {
                    result.set(idx--, rightVal);
                    r--;
                }
            } else {
                // Parabola opens downward → fill smaller values at the start
                if (leftVal < rightVal) {
                    result.set(idx++, leftVal);
                    l++;
                } else {
                    result.set(idx++, rightVal);
                    r--;
                }
            }
        }

        return result; // Return the sorted transformed list
    }
}
