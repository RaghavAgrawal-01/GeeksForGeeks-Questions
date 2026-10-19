class Solution {
    // Time Complexity :- O(32.r.log(c));
    // Space Complexity :- O(1);
    
        // Brute Force
        // Time Complexity :- O(r.c);
        // Space Complexity :- O(r.c);
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int[] val : matrix) {
        //     for(int v1 : val) {
        //         list.add(v1);
        //     }
        // }
        // Collections.sort(list);
        // int idx = (R*C)/2;
        // if(R%2==0 || C%2==0) idx--;
        // return list.get(idx);
        
    int median(int matrix[][]) {
        int R = matrix.length;
        int C = matrix[0].length;

        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        
        for (int i = 0; i < R; i++) {
            lo = Math.min(lo, matrix[i][0]);
            hi = Math.max(hi, matrix[i][C - 1]);
        }

        int required_value = (R * C) / 2;
        if (R % 2 == 0 || C % 2 == 0) required_value--;

        int ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            int count = 0;
            for (int i = 0; i < R; i++) {
                count += search(matrix[i], mid);
            }
            
            if (count <= required_value) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        return ans;
    }
    
    public static int search(int[] a, int v) {
        int lo = 0, hi = a.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= v) {
                lo = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                hi = mid - 1;
            }
        }
        return ans + 1;
    }
}