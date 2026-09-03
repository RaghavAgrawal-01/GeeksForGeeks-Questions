class Solution {
    public ArrayList<String> generateGrayCodes(int n) {
        ArrayList<String> res = new ArrayList<>();
        res.add("0");
        res.add("1");

        if (n == 1) return res;

        for (int i = 2; i <= n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j));
            }
            for (int j = 0; j < size; j++) {
                res.set(j, "0" + res.get(j));
            }
            for (int j = size; j < 2 * size; j++) {
                res.set(j, "1" + res.get(j));
            }
        }

        return res;
    }
}