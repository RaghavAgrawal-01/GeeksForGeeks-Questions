import java.util.*;

class Solution {
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void buildTree(int node, int start, int end, int[] arr, int[] tree) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(2 * node, start, mid, arr, tree);
        buildTree(2 * node + 1, mid + 1, end, arr, tree);
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    private int queryTree(int node, int start, int end, int l, int r, int[] tree) {
        if(r < start || end < l) {
            return 0;
        }
        if(l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftGcd = queryTree(2 * node, start, mid, l, r, tree);
        int rightGcd = queryTree(2 * node + 1, mid + 1, end, l, r, tree);
        return gcd(leftGcd, rightGcd);
    }

    private void updateTree(int node, int start, int end, int idx, int val, int[] tree) {
        if(start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if(start <= idx && idx <= mid) {
            updateTree(2 * node, start, mid, idx, val, tree);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, val, tree);
        }
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] tree = new int[4 * n];
        buildTree(1, 0, n - 1, arr, tree);

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<queries.length;i++) {
            int type = queries[i][0];
            if(type == 0) {
                int l = queries[i][1];
                int r = queries[i][2];
                result.add(queryTree(1, 0, n - 1, l, r, tree));
            } else if(type == 1) {
                int idx = queries[i][1];
                int val = queries[i][2];
                updateTree(1, 0, n - 1, idx, val, tree);
            }
        }

        return result;
    }
}