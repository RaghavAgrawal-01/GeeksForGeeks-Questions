import java.util.*;

class Solution {
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean palindromePair(String[] arr) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String word : arr) {
            
            int n = word.length();
            
            for (int i = 0; i <= n; i++) {
                
                String left = word.substring(0, i);
                String right = word.substring(i);
                
                if (isPalindrome(left)) {
                    
                    String revRight = new StringBuilder(right).reverse().toString();
                    
                    if (map.containsKey(revRight)) {
                        
                        if (!revRight.equals(word) || map.get(revRight) > 1) {
                            return true;
                        }
                    }
                }
                
                if (i != n && isPalindrome(right)) {
                    
                    String revLeft = new StringBuilder(left).reverse().toString();
                    
                    if (map.containsKey(revLeft)) {
                        
                        if (!revLeft.equals(word) || map.get(revLeft) > 1) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}