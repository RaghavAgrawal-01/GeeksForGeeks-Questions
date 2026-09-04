class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        int[] f = new int[26];
        for(char c : s.toCharArray()){
            f[c- 'a']++;
        }
        int oddCount=0;
        for(int count : f){
            if(count % 2 != 0){
                oddCount++;
            }
        }
        return oddCount <=1;
    }
}