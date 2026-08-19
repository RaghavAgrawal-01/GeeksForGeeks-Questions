class Solution {
    static boolean isBinaryPalindrome(long N) {
        String binary = Long.toBinaryString(N);
        int i = 0;
        int j = binary.length() - 1;
        while(i < j)
        {
            if(binary.charAt(i) != binary.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}