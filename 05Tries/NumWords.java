//TrieNode => {TrieNode[] children, boolean isEndWord, int value, 
//access root => getRoot()
//markAsLeaf(int val), unMarkAsLeaf()}
class NumWords {
  static int count = 0;
  public static int totalWords(TrieNode root) {
    if (root.isEndWord) {
        count++;
    }
    for (int i=0; i<root.children.length; i++) {
      if (root.children[i] != null) {
          totalWords(root.children[i]);
      }
    }
    return count;
  }
}
