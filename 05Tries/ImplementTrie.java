class TrieNode {
    HashMap<Character, TrieNode> nodeMap;
    boolean isEnd;
    
    public TrieNode() {
        nodeMap = new HashMap<Character, TrieNode>();
    }  
    
    public boolean containsKey(char c) {
        return nodeMap.containsKey(c);
    }  
    
    public void put(char c, TrieNode node) {
        nodeMap.put(c, node);
    }
    
    public TrieNode get(char c) {
        return nodeMap.get(c);
    }
    
    public void setEnd(boolean end) {
        isEnd = end;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                return false;
            }
            else {
                node = node.get(c);
            }
        }
        if (node.isEnd()) 
            return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.containsKey(c)) {
                return false;
            }
            else {
                node = node.get(c);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
