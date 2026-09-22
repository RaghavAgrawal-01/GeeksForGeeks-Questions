class Solution {
    public String findLongestWord(String s, List<String> d) {
        // code here
        ArrayList<Integer>[] pos = new ArrayList[26];
        for(int i = 0; i < 26; i++)
        {
            pos[i] = new ArrayList<>();
        }
        for(int i = 0; i < s.length(); i++)
        {
            pos[s.charAt(i) - 'a'].add(i);
        }
        String bestWord = "";
        for(String word : d)
        {
            if(isSubsequence(word, pos))
            {
                if(word.length() > bestWord.length() || 
                   (word.length() == bestWord.length() && word.compareTo(bestWord) < 0)) {
                    bestWord = word;
                }
            }
        }
        return bestWord;
    }
    private boolean isSubsequence(String word, ArrayList<Integer>[] pos) {
        int lastIdx = -1;
        for(int i = 0; i < word.length(); i++)
        {
            int c = word.charAt(i) - 'a';
            ArrayList<Integer> list = pos[c];
            if(list.isEmpty()) return false;
            int next = upperBound(list, lastIdx);
            if(next == -1) return false;
            lastIdx = next;
        }
        return true;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(list.get(mid) > target) {
                ans = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}