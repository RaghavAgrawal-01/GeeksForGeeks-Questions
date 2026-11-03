class Solution {
    public boolean sameFreq(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        Map<Integer, Integer> countFreq = new HashMap<>();
        for(int freq : freqMap.values()) {
            countFreq.put(freq, countFreq.getOrDefault(freq, 0) + 1);
        }
        if(countFreq.size() == 1) {
            return true;
        }
        if(countFreq.size() == 2) {
            List<Integer> freqs = new ArrayList<>(countFreq.keySet());
            int f1 = freqs.get(0), f2 = freqs.get(1);
            int c1 = countFreq.get(f1), c2 = countFreq.get(f2);
            // Case 1: One freq is 1 and only occurs once
            if((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return true;
            // Case 2: One freq is 1 more than other and occurs only once
            if((Math.abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) return true;
        }
        return false;
    }
}