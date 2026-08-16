class Solution {
    public String lexicographicallySmallest(String s, int k) {

        int n = s.length();

        // check power of 2
        if((n & (n - 1)) == 0) {
            k = k / 2;
        } else {
            k = k * 2;
        }

        if(k > n) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {

            while(k > 0 && sb.length() > 0 &&
                  sb.charAt(sb.length() - 1) > s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(s.charAt(i));
        }

        // if still k left, remove from end
        while(k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        if(sb.length() == 0) {
            return "-1";
        }

        return sb.toString();
    }
}