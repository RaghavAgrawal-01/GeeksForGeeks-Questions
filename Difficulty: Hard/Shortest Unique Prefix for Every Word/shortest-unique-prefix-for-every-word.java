class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        TrieNode root = new TrieNode();
        for(String word : arr) 
        {
            TrieNode curr = root;
            for(char ch : word.toCharArray()) 
            {
                int idx = ch - 'a';
                if(curr.children[idx] == null)
                {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
                curr.count++;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String word : arr) 
        {
            TrieNode curr = root;
            StringBuilder prefix = new StringBuilder();
            for(char ch : word.toCharArray()) 
            {
                int idx = ch - 'a';
                curr = curr.children[idx];
                prefix.append(ch);
                if(curr.count == 1){
                    break;
                }
            }
            result.add(prefix.toString());
        }
        return result;
    }
}