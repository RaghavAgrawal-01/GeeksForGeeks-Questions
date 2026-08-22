class Solution {
    int transform(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return -1;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[] freq = new int[256];
        for(char c : a) freq[c]++;
        for(char c : b) freq[c]--;
        for(int x : freq) {
            if (x != 0) return -1;
        }
        int i = a.length - 1;
        int j = b.length - 1;
        int steps = 0;
        while(i >= 0)
        {
            if(a[i] == b[j]) {
                i--;
                j--;
            }
            else {
                steps++;
                i--;
            }
        }

        return steps;
    }
}