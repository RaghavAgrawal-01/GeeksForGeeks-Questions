// // Approach: Check every pair of rows. For each pair, check all column pairs to find two columns where both rows have 1s at those columns, indicating four corners of a rectangle.
// // Time Complexity: O(m^2 * n^2), where m is the number of rows and n is the number of columns. For each row pair (O(m^2)), we check all column pairs (O(n^2)).
// // Space Complexity: O(1), no extra space used except loop variables.
// class Solution {
//     public boolean ValidCorner(int[][] mat) {
//         int m = mat.length;        // number of rows
//         int n = mat[0].length;     // number of columns

//         // Try all pairs of rows
//         for (int r1 = 0; r1 < m; r1++) {
//             for (int r2 = r1 + 1; r2 < m; r2++) {
//                 // Check for column pairs where both rows have 1
//                 for (int c1 = 0; c1 < n; c1++) {
//                     for (int c2 = c1 + 1; c2 < n; c2++) {
//                         // If all four corners are 1s, rectangle exists
//                         if (mat[r1][c1] == 1 && mat[r1][c2] == 1 &&
//                             mat[r2][c1] == 1 && mat[r2][c2] == 1) {
//                             return true;
//                         }
//                     }
//                 }
//             }
//         }

//         return false;  // No valid rectangle found
//     }
// }

// /*
//  *
//  * Dry Run
//  *
//  * Input matrix:
//  *[[1, 0, 0, 1, 0],
//  * [0, 0, 1, 0, 1],
//  * [0, 0, 0, 1, 0],
//  * [1, 0, 1, 0, 1]]
//  *
//  * Let’s iterate:
//  * r1 = 1, r2 = 3
//  * Now check column pairs (2, 4)
//  * mat[1][2] = 1, mat[1][4] = 1
//  * mat[3][2] = 1, mat[3][4] = 1
//  * All four corners are 1 → rectangle found → return true
//  *
//  * Output: true
//  */












// Approach 2: For each row, collect indices of columns having 1. For each pair of such columns, create a unique key (col1_col2).
// If this key already exists in the set, it means some previous row also had 1s in these two columns => forms a rectangle.
// Time Complexity: O(m * n^2), where m = number of rows and n = number of columns. Each row can have up to n columns with 1s → O(n^2) pairs.
// Space Complexity: O(n^2), for storing all column index pairs in the HashSet.
class Solution {
    public boolean validCorner(int[][] mat) {
        int r = mat.length;                    // number of rows
        int c = mat[0].length;                 // number of columns
        HashSet<String> set = new HashSet<>(); // to store seen column pairs
        for(int i = 0; i < r; i++)
        {
            List<Integer> cols = new ArrayList<>();  // store column indices with 1s in current row
            for(int j = 0; j < c; j++)
            {
                if(mat[i][j] == 1) {
                    cols.add(j);
                }
            }
            // check all pairs of 1s in the row
            for(int x = 0; x < cols.size(); x++)
            {
                for(int y = x + 1; y < cols.size(); y++)
                {
                    String pair = cols.get(x) + "_" + cols.get(y);
                    if(set.contains(pair))
                    {
                        return true;  // rectangle found
                    }
                    set.add(pair);
                }
            }
        }
        return false;  // no rectangle found
    }
}

/*
 *
 * Dry Run
 *
 * Input matrix:
 *[[1, 0, 0, 1, 0],
 * [0, 0, 1, 0, 1],
 * [0, 0, 0, 1, 0],
 * [1, 0, 1, 0, 1]]
 *
 * Row 0: columns with 1 → [0, 3] → insert "0_3"
 * Row 1: columns with 1 → [2, 4] → insert "2_4"
 * Row 2: columns with 1 → [3] → no pair
 * Row 3: columns with 1 → [0, 2, 4]
 * Check "0_2" → not in set → insert
 * Check "0_4" → not in set → insert
 * Check "2_4" → FOUND in set! → return true
 *
 * Output: true
 */