class Solution {
    public int countBalanced(String[] arr) {
        // code here
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        int result = 0;
        int prefixDiff = 0; 
        for(String s : arr) {
            int vowelsCount = 0, consonantsCount = 0;
            for(char ch : s.toCharArray())
            {
                if (vowels.contains(ch)) vowelsCount++;
                else consonantsCount++;
            }
            prefixDiff += (vowelsCount - consonantsCount);
            result += map.getOrDefault(prefixDiff, 0);
            map.put(prefixDiff, map.getOrDefault(prefixDiff, 0) + 1);
        }
        return result;
    }
}