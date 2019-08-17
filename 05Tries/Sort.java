//Create Trie => Trie trie = new Trie();
//getRoot => trie.getRoot();
//Insert a Word => trie.insert(key,value); where key is string, and value is int
//Search a Word => trie.search(key); return true or false
//Delete a Word => trie.delete(key);
//TrieNode => {TrieNode[] children, boolean isEndWord, int value, 
//markAsLeaf(int val), unMarkAsLeaf()}
class Sort {

  public static ArrayList<String> sortArray(String[] arr) {
    ArrayList<String> result = new ArrayList<String>();
    Trie trie = new Trie();
    for (int i=0; i<arr.length; i++) {
      trie.insert(arr[i], i);
    }
    sortArray(trie.getRoot(), result, "");
    return result;
  }

  public static void sortArray(TrieNode root, ArrayList<String> result, String str) {
    if (root.isEndWord) {
      result.add(new String(str)+",");
    }

    for (int i=0; i<root.children.length; i++) {
      if (root.children[i] != null) {
        char c = (char) (i + 'a');
        str = str + c;
        sortArray(root.children[i], result, str);
        str = str.substring(0,str.length() - 1);
      }
    }
  }
}
