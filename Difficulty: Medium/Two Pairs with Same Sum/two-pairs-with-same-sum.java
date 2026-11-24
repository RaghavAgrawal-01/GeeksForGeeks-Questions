class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }
        int[] best = null;
        for(ArrayList<int[]> pairs : map.values()) {
            int m = pairs.size();
            for(int p1 = 0; p1 < m; p1++) {
                int a = pairs.get(p1)[0];
                int b = pairs.get(p1)[1];
                if(best != null && a > best[0]) {
                    break;
                }
                for(int p2 = p1 + 1; p2 < m; p2++) {
                    int c = pairs.get(p2)[0];
                    int d = pairs.get(p2)[1];
                    if(a != c && a != d && b != c && b != d) {
                        int[] cand = new int[]{a, b, c, d};
                        if(best == null || isSmaller(cand, best)) {
                            best = cand;
                        }
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(best == null) {
            for(int i = 0; i < 4; i++) {
                ans.add(-1);
            }
        }
        else {
            for(int val : best) {
                ans.add(val);
            }
        }
        return ans;
    }

    private boolean isSmaller(int[] x, int[] y) {
        for(int i = 0; i < 4; i++) {
            if(x[i] != y[i]) {
                return x[i] < y[i];
            }
        }
        return false;
    }
}