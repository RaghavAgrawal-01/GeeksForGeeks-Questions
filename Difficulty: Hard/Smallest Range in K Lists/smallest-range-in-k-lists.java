

// Approach: Use a min-heap to always get the smallest current element across the lists, track the maximum element so far, and slide the window to find the smallest range that includes one element from each list.
// Time Complexity: O(n * log k), where n is the number of elements per list and k is the number of lists. Each insertion/removal from the heap takes log k time and there are at most n * k elements.
// Space Complexity: O(k), for storing k elements in the min-heap at a time.
class Solution {
    static class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int n = arr.length;    // rows
        int m = arr[0].length; // columns

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b)->a.val - b.val);

        int maxVal   = Integer.MIN_VALUE;
        int maxEl    = -1;
        int minEl    = -1;
        int minRange = Integer.MAX_VALUE;

        // Initialize minHeap with first element from each list and set maxVal
        for (int i = 0; i < n; i++) {
            minHeap.add(new Node(arr[i][0], i, 0));
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        while (true) {
            Node top    = minHeap.poll(); // Get the minimum element
            int  minVal = top.val;
            int  row    = top.row;
            int  col    = top.col;

            // Update smallest range if current range is smaller
            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minEl    = minVal;
                maxEl    = maxVal;
            }

            // If the current list is exhausted, stop the process
            if (col + 1 == m) {
                break;
            }

            // Push the next element from the same list
            int nextVal = arr[row][col + 1];
            minHeap.add(new Node(nextVal, row, col + 1));

            // Update maxVal if necessary
            maxVal = Math.max(maxVal, nextVal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minEl);
        result.add(maxEl);
        return result;
    }
}

/*
 *
 * Dry Run
 * Input: arr = [
 *   [4, 7, 9, 12, 15],
 *   [0, 8, 10, 14, 20],
 *   [6, 12, 16, 30, 50]
 *]
 *
 * Initial: Insert 4, 0, 6 → maxVal = 6
 * Heap: [0, 4, 6] → minVal = 0 → range = 6
 *
 * Pop 0 → Push 8 → Heap = [4, 6, 8], maxVal = 8 → range = 4
 *
 * Pop 4 → Push 7 → Heap = [6, 8, 7], maxVal = 8 → range = 2 → Update minEl = 6, maxEl = 8
 *
 * Pop 6 → Push 12 → Heap = [7, 8, 12], maxVal = 12 → range = 5 → No update
 *
 * Further pops won't lead to smaller range
 * Final result = [6, 8]
 *
 */