class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
    }

    public static int countSubs(String s) {
        TrieNode root = new TrieNode();
        int n = s.length();
        int distinct = 0;

        for(int i = 0; i < n; i++)
        {
            TrieNode curr = root;
            for(int j = i; j < n; j++)
            {
                int idx = s.charAt(j) - 'a';
                if(curr.child[idx] == null)
                {
                    curr.child[idx] = new TrieNode();
                    distinct++;  
                }
                
                curr = curr.child[idx];
            }
        }
        
        return distinct;
    }
}