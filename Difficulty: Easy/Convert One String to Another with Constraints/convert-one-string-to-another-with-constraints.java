class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != '#') {
                t1.append(c1);
            }
            if (c2 != '#') {
                t2.append(c2);
            }
        }

        if (!t1.toString().equals(t2.toString())) {
            return false;
        }

        int i1 = 0, i2 = 0;
        while (i1 < n && i2 < n) {
            while (i1 < n && s1.charAt(i1) == '#') {
                i1++;
            }
            while (i2 < n && s2.charAt(i2) == '#') {
                i2++;
            }

            if (i1 < n && i2 < n) {
                if (s1.charAt(i1) != s2.charAt(i2)) {
                    return false;
                }
                if (s1.charAt(i1) == 'A' && i1 < i2) {
                    return false;
                }
                if (s1.charAt(i1) == 'B' && i1 > i2) {
                    return false;
                }
                i1++;
                i2++;
            }
        }

        return true;
    }
}