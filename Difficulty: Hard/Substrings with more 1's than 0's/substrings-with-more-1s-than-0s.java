class Solution {
    class BIT {
        int[] bit;
        int n;

        BIT(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while(idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while(idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countSubstring(String s) {
        int n = s.length();
        int[] pref = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + (s.charAt(i - 1) == '1' ? 1 : -1);
        }

        int[] temp = pref.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for(int x : temp) {
            if(!map.containsKey(x))
                map.put(x, idx++);
        }

        BIT bit = new BIT(idx);
        long ans = 0;

        for(int x : pref) {
            int pos = map.get(x);
            ans += bit.query(pos - 1);
            bit.update(pos, 1);
        }

        return (int)ans;
    }
}