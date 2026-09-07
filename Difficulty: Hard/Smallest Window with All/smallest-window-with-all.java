class Solution {
    public static String minWindow(String s, String p) {
        if (p.length() > s.length()) {
            return "";
        }
        int[] phash = new int[256];
        for (char ch : p.toCharArray()) {
            phash[ch]++;
        }
        int[] shash = new int[256];
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            shash[ch]++;
            if(phash[ch] != 0 && shash[ch] <= phash[ch]) {
                count++;
            }
            while(count == p.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                shash[leftChar]--;

                if (phash[leftChar] != 0 && shash[leftChar] < phash[leftChar]) {
                    count--;
                }

                left++;
            }
        }
        if(startIndex == -1) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }
}