class Trie {
    
    private class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
    }
    private final Node root;
    public Trie() {
        // Implement Trie
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node current=root;
        for(char ch: word.toCharArray())
        {
            int index=ch-'a';
            if(current.children[index]==null)
            {
                current.children[index]=new Node();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node current = root;
        for(char ch:word.toCharArray())
        {
            int index= ch-'a';
            if(current.children[index]==null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String prefix) {
        Node current = root;
        for(char ch:prefix.toCharArray())
        {
            int index = ch-'a';
            if(current.children[index]==null)
            {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}