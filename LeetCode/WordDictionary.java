//https://leetcode.com/problems/add-and-search-word-data-structure-design/
class WordDictionary {
    TrieNode root = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int k, TrieNode root) {
        if (k == word.length()) return root.isEnd;
        char c = word.charAt(k);
        if (c != '.') {
            int index = c - 'a';
            return root.children[index] == null ? false : search(word, k+1, root.children[index]);
        }
        else {
            for (int i=0; i<26; i++) {
                TrieNode node = root.children[i];
                if (node != null && search(word, k+1, node)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
